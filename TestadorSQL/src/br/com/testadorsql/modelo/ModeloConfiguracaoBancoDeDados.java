package br.com.testadorsql.modelo;

public class ModeloConfiguracaoBancoDeDados {
	private String driver;
	private String stringDeConexao;
	private String usuario;
	private String senha;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getStringDeConexao() {
		return stringDeConexao;
	}
	public void setStringDeConexao(String stringDeConexao) {
		this.stringDeConexao = stringDeConexao;
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
}
