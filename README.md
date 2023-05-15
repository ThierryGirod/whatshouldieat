# whatshouldieat
Whatshouldieat is a web app that should help you decide what you could eat.

## Do you know that problem?
Your coding all day and your spouse approaches you with the same old question: "what should we eat tonight?"
Of course your deep in the tunnel and have no clue what you you could cook and when you suggest something it's wrong anyway.
That's where whatshouldieat comes into play!
Just refer to the app and tell your better half that she/he should ask the app for suggestions.

## Use Cases covered 
- What can I cook today based on favourite recipes.
- Random recommendation of recipes.
- What can I cook with the ingredients x,y and z left in the fridge?
- Takeouts near me?
- Sharing suggested meal with a partner/friend via whatsapp

## How to run
### locally
Make sure you have docker installed and the images built:

build images:
```
    cd services/recipeservice/
    ./mvnw clean package
    docker build -t whatshouldieat/recipeservice .
```

thereafter, you can start everything locally from the root directory with:

```
docker-compose up
```


