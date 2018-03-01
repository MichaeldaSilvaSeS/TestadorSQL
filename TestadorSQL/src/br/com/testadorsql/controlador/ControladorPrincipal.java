package br.com.testadorsql.controlador;

import br.com.testadorsql.tela.TelaPrincipal;
import br.com.testadorsql.tela.TelaPrincipal.OuvinteTelaPrincipal;

public class ControladorPrincipal implements OuvinteTelaPrincipal{
	
	private TelaPrincipal telaPrincipal;

	public ControladorPrincipal(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		this.telaPrincipal.setOuvinte(this);
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
		telaPrincipal.exibirConfigurarBancoDeDados();
	}

	public void criarScript() {
		telaPrincipal.exibirTelaCriarTeste();
	}

	public void criarPlanoDeTeste() {
		telaPrincipal.exibirTelaPlanoDeTeste();
	}
	
	public void exibir(){
		telaPrincipal.exibir();
	}

}
