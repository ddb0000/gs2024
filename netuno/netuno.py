"""
Simula um autômato que coleta microplásticos e dados ambientais.
"""
import time
import random

class MicroplasticsAutomaton:
    def __init__(self):
        self.name = "Netuno RX42"
        self.state = "off"
        self.plastic_collected = 0
        self.data_collected = {}

    def start(self):
        self.state = "ON"
        print(f"{self.name} ON.")
        while self.state == "ON":
            self.simulate_operation()
            time.sleep(1)

    def stop(self):
        self.state = "off"
        print(f"{self.name} off.")

    def simulate_operation(self):
        if random.random() < 0.2:
            self.collect_microplastics()

        temp = 20 + random.uniform(-2, 2)
        ph = 7.5 + random.uniform(-0.5, 0.5)
        self.data_collected[f"{time.time():.0f}"] = {"temperatura": temp, "pH": ph}
        print(f"{self.name} coletou dados: temp={temp:.1f}°C, pH={ph:.1f}")

    def collect_microplastics(self):
        amount = random.randint(1, 10)
        self.plastic_collected += amount
        print(f"{self.name} coletou {amount} microplásticos. Total: {self.plastic_collected}")

automaton = MicroplasticsAutomaton()
automaton.start()

time.sleep(30)
automaton.stop()
