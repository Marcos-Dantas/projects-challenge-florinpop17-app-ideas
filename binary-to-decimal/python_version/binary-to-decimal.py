from flask import Flask
from flask import render_template
from flask import request
from utils import convert_to_decimal

app = Flask(__name__)
# alem de poder definir os metodos no decorator
# e possivel definir na rota com app.get('/') e app.post('/')

@app.get("/binary-convert-decimal")
def index():
    return render_template('convert-binary.html')

@app.post("/convert-value")
def convert_value():
    value = request.json['value']
    value_in = request.json['value_in']
    if request.json['convert_to'] == 'decimal':
        # convert value to binary
        result = convert_to_decimal(value, value_in)

    return f'{result}'