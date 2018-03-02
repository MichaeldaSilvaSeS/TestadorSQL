package br.com.testadorsql.bancodedados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BancoDeDadosPlanoDeTesteBancoDeDados {
	
	private FabricaDeConexaoLocal fabricaDeConexao;

	public BancoDeDadosPlanoDeTesteBancoDeDados(FabricaDeConexaoLocal fabricaDeConexao) {
		super();
		this.fabricaDeConexao = fabricaDeConexao;
	}
	
	public void criar(Connection conexao, String nome){
		try {
			PreparedStatement criarComandoSQL = fabricaDeConexao.criarComandoSQL(conexao, "sql_plano_de_teste_insert");
			int index = 0;
			criarComandoSQL.setString(++index, nome);
			criarComandoSQL.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<String> listar(Connection conexao){
		LinkedList<String> retorno = new LinkedList<>();
		try {
			PreparedStatement criarComandoSQL = fabricaDeConexao.criarComandoSQL(conexao, "sql_plano_de_teste_select");
			ResultSet result = criarComandoSQL.executeQuery();
			while(result.next())
				retorno.add(result.getString(1));
			return retorno;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
