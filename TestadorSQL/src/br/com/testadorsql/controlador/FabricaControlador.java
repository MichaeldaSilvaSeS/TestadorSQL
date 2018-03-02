package br.com.testadorsql.controlador;

import br.com.testadorsql.bancodedados.FabricaBancoDeDados;
import br.com.testadorsql.tela.FabricaTela;

public class FabricaControlador {

	private FabricaTela fabricaTela;
	private FabricaBancoDeDados fabricaBancoDeDados;
	
	public FabricaControlador(FabricaTela fabricaTela, FabricaBancoDeDados fabricaBancoDeDados) {
		super();
		this.fabricaTela = fabricaTela;
		this.fabricaBancoDeDados = fabricaBancoDeDados;
	}

	public final ControladorPrincipal criarControladorPrincipal(){
		return new ControladorPrincipal(fabricaTela.criarTelaPrincipal(fabricaTela),this);
	}
	
	public final ControladorConfiguracaoBancoDeDados criarControladorConfiguracaoBancoDeDados(){
		return new ControladorConfiguracaoBancoDeDados(fabricaTela.criarTelaConfigurarBancoDeDados(), fabricaBancoDeDados.criarBancoDeDadosConfiguracaoBancoDeDados());
	}
}
