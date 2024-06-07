package mensagem;

import java.sql.Date;

public class Usuario {

	private String idUsuario;
	private String senha;
	private Date dataCadastro;
	
	public Usuario(String idUsuario, String senha, Date dataCadastro) {
		super();
		this.idUsuario = idUsuario;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
	}

	private String login(String usuario) {
		//Todo codigo para logar o cliente ou admin na pagina para poder ver as mensagens
		if (usuario.equalsIgnoreCase("admin")) {
			return "Bem-vindo - voce tem novas 9 mensagens";
		}else {
			return "Bem-Vindo";
		}
		 
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	
}
