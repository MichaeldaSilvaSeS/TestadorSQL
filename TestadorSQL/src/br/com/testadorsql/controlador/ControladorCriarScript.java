package br.com.testadorsql.controlador;

import java.util.List;

import br.com.testadorsql.bancodedados.BancoDeDadosScript;
import br.com.testadorsql.modelo.ModeloTipoDeScript;
import br.com.testadorsql.tela.TelaCriarScript;
import br.com.testadorsql.tela.TelaCriarScript.OuvinteTelaCriarScript;

public class ControladorCriarScript implements OuvinteTelaCriarScript, Controlador{
	private TelaCriarScript telaCriarScript;
	private BancoDeDadosScript bancoDeDadosScript;
	private ControladorTipoDeScript tipoDeScript;

	public ControladorCriarScript(TelaCriarScript telaCriarScript, BancoDeDadosScript bancoDeDadosScript, ControladorTipoDeScript tipoDeScript) {
		super();
		this.telaCriarScript = telaCriarScript;
		this.bancoDeDadosScript = bancoDeDadosScript;
		this.tipoDeScript = tipoDeScript;
	}

	@Override
	public void adicionar(String nome, String tipo) {
		
	}

	@Override
	public void carregar() {
		this.telaCriarScript.setOuvinteTelaCriarScript(this);
		
		List<ModeloTipoDeScript> listar = tipoDeScript.listar();
		for(ModeloTipoDeScript tipo: listar)
			telaCriarScript.adicionar(tipo.getId(), tipo.getTipo());
		
		telaCriarScript.exibir();		
	}

}
