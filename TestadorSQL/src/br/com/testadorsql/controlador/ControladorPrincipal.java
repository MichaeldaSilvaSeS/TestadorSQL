package br.com.testadorsql.controlador;

import br.com.testadorsql.tela.TelaPrincipal;
import br.com.testadorsql.tela.TelaPrincipal.OuvinteTelaPrincipal;

public class ControladorPrincipal implements OuvinteTelaPrincipal, Controlador{
	
	private TelaPrincipal telaPrincipal;
	private FabricaControlador fabricaControlador;

	public ControladorPrincipal(TelaPrincipal telaPrincipal, FabricaControlador fabricaControlador) {
		this.telaPrincipal = telaPrincipal;
		this.telaPrincipal.setOuvinte(this);
		this.fabricaControlador = fabricaControlador;
	}
	
	public void sair(){
		telaPrincipal.sairDaAplicacao();
	}
	
	public void sobre(){
		telaPrincipal.exibirTelaSobre();
	}

	public void execucaoSQL() {
		telaPrincipal.exibirTelaExecucao();		
	}

	public void configuracaoBancoDeDados() {
		fabricaControlador.criarControladorConfiguracaoBancoDeDados().carregar();
	}

	public void criarScript() {
		fabricaControlador.criarControladorCriarScript().carregar();
	}

	public void criarPlanoDeTeste() {
		fabricaControlador.criarControladorPlanoDeTeste().carregar();
	}

	@Override
	public void carregar() {
		telaPrincipal.exibir();
		
	}	

}
