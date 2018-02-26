package br.com.testadorsql.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.testadorsql.controlador.ControladorPrincipal;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private ControladorPrincipal controladorPrincipal;

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
		controladorPrincipal = new ControladorPrincipal(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setType(Type.POPUP);
		frmPrincipal.setResizable(false);
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.sair();
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnPrograma = new JMenu("Programa");
		menuBar.add(mnPrograma);
		
		JMenuItem mntmNovoTeste = new JMenuItem("Criar script");
		mntmNovoTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.criarScript();
			}
		});
		mnPrograma.add(mntmNovoTeste);
		
		JMenuItem mntmCriarPlanoDe = new JMenuItem("Criar plano de teste");
		mntmCriarPlanoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.criarPlanoDeTeste();
			}
		});
		mnPrograma.add(mntmCriarPlanoDe);
		
		JMenuItem mntmTestarSql = new JMenuItem("Executar plano");
		mntmTestarSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.execucaoSQL();
			}
		});
		mnPrograma.add(mntmTestarSql);
		
		JMenu mnConfiguracao = new JMenu("Configuracao");
		menuBar.add(mnConfiguracao);
		
		JMenuItem mntmBancoDeDados = new JMenuItem("Banco de dados");
		mntmBancoDeDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.configuracaoBancoDeDados();
			}
		});
		mnConfiguracao.add(mntmBancoDeDados);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.sobre();
			}
		});
		mnAjuda.add(mntmSobre);
	}
	
	public void show(){
		frmPrincipal.setVisible(true);
	}
	
	public void sairDaAplicacao(){
		System.exit(0);
	}
	
	public void exibirTelaSobre(){
		FabricaTela.criarTelaSobre().setVisible(true);
	}
	
	public void exibirTelaExecucao(){
		FabricaTela.criarTelaExecucao().setVisible(true);
	}

	public void exibirConfigurarBancoDeDados() {
		FabricaTela.criarTelaConfigurarBancoDeDados().setVisible(true);		
	}

	public void exibirTelaCriarTeste() {
		FabricaTela.criarTelaCriarTeste().setVisible(true);		
	}

	public void exibirTelaPlanoDeTeste() {
		FabricaTela.criarTelaPlanoDeTeste().setVisible(true);	
	}

}
