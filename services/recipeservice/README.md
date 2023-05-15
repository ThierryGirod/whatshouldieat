# Recipe Service
The recipe service provides and manages the user's recipes.

## Provided endpoints
```
GET: /recipes
```
Get bootstrap list of recipes (provided for new users if desired)

```
GET: /recipes/{userid}
```
Get all recipes for user

```
POST: /recipes/{userid}
```
Store new recipe for user

```
PUT: /recipes/{userid}/{recipeid}
```
Update existing recipe for user with recipeid

```
DELETE: /recipes/{userid}/{recipeid}
```
Delete existing recipe for user with recipeid

## Security
All endpoints are protected and a JWT Token is needed.

## Development notes:
To run start the project locally run
```
    ./mvnw clean spring-boot:run
```
Make sure to have a mongodb running on you local machine for example using docker:

```
    docker pull mongo
    docker run -p 27017:27017 mongo
```

or use provided docker-compose file
```
    docker-compose up
```
