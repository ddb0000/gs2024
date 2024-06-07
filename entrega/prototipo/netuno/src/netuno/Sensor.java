package netuno;

import java.util.Random;

public class Sensor {
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
