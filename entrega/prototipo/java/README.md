## Simulação do Netuno (Java)

Simula um sistema de coleta de dados ambientais usando sensores e um autômato. Os sensores coletam dados como temperatura, pH e níveis de microplásticos, enquanto o autômato os registra e os envia para um servidor central.

## Como usar
1. Compilação: Compile o arquivo Main.java com o seguinte comando:

    ```sh
    javac Main.java
    ```
2. Execução: Execute o programa com o seguinte comando, fornecendo o ID do autômato como argumento (substitua <id> pelo ID desejado): 

    ```sh
    java Main <id>
    ```

Os dados enviados pelo autômato podem ser visualizados no servidor central ou processados posteriormente conforme necessário.

### Nota
Este projeto é uma simulação e deve ser adaptado e expandido para uso em um ambiente real, incluindo a integração com sensores reais, comunicação segura e armazenamento adequado dos dados coletados.

