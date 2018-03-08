package br.com.testadorsql;

import br.com.testadorsql.bancodedados.FabricaBancoDeDados;
import br.com.testadorsql.controlador.FabricaControlador;
import br.com.testadorsql.modelo.FabricaDeModelo;
import br.com.testadorsql.tela.FabricaTela;
import br.com.testadorsql.util.ClassLoaderUtil;

public class Aplicacao {
	public static void main(String[] args) {
		ClassLoaderUtil.carregarBiblioteca();		
	
		FabricaBancoDeDados fabricaBancoDeDados = new FabricaBancoDeDados();
		fabricaBancoDeDados.executaSQLDeCriacao();
		
		FabricaTela fabricaTela = new FabricaTela();
		FabricaDeModelo fabricaDeModelo = new FabricaDeModelo();
		FabricaControlador fabricaControlador = new FabricaControlador(fabricaTela, fabricaBancoDeDados,fabricaDeModelo);
		fabricaControlador.criarControladorPrincipal().carregar();
	}
}
