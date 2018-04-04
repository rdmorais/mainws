package mainWS;

public class Usuario {
	
	private int 		id;
	private String 		nome;
	private String 		usuario;
	private String 		senha;
	private int 		status;
	private String 		cad_datahora;
	
	public Usuario() {	
	}

	public Usuario(int id, String nome, String usuario, String senha, int status, String cad_datahora) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.status = status;
		this.cad_datahora = cad_datahora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCad_datahora() {
		return cad_datahora;
	}

	public void setCad_datahora(String cad_datahora) {
		this.cad_datahora = cad_datahora;
	}
	
	
	
	

}
