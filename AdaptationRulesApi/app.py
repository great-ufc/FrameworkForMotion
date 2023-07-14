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
        
@app.route('/POC1/')
def poc1():
    import platform
    so = platform.system()
    if so == "Windows":
        return  send_file("download\\AdaptationRulesPoC1.xml", as_attachment=True)
    if so == "Linux":
        return  send_file("download//AdaptationRulesPoC1.xml", as_attachment=True)

@app.route('/POC2/')
def poc2():
    import platform
    so = platform.system()
    if so == "Windows":
        return  send_file("download\\AdaptationRulesPoC2.xml", as_attachment=True)
    if so == "Linux":
        return  send_file("download//AdaptationRulesPoC2.xml", as_attachment=True)

app.run()