package exercicio2;

public class Usuario {
	private int codigo;
	private String login;
	private String senha;
	private String sexo;
	
	public Usuario() {
		this.codigo = -1;
		this.login = "";
		this.senha = "";
		this.sexo = "*";
	}
	
	public Usuario(int codigo, String login, String senha, String sexo) {
		this.codigo = codigo;
		this.login = login;
		this.senha = senha;
		this.sexo = sexo.charAt(0)+"";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo.charAt(0)+"";
	}

	@Override
	public String toString() {
		return "Usu�rio [codigo= " + codigo + ", login= " + login + ", senha= " + senha + ", sexo= " + sexo + "]";
	}	
}