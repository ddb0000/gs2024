package mensagem;

import java.sql.Date;

public class Administrador extends Usuario{
	
	public Administrador(String idUsuario, String senha, Date dataCadastro, String nomeAdmin, String email) {
		super(idUsuario, senha, dataCadastro);
		this.nomeAdmin = nomeAdmin;
		this.email = email;
	}
	
	private String nomeAdmin;
	private String email;
	
	private void modificadorMensagem() {
		//espaço para logica para modificar as mensagens envidas pelo usuario
	}
	
	public String getNomeAdmin() {
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
