from flask import Flask
import socket

app = Flask(__name__)

@app.route("/")
def home():
    hostname = socket.gethostname()
    return f"<center><h2>Welcome! Id: {hostname}</h2></center>"

@app.route("/health")
def health():
    return "OK", 200

if __name__ == '__main__':
    app.run('0.0.0.0')
