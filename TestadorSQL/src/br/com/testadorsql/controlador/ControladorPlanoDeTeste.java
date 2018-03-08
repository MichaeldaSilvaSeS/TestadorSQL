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
	public void adicionar(Integer id, String script) {
		this.modeloPlanoDeTeste.incluirScript(script);
		this.telaPlanoTeste.incluirScriptNaListagem(script);
	}
}
