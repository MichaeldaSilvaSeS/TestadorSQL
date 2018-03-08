package br.com.testadorsql.controlador;

import br.com.testadorsql.bancodedados.BancoDeDadosPlanoDeTeste;
import br.com.testadorsql.modelo.FabricaDeModelo;
import br.com.testadorsql.modelo.ModeloPlanoDeTeste;
import br.com.testadorsql.tela.TelaPlanoTeste;
import br.com.testadorsql.tela.TelaPlanoTeste.OuvinteTelaPlanoTeste;

public class ControladorPlanoDeTeste implements OuvinteTelaPlanoTeste, Controlador{
	
	private TelaPlanoTeste telaPlanoTeste;
	private BancoDeDadosPlanoDeTeste bancoDeDadosPlanoDeTeste;
	private ModeloPlanoDeTeste modeloPlanoDeTeste;

	public ControladorPlanoDeTeste(TelaPlanoTeste telaPlanoTeste, BancoDeDadosPlanoDeTeste bancoDeDadosPlanoDeTeste, FabricaDeModelo fabricaDeModelo) {
		this.telaPlanoTeste = telaPlanoTeste;
		this.telaPlanoTeste.setOuvinte(this);
		this.bancoDeDadosPlanoDeTeste = bancoDeDadosPlanoDeTeste;
		this.modeloPlanoDeTeste = fabricaDeModelo.criarModeloPlanoDeTeste();
	}
	
	@Override
	public void carregar() {
		telaPlanoTeste.exibir();
	}

	@Override
	public void adicionar(Integer indice, String script) {
		this.modeloPlanoDeTeste.incluirScript(script);
		this.telaPlanoTeste.incluirScriptNaListagem(script);
	}

	@Override
	public void subir(Integer indice) {
		this.modeloPlanoDeTeste.subirScript(indice);
		this.telaPlanoTeste.limparListagemDeScript();
		
		for(String script: modeloPlanoDeTeste.getScripts())
			this.telaPlanoTeste.incluirScriptNaListagem(script);
	}

	@Override
	public void descer(Integer indice) {
		this.modeloPlanoDeTeste.descerScript(indice);
		this.telaPlanoTeste.limparListagemDeScript();
		
		for(String script: modeloPlanoDeTeste.getScripts())
			this.telaPlanoTeste.incluirScriptNaListagem(script);
	}

	@Override
	public void salvar() {
		try{
			bancoDeDadosPlanoDeTeste.salvar(modeloPlanoDeTeste);
			this.telaPlanoTeste.exibirMensagemDeTesteSucesso("Salvo com sucesso");
		}catch(Exception e){
			this.telaPlanoTeste.exibirMensagemDeTesteFalha(e.getMessage());
		}
	}
}
