from typing import Annotated
from fastapi import FastAPI, Query
from dotenv import load_dotenv
import os
import requests
from requests_oauthlib import OAuth1
from dto import Recipe

# Load all environment variables from the .env file
load_dotenv()

app = FastAPI()

# Setup basic oauth1 headers
auth = OAuth1(client_key=os.getenv('FATSECRETAPI_CONSUMER_KEY'),
              client_secret=os.getenv('FATSECRETAPI_CONSUMER_SECRET'),
              signature_method='HMAC-SHA1',
              signature_type='query')


@app.get('/')
async def root_message():
    return {'message': 'Hello from fatsecret api service!'}


@app.get('/recipe')
async def get_recipe(ingredients: Annotated[list[str], Query()]) -> list[Recipe]:
    """Returns a list of reicpes matching the ingredients given as parameters

    Args:
        ingredients (Annotated[list[str], Query): ingredients for the recipe search

    Returns:
        list[Recipe]: list of possible recipes matching the ingredients
    """

    params = {'method': 'recipes.search.v3',
              'format': 'json',
              'search_expression': " ".join(ingredients),
              'sort_by': 'newest'}

    response = requests.get(
        os.getenv('FATSECRETAPI_BASE_URL'), params=params, auth=auth)

    # Map the response data from the fatsecret api to the internal recipe dto structure
    recipes = [Recipe(name=recipe.get('recipe_name'),
                      ingredients=",".join(recipe.get(
                          'recipe_ingredients', {}).get('ingredient', [])),
                      imageUrl=recipe.get('recipe_image'),
                      fatsecretRecipeId=recipe.get('recipe_id'))
               for recipe in response.json().get('recipes', {}).get('recipe', [])]

    return recipes
