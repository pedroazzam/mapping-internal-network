package vlg.access.mapping.model;

public class Login {
	private int id;
	private String nome;
	
	
	private String login;
	private String senha;
	
	private String user_Network;
	private String senha_Network;
	
	
	public String getUser_Network() {
		return user_Network;
	}
	public void setUser_Network(String user_Network) {
		this.user_Network = user_Network;
	}
	public String getSenha_Network() {
		return senha_Network;
	}
	public void setSenha_Network(String senha_Network) {
		this.senha_Network = senha_Network;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
