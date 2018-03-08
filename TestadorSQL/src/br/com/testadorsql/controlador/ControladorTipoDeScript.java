package br.com.testadorsql.controlador;

import java.util.List;

import br.com.testadorsql.bancodedados.BancoDeDadosTipoDeScript;
import br.com.testadorsql.modelo.ModeloTipoDeScript;

public class ControladorTipoDeScript {
	
	private BancoDeDadosTipoDeScript bancoDeDadosTipoDeScript;

	public ControladorTipoDeScript(BancoDeDadosTipoDeScript bancoDeDadosTipoDeScript) {
		super();
		this.bancoDeDadosTipoDeScript = bancoDeDadosTipoDeScript;
	}
	
	public List<ModeloTipoDeScript> listar(){
		return bancoDeDadosTipoDeScript.listar();
	}	
}
