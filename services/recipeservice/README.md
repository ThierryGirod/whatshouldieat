# Recipe Service
The recipe service provides and manages the user's recipes.

## Provided endpoints
```
GET: /recipe
```
Get a list of all recipes

```
GET: /recipe?ownerId=xyz
```
Get all recipes for owner (user) xyz
ownerId="bootstrap" can be used as a bootstrap template for new users

```
GET: /recipe/{recipeId}
```
Get recipe by recipeId

```
POST: /recipe
```
Store new recipe for user xyz

```
PUT: /recipe/{recipeid}
```
Update existing recipe for user with recipeid

```
DELETE: /recipe/{recipeid}
```
Delete existing recipe for user with recipeid

## Security
All endpoints are protected and a JWT Token is needed.

## Development notes:
To run start the project locally run
```
    ./mvnw clean spring-boot:run
```
Make sure to have a mongodb running on you local machine for example using docker (linking has to be done manually):

```
    docker pull mongo
    docker run -p 27017:27017 mongo
```

or use provided docker-compose file (suggested)
```
    docker-compose up -d
```
