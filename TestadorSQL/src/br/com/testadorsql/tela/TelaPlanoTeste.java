package br.com.testadorsql.tela;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Dialog.ModalityType;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Dialog.ModalExclusionType;

public class TelaPlanoTeste extends JDialog {
	private JTextField textField;

	public TelaPlanoTeste() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Plano de Teste");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 178);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 442, 151);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(60, 12, 372, 20);
		panel.add(textField);
		
		JLabel label = new JLabel("Descricao");
		label.setBounds(10, 40, 83, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(10, 15, 46, 14);
		panel.add(label_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 58, 422, 43);
		panel.add(textPane);
		
		JButton button = new JButton("Salvar");
		button.setBounds(290, 112, 142, 28);
		panel.add(button);

	}

}
