package mensagem;

import java.util.Date;

public class Netuno extends Plastico{
	
	public Netuno(String nome, String abreviacao, String densidade, int quantidade, Date dataColeta) {
		super(nome, abreviacao, densidade, quantidade, dataColeta);
		// TODO Auto-generated constructor stub
	}
	private int temperatura;
	private int ph;
	
	public void contador() {
		
	}
		
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}

}
