import java.util.Random;

class Sensor {
    private int id;
    private String tipo;
    private int automatoId;
    private Random random;

    public Sensor(int id, String tipo, int automatoId) {
        this.id = id;
        this.tipo = tipo;
        this.automatoId = automatoId;
        this.random = new Random();
    }

    public int getId() {
        return id;
    }

    public double coletarDados() {
        if ("temperatura".equals(this.tipo)) {
            return Math.round(random.nextDouble() * (30 - 10) + 10);
        } else if ("ph".equals(this.tipo)) {
            return Math.round(random.nextDouble() * (8.5 - 6.5) + 6.5);
        } else if ("microplasticos".equals(this.tipo)) {
            return Math.round(random.nextDouble() * (5.0 - 0.1) + 0.1);
        }
        return 0.0;
    }
}


class AutomatoNetuno {
    private int id;
    private String serverUrl;
    private Sensor[] sensores;

    public AutomatoNetuno(int id, String serverUrl) {
        this.id = id;
        this.serverUrl = serverUrl;
        this.sensores = registrarSensores();
    }

    private Sensor[] registrarSensores() {
        String[] tiposDeSensores = {"temperatura", "ph", "microplasticos"};
        Sensor[] sensores = new Sensor[tiposDeSensores.length];
        for (int i = 0; i < tiposDeSensores.length; i++) {
            sensores[i] = new Sensor(i + 1, tiposDeSensores[i], this.id);
        }
        return sensores;
    }

    public void enviarDados(Sensor sensor, double valor) {
        // Implementação para enviar dados ao servidor
        System.out.println("Dados enviados: automato_id=" + this.id + ", sensor_id=" + sensor.getId() + ", valor=" + valor);
    }

    public void iniciar() {
        while (true) {
            for (Sensor sensor : sensores) {
                double valor = sensor.coletarDados();
                enviarDados(sensor, valor);
            }
            try {
                Thread.sleep(30000); // 30 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main <id>");
            System.exit(1);
        }

        int automatoId = Integer.parseInt(args[0]);
        String serverUrl = "http://127.0.0.1:8000/api";  // URL do servidor local

        // Registra o automato se ainda não existir
        System.out.println("Registrando o automato...");
        // Implementação para fazer o POST para o servidor e verificar se foi registrado com sucesso

        AutomatoNetuno automato = new AutomatoNetuno(automatoId, serverUrl);
        automato.iniciar();
    }
}
