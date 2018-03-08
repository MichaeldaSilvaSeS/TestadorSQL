package br.com.testadorsql.bancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.testadorsql.modelo.ModeloTipoDeScript;

public class BancoDeDadosTipoDeScript {
	private FabricaDeConexaoLocal fabricaDeConexao;

	public BancoDeDadosTipoDeScript(FabricaDeConexaoLocal fabricaDeConexao) {
		super();
		this.fabricaDeConexao = fabricaDeConexao;
	}
	
	public List<ModeloTipoDeScript> listar(){
		LinkedList<ModeloTipoDeScript> lista = new LinkedList<>();
		try {
			PreparedStatement criarComandoSQL = fabricaDeConexao.criarComandoSQL("tipo_script_select");
			ResultSet result = criarComandoSQL.executeQuery();
			while(result.next()){
				ModeloTipoDeScript modelo = new ModeloTipoDeScript();
				int index = 0;
				
				modelo.setId(result.getInt(++index));
				modelo.setTipo(result.getString(++index));
				lista.add(modelo);
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
