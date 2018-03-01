package br.com.testadorsql.tela;

import javax.swing.UIManager;

public class FabricaTela {
	static{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.out.println("LookAndFeel=disabled");
		}
	}
	
	public TelaSobre criarTelaSobre(){
		return new TelaSobre();
	}
	
	public TelaExecucaoSQL criarTelaExecucao(){
		return new TelaExecucaoSQL();
	}

	public TelaPrincipal criarTelaPrincipal(FabricaTela fabricaTela){
		return new TelaPrincipal(fabricaTela);
	}
	
	public TelaConfiguracaoBancoDeDados criarTelaConfigurarBancoDeDados(){
		return new TelaConfiguracaoBancoDeDados();
	}

	public TelaCriarScript criarTelaCriarTeste() {
		return new TelaCriarScript();
	}

	public TelaPlanoTeste criarTelaPlanoDeTeste() {
		return new TelaPlanoTeste();
	}
}
