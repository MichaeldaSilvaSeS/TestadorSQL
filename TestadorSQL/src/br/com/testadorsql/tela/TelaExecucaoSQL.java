package br.com.testadorsql.tela;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Dialog.ModalExclusionType;

public class TelaExecucaoSQL extends JDialog {
	private static final long serialVersionUID = -8823657124907684370L;
	
	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaExecucaoSQL dialog = new TelaExecucaoSQL();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TelaExecucaoSQL() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Execucao SQL");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 70, 422, 192);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setCellSelectionEnabled(true);
				table.setColumnSelectionAllowed(true);
				table.setShowVerticalLines(false);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null},
					},
					new String[] {
						"Status", "Script", "Momento"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(266);
				table.getColumnModel().getColumn(2).setResizable(false);
				scrollPane.setViewportView(table);
			}
		}
		{
			JProgressBar progressBar = new JProgressBar();
			progressBar.setStringPainted(true);
			progressBar.setBounds(10, 36, 321, 23);
			contentPanel.add(progressBar);
		}
		{
			JButton btnExecutar = new JButton("Executar");
			btnExecutar.setBounds(341, 36, 91, 23);
			contentPanel.add(btnExecutar);
		}
		{
			JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 298, 422, 146);
			contentPanel.add(textArea);
		}
		{
			JLabel lblLog = new JLabel("Log");
			lblLog.setBounds(10, 273, 46, 14);
			contentPanel.add(lblLog);
		}
		{
			JLabel lblPlanoDeTeste = new JLabel("Plano de teste");
			lblPlanoDeTeste.setBounds(10, 11, 91, 14);
			contentPanel.add(lblPlanoDeTeste);
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 7, 332, 22);
		contentPanel.add(comboBox);
	}
}
