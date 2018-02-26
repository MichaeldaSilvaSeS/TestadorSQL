package br.com.testadorsql.tela;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;

public class TelaConfiguracaoBancoDeDados extends JDialog {
	private static final long serialVersionUID = 2519490420752153984L;
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public TelaConfiguracaoBancoDeDados() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Conexao");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setType(Type.POPUP);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(341, 239, 91, 23);
		panel.add(btnNewButton);
		
		JButton btnTestar = new JButton("Testar");
		btnTestar.setBounds(240, 239, 91, 23);
		panel.add(btnTestar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 422, 217);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Driver", ""},
				{"String de Conexao", null},
				{"Caminho da biblioteca", null},
			},
			new String[] {
				"Propriedade", "Valor"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(240);
		scrollPane.setViewportView(table);

	}
}
