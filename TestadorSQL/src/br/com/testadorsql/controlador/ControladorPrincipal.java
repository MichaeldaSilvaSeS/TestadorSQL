package br.com.testadorsql.controlador;

import br.com.testadorsql.tela.TelaSobre;

public class ControladorPrincipal {

	public void sair(){
		System.exit(0);
	}
	
	public void sobre(){
		TelaSobre telaSobre = new TelaSobre();
		telaSobre.setVisible(true);
	}

}
