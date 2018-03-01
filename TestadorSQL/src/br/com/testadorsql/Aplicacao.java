package br.com.testadorsql;

import javax.swing.UnsupportedLookAndFeelException;

import br.com.testadorsql.bancodedados.FabricaDeConexao;
import br.com.testadorsql.controlador.FabricaControlador;
import br.com.testadorsql.tela.FabricaTela;
import br.com.testadorsql.util.ClassLoaderUtil;

public class Aplicacao {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		ClassLoaderUtil.carregarBiblioteca();		
		
		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
		fabricaDeConexao.executaSQLDeCriacao();
		
		FabricaTela fabricaTela = new FabricaTela();
		FabricaControlador fabricaControlador = new FabricaControlador(fabricaTela, fabricaDeConexao);
		fabricaControlador.criarControladorPrincipal().exibir();
	}
}
