package br.com.testadorsql.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class FabricaDeConexao {
	private static ResourceBundle CONFIGURACAO_CONEXAO = ResourceBundle.getBundle("br.com.testadorsql.bancodedados.bundle.conexao");
	private static String DRIVE;
	private static String URL;
	private static String USUARIO;
	private static String SENHA;
	private static String PREFIXO_COMANDO_SQL = "sql_";
	
	static {
		DRIVE = CONFIGURACAO_CONEXAO.getString("drive").trim();
		URL = CONFIGURACAO_CONEXAO.getString("url").trim();
		USUARIO = CONFIGURACAO_CONEXAO.getString("usuario").trim();
		SENHA = CONFIGURACAO_CONEXAO.getString("senha").trim();
		
		try {
			Class.forName(DRIVE);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String comandoSQL(String nome){
		return CONFIGURACAO_CONEXAO.getString(PREFIXO_COMANDO_SQL.concat(nome));
	}
	
	public PreparedStatement criarComandoSQL(Connection conexao, String nome) throws SQLException{
		String comandoSQL = comandoSQL(nome);
		return conexao.prepareStatement(comandoSQL);
	}
	
	public PreparedStatement criarComandoSQL(String nome) throws SQLException{
		String comandoSQL = comandoSQL(nome);
		return criarConexao().prepareStatement(comandoSQL);
	}
	
	public Connection criarConexao(){
		try {
			return DriverManager.getConnection(URL,USUARIO,SENHA);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void executaSQLDeCriacao(){
		Enumeration<String> keys = CONFIGURACAO_CONEXAO.getKeys();
		try {
			
			Connection conexao = criarConexao();
			while(keys.hasMoreElements()){
				String key = keys.nextElement();
				
				if(key.startsWith(PREFIXO_COMANDO_SQL) && key.endsWith("_create")){
					PreparedStatement statement = criarComandoSQL(conexao, key.substring(PREFIXO_COMANDO_SQL.length()));
					statement.execute();
					
					if(!statement.isClosed())
						statement.close();
				}
			}
			
			if(!conexao.isClosed())
				conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
