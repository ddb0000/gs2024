package mensagem;

import java.util.Date;

public class Plastico {
	
	private String nome;
	private String abreviacao;
	private String densidade;
	private int quantidade;
	private Date dataColeta;
	
	
	public Plastico(String nome, String abreviacao, String densidade, int quantidade, Date dataColeta) {
		super();
		this.nome = nome;
		this.abreviacao = abreviacao;
		this.densidade = densidade;
		this.quantidade = quantidade;
		this.dataColeta = dataColeta;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAbreviacao() {
		return abreviacao;
	}
	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}
	public String getDensidade() {
		return densidade;
	}
	public void setDensidade(String densidade) {
		this.densidade = densidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getDataColeta() {
		return dataColeta;
	}
	public void setDataColeta(Date dataColeta) {
		this.dataColeta = dataColeta;
	}

}
