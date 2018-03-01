package br.com.testadorsql.tela;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class TelaCriarScript extends JDialog implements Tela{
	private static final long serialVersionUID = 3909980133737965531L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public TelaCriarScript() {
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
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSalvar.setBounds(341, 36, 91, 61);
		contentPanel.add(btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 422, 309);
		contentPanel.add(scrollPane);
		
		JTextArea txtr = new JTextArea();
		scrollPane.setViewportView(txtr);
		txtr.setTabSize(4);
		txtr.setWrapStyleWord(true);
		
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
	
	@Override
	public void exibir() {
		setVisible(true);
	}
}
