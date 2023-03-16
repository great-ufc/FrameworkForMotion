##API PARA Disponibilização do Template de Regras de Adaptação

from flask import Flask, jsonify, send_file, send_from_directory
import os

app = Flask(__name__)

@app.route('/')
def index():
    import platform
    so = platform.system()
    if so == "Windows":
        return  send_file("download\\AdaptationRules.xml", as_attachment=True)
    if so == "Linux":
        return  send_file("download//AdaptationRules.xml", as_attachment=True)

app.run()