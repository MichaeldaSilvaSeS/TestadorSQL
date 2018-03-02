package br.com.testadorsql.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class FabricaDeConexaoRemota {
	
	private FabricaDeConexaoLocal fabricaDeConexao;

	public FabricaDeConexaoRemota(FabricaDeConexaoLocal fabricaDeConexao) {
		super();
		this.fabricaDeConexao = fabricaDeConexao;
	}
	
	/*
	public String comandoSQL(String nome){
		
	}
	
	public PreparedStatement criarComandoSQL(Connection conexao, String nome) throws SQLException{
		
	}
	*/
	public Connection criarConexao(){
		String driver = "";
		String string_de_conexao = "";
		try {
			PreparedStatement statement = fabricaDeConexao.criarComandoSQL("conexao_remota_select");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				driver = rs.getString(0);
				string_de_conexao = rs.getString(1);
			}
			
			Class.forName(driver);			
			return DriverManager.getConnection(string_de_conexao); 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean testarConexao(String driver,String stringDeConexao, String usuario, String senha) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
		if(!conexao.isClosed()){
			conexao.close();
			return true;
		}		
		return false;		
	}
	
}
