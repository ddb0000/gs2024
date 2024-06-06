import time
import requests
import random
import sys

class Sensor:
    def __init__(self, id, tipo, automato_id):
        """
        Inicializa o sensor com um ID, tipo e ID do autômato associado.
        """
        self.id = id
        self.tipo = tipo
        self.automato_id = automato_id

    def coletar_dados(self):
        """
        Simula a coleta de dados baseados no tipo de sensor.
        """
        if self.tipo == 'temperatura':
            return round(random.uniform(10, 30), 2)
        elif self.tipo == 'ph':
            return round(random.uniform(6.5, 8.5), 2)
        elif self.tipo == 'microplasticos':
            return round(random.uniform(0.1, 5.0), 2)

class AutomatoNetuno:
    def __init__(self, id, server_url):
        """
        Inicializa o autômato com um ID e a URL do servidor central.
        """
        self.id = id
        self.server_url = server_url
        self.sensores = self.registrar_sensores()

    def registrar_sensores(self):
        """
        Registra sensores para o autômato no servidor central.
        """
        tipos_de_sensores = ['temperatura', 'ph', 'microplasticos']
        sensores = []
        for tipo in tipos_de_sensores:
            response = requests.post(f"{self.server_url}/sensor", json={"tipo": tipo, "automato_id": self.id})
            if response.status_code == 201:
                sensor_id = response.json()['id']
                sensores.append(Sensor(sensor_id, tipo, self.id))
            else:
                print(f"Falha ao registrar sensor de tipo {tipo}: {response.text}")
        return sensores

    def enviar_dados(self, sensor, valor):
        """
        Envia os dados coletados para o servidor central.
        """
        dados = {
            "automato_id": self.id,
            "sensor_id": sensor.id,
            "valor": valor
        }
        try:
            response = requests.post(f"{self.server_url}/dados", json=dados)
            if response.status_code == 200:
                print(f"Dados enviados: {dados}")
            else:
                print(f"Falha ao enviar dados: {response.text}")
        except Exception as e:
            print(f"Erro ao enviar dados: {e}")

    def iniciar(self):
        """
        Inicia o processo de coleta e envio de dados em um loop infinito.
        """
        while True:
            for sensor in self.sensores:
                valor = sensor.coletar_dados()
                self.enviar_dados(sensor, valor)
            time.sleep(30)  # Envia dados a cada 30 segundos para teste

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Uso: python automato.py <id>")
        sys.exit(1)
    
    automato_id = int(sys.argv[1])
    server_url = "http://127.0.0.1:8000/api"  # URL do servidor local

    # Registrar o autômato se ainda não existir
    response = requests.post(f"{server_url}/automato", json={"nome": f"Automato {automato_id}"})
    if response.status_code == 201:
        print(f"Autômato {automato_id} criado com sucesso")
    else:
        print(f"Falha ao criar o autômato: {response.text}")

    automato = AutomatoNetuno(id=automato_id, server_url=server_url)
    automato.iniciar()
