package br.com.testadorsql.tela;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TelaSobre extends JFrame {
	private static final long serialVersionUID = 5244214318494192649L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaSobre() {
		setResizable(false);
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea txtrProjetoFuiCriado = new JTextArea();
		txtrProjetoFuiCriado.setLineWrap(true);
		txtrProjetoFuiCriado.setEditable(false);
		txtrProjetoFuiCriado.setText("Projeto fui criado para possibilitar a execu\u00E7\u00E3o de testes unt\u00E1rios de programas escritos em SQL");
		contentPane.add(txtrProjetoFuiCriado, BorderLayout.CENTER);
	}

}
