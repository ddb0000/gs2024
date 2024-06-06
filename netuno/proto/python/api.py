from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from flask_cors import CORS
import datetime

# Inicializa a aplicação Flask
app = Flask(__name__)
CORS(app)

# Configuração do banco de dados SQLite
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///dados.db'
db = SQLAlchemy(app)

# Definição do modelo de dados para armazenar informações ambientais
class Automato(db.Model):
    id = db.Column(db.Integer, primary_key=True)  # Chave primária
    nome = db.Column(db.String(50), nullable=False)  # Nome do autômato

class Sensor(db.Model):
    id = db.Column(db.Integer, primary_key=True)  # Chave primária
    tipo = db.Column(db.String(50), nullable=False)  # Tipo de sensor (ex: temperatura, pH)
    automato_id = db.Column(db.Integer, db.ForeignKey('automato.id'), nullable=False)  # ID do autômato

class DadosAmbientais(db.Model):
    id = db.Column(db.Integer, primary_key=True)  # Chave primária
    automato_id = db.Column(db.Integer, db.ForeignKey('automato.id'), nullable=False)  # ID do autômato
    sensor_id = db.Column(db.Integer, db.ForeignKey('sensor.id'), nullable=False)  # ID do sensor
    data_coleta = db.Column(db.DateTime, default=datetime.datetime.utcnow)  # Data e hora da coleta de dados
    valor = db.Column(db.Float, nullable=False)  # Valor coletado pelo sensor

@app.route('/api/automato', methods=['POST'])
def criar_automato():
    """
    Cria um novo autômato no banco de dados.
    """
    dados = request.get_json()
    novo_automato = Automato(nome=dados['nome'])
    db.session.add(novo_automato)
    db.session.commit()
    return jsonify({"message": "Autômato criado com sucesso", "id": novo_automato.id}), 201

@app.route('/api/sensor', methods=['POST'])
def criar_sensor():
    """
    Cria um novo sensor no banco de dados.
    """
    dados = request.get_json()
    novo_sensor = Sensor(tipo=dados['tipo'], automato_id=dados['automato_id'])
    db.session.add(novo_sensor)
    db.session.commit()
    return jsonify({"message": "Sensor criado com sucesso", "id": novo_sensor.id}), 201

@app.route('/api/dados', methods=['POST'])
def receber_dados():
    """
    Recebe dados enviados pelos autômatos e cria uma nova entrada no banco de dados.
    """
    dados = request.get_json()
    nova_entrada = DadosAmbientais(
        automato_id=dados['automato_id'],
        sensor_id=dados['sensor_id'],
        valor=dados['valor']
    )
    db.session.add(nova_entrada)
    db.session.commit()
    return jsonify({"message": "Dados recebidos com sucesso"}), 200

@app.route('/api/dados', methods=['GET'])
def obter_todos_dados():
    """
    Retorna todos os dados ambientais armazenados no banco de dados.
    """
    dados = DadosAmbientais.query.all()
    resultado = [
        {
            "automato_id": dado.automato_id,
            "sensor_id": dado.sensor_id,
            "data_coleta": dado.data_coleta,
            "valor": dado.valor
        } for dado in dados
    ]
    return jsonify(resultado), 200

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
    app.run(host='0.0.0.0', port=8000)
