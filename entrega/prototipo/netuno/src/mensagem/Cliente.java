package mensagem;

import java.sql.Date;

public class Cliente extends Usuario{
	
	public Cliente(String idUsuario, String senha, Date dataCadastro) {
		super(idUsuario, senha, dataCadastro);
		// TODO Auto-generated constructor stub
	}
	private String nome;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
