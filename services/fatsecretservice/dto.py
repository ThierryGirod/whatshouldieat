from typing import Optional
from pydantic import BaseModel


class Recipe(BaseModel):
    """App internal recipe structure used in most of the services
    """
    name: str
    ingredients: Optional[str]
    imageUrl: Optional[str]
    fatsecretRecipeId: Optional[str]
