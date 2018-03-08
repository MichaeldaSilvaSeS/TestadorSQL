package br.com.testadorsql.tela;

import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal {
	public static interface OuvinteTelaPrincipal{
		public void sair();
		public void criarScript();
		public void criarPlanoDeTeste();
		public void execucaoSQL();
		public void configuracaoBancoDeDados();
		public void sobre();
	}
		
	private JFrame frmPrincipal;
	private OuvinteTelaPrincipal ouvinteTelaPrincipal;
	private FabricaTela fabricaTela;
	
	public TelaPrincipal(FabricaTela fabricaTela) {
		this.fabricaTela = fabricaTela;
		initialize();
	}

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
				ouvinteTelaPrincipal.sair();
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnPrograma = new JMenu("Programa");
		menuBar.add(mnPrograma);
		
		JMenuItem mntmNovoTeste = new JMenuItem("Criar script");
		mntmNovoTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinteTelaPrincipal.criarScript();
			}
		});
		//mnPrograma.add(mntmNovoTeste);
		
		JMenuItem mntmCriarPlanoDe = new JMenuItem("Criar plano de teste");
		mntmCriarPlanoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinteTelaPrincipal.criarPlanoDeTeste();
			}
		});
		mnPrograma.add(mntmCriarPlanoDe);
		
		JMenuItem mntmTestarSql = new JMenuItem("Executar plano");
		mntmTestarSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinteTelaPrincipal.execucaoSQL();
			}
		});
		mnPrograma.add(mntmTestarSql);
		
		JMenu mnConfiguracao = new JMenu("Configuracao");
		menuBar.add(mnConfiguracao);
		
		JMenuItem mntmBancoDeDados = new JMenuItem("Banco de dados");
		mntmBancoDeDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinteTelaPrincipal.configuracaoBancoDeDados();
			}
		});
		mnConfiguracao.add(mntmBancoDeDados);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinteTelaPrincipal.sobre();
			}
		});
		mnAjuda.add(mntmSobre);
	}
	
	public void setOuvinte(OuvinteTelaPrincipal ouvinteTelaPrincipal){
		this.ouvinteTelaPrincipal = ouvinteTelaPrincipal;
	}
	
	public void sairDaAplicacao(){
		System.exit(0);
	}
	
	public void exibirTelaSobre(){
		fabricaTela.criarTelaSobre().exibir();
	}
	
	public void exibirTelaExecucao(){
		fabricaTela.criarTelaExecucao().exibir();
	}

	public void exibirConfigurarBancoDeDados() {
		fabricaTela.criarTelaConfigurarBancoDeDados().exibir();		
	}

	public void exibirTelaPlanoDeTeste() {
		fabricaTela.criarTelaPlanoDeTeste().exibir();	
	}

	public void exibir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

}
