package br.com.testadorsql.controlador;

import br.com.testadorsql.bancodedados.FabricaDeConexao;
import br.com.testadorsql.tela.FabricaTela;

public class FabricaControlador {

	private FabricaTela fabricaTela;
	private FabricaDeConexao fabricaDeConexao;
	
	public FabricaControlador(FabricaTela fabricaTela, FabricaDeConexao fabricaDeConexao) {
		super();
		this.fabricaTela = fabricaTela;
		this.fabricaDeConexao = fabricaDeConexao;
	}

	public final ControladorPrincipal criarControladorPrincipal(){
		return new ControladorPrincipal(fabricaTela.criarTelaPrincipal(fabricaTela));
	}
}
