package br.com.testadorsql.tela;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dialog.ModalExclusionType;

public class TelaCriarTeste extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCriarTeste dialog = new TelaCriarTeste();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaCriarTeste() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Criar script");
		setType(Type.POPUP);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(50, 8, 168, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(10, 36, 115, 14);
		contentPanel.add(lblDescricao);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 61, 321, 36);
		contentPanel.add(textPane);
		
		JLabel lblScript = new JLabel("Script");
		lblScript.setBounds(10, 108, 46, 14);
		contentPanel.add(lblScript);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(341, 36, 91, 61);
		contentPanel.add(btnSalvar);
		
		JTextArea txtr = new JTextArea();
		txtr.setLineWrap(true);
		txtr.setBounds(10, 133, 422, 309);
		contentPanel.add(txtr);
		
		JLabel label = new JLabel("Tipo");
		label.setBounds(225, 11, 29, 14);
		contentPanel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Backup", "Configuracao", "Massa", "Spy", "Teste"}));
		comboBox.setSelectedIndex(4);
		comboBox.setBounds(264, 7, 168, 22);
		contentPanel.add(comboBox);
		comboBox.setMaximumRowCount(4);
	}
}
