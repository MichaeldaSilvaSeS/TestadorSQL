package br.com.testadorsql.tela;

import java.awt.EventQueue;
import java.awt.Window;

public class FabricaTela {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					criarTelaPrincipal().show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static TelaSobre criarTelaSobre(){
		return new TelaSobre();
	}
	
	public static TelaExecucaoSQL criarTelaExecucao(){
		return new TelaExecucaoSQL();
	}

	public static TelaPrincipal criarTelaPrincipal(){
		return new TelaPrincipal();
	}
	
	public static TelaConfiguracaoBancoDeDados criarTelaConfigurarBancoDeDados(){
		return new TelaConfiguracaoBancoDeDados();
	}

	public static TelaCriarTeste criarTelaCriarTeste() {
		return new TelaCriarTeste();
	}

	public static Window criarTelaPlanoDeTeste() {
		return new TelaPlanoTeste();
	}
}
