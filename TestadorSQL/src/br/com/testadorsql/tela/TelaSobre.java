package br.com.testadorsql.tela;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;

public class TelaSobre extends JDialog {
	private static final long serialVersionUID = 7109963459237230651L;
	
	private final JPanel contentPanel = new JPanel();

	public TelaSobre() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Sobre");
		setType(Type.POPUP);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTextArea txtrProjetoFuiCriado = new JTextArea();
			txtrProjetoFuiCriado.setLineWrap(true);
			txtrProjetoFuiCriado.setText("  Projeto fui criado para possibilitar a execu\u00E7\u00E3o de testes unt\u00E1rios de programas escritos em SQL");
			contentPanel.add(txtrProjetoFuiCriado, BorderLayout.CENTER);
		}
	}
}
