package netuno;

public class AutomatoNetuno {
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
