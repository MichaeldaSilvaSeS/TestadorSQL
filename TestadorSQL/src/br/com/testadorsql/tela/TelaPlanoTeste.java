package br.com.testadorsql.tela;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaPlanoTeste extends JDialog implements Tela{
	private static final long serialVersionUID = -1688097473444357380L;
	
	private JTable table;
	private JTextField textField;

	public TelaPlanoTeste() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Plano de Teste");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 275);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 424, 171);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Script", "Tipo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(255);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(111, 8, 323, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoPlano = new JLabel("Nome do plano");
		lblNomeDoPlano.setBounds(10, 11, 91, 14);
		contentPanel.add(lblNomeDoPlano);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(343, 216, 91, 23);
		contentPanel.add(btnSalvar);

	}
	
	@Override
	public void exibir() {
		setVisible(true);
	}
}
