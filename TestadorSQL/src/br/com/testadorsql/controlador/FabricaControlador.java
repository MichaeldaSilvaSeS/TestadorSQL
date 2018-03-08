package br.com.testadorsql.controlador;

import br.com.testadorsql.bancodedados.FabricaBancoDeDados;
import br.com.testadorsql.modelo.FabricaDeModelo;
import br.com.testadorsql.tela.FabricaTela;

public class FabricaControlador {

	private FabricaTela fabricaTela;
	private FabricaBancoDeDados fabricaBancoDeDados;
	private FabricaDeModelo fabricaDeModelo;
	
	public FabricaControlador(FabricaTela fabricaTela, FabricaBancoDeDados fabricaBancoDeDados, FabricaDeModelo fabricaDeModelo) {
		super();
		this.fabricaTela = fabricaTela;
		this.fabricaBancoDeDados = fabricaBancoDeDados;
		this.fabricaDeModelo = fabricaDeModelo;
	}

	public final ControladorPrincipal criarControladorPrincipal(){
		return new ControladorPrincipal(fabricaTela.criarTelaPrincipal(fabricaTela),this);
	}
	
	public final ControladorConfiguracaoBancoDeDados criarControladorConfiguracaoBancoDeDados(){
		return new ControladorConfiguracaoBancoDeDados(fabricaTela.criarTelaConfigurarBancoDeDados(), fabricaBancoDeDados.criarBancoDeDadosConfiguracaoBancoDeDados());
	}
	
	public final ControladorPlanoDeTeste criarControladorPlanoDeTeste(){
		return new ControladorPlanoDeTeste(fabricaTela.criarTelaPlanoDeTeste(),fabricaBancoDeDados.criarBancoDeDadosPlanoDeTeste(),fabricaDeModelo);
	}
}
