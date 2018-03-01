package br.com.testadorsql.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FabricaDeConexaoRemota {
	
	private FabricaDeConexao fabricaDeConexao;

	public FabricaDeConexaoRemota(FabricaDeConexao fabricaDeConexao) {
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
}
