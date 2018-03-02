package br.com.testadorsql.bancodedados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoDeDadosConfiguracaoBancoDeDados {
	private FabricaDeConexaoRemota fabricaDeConexaoRemota;
	private FabricaDeConexaoLocal fabricaDeConexaoLocal;
	
	public BancoDeDadosConfiguracaoBancoDeDados(FabricaDeConexaoLocal fabricaDeConexaoLocal, FabricaDeConexaoRemota fabricaDeConexaoRemota) {
		super();
		this.fabricaDeConexaoLocal = fabricaDeConexaoLocal;
		this.fabricaDeConexaoRemota = fabricaDeConexaoRemota;
	}
	
	public void salvar(String driver,String stringDeConexao, String usuario, String senha){
		try {
			PreparedStatement criarComandoSQL = fabricaDeConexaoLocal.criarComandoSQL("conexao_remota_insert");
			int index = 0;
			criarComandoSQL.setString(++index, driver);
			criarComandoSQL.setString(++index, stringDeConexao);
			criarComandoSQL.setString(++index, usuario);
			criarComandoSQL.setString(++index, senha);
			criarComandoSQL.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean testarConexao(String driver,String stringDeConexao, String usuario, String senha) throws ClassNotFoundException, SQLException{
		return fabricaDeConexaoRemota.testarConexao(driver, stringDeConexao, usuario, senha);	
	}
}
