from fastapi import FastAPI

app = FastAPI()


@app.get('/')
async def root_message():
    return {'message': 'Hello from fatsecret api service!'}

@app.get('/recipe')
async def get_recipe():
    raise NotImplementedError()