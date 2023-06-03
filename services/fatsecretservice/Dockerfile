FROM python:3.11.3

WORKDIR /code

COPY ./requirements.txt /code/requirements.txt

RUN pip install --no-cache-dir --upgrade -r /code/requirements.txt

COPY ./app.py /code/app.py
COPY ./dto.py /code/dto.py

CMD ["uvicorn", "app:app", "--host", "0.0.0.0", "--port", "80"]