package br.com.testadorsql.bancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.testadorsql.modelo.ModeloPlanoDeTeste;

public class BancoDeDadosPlanoDeTeste {
	
	private FabricaDeConexaoLocal fabricaDeConexao;

	public BancoDeDadosPlanoDeTeste(FabricaDeConexaoLocal fabricaDeConexao) {
		super();
		this.fabricaDeConexao = fabricaDeConexao;
	}
		
	public List<String> listar(){
		LinkedList<String> retorno = new LinkedList<>();
		try {
			PreparedStatement criarComandoSQL = fabricaDeConexao.criarComandoSQL("plano_de_teste_select");
			ResultSet result = criarComandoSQL.executeQuery();
			while(result.next())
				retorno.add(result.getString(1));
			return retorno;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Integer gerarId(){
		Integer id = 0;
		try {
			PreparedStatement criarComandoSQL = fabricaDeConexao.criarComandoSQL("plano_de_teste_id_select");
			ResultSet result = criarComandoSQL.executeQuery();
			while(result.next())
				id = result.getInt(0);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return id;
	}
	
	public void salvar(ModeloPlanoDeTeste modeloPlanoDeTeste){
		try {
			Integer id = gerarId();
			{
				PreparedStatement criarComandoSQL = fabricaDeConexao.criarComandoSQL("plano_de_teste_insert");
				int index = 0;
				criarComandoSQL.setInt(++index, id);
				criarComandoSQL.setString(++index, modeloPlanoDeTeste.getNome());
				criarComandoSQL.execute();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
