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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaPlanoTeste extends JDialog implements Tela{
	private static final long serialVersionUID = -1688097473444357380L;
	
	public static interface OuvinteTelaPlanoTeste{
		public void adicionar(Integer id, String script);
	}
	
	private JTable tblPlano;
	private JTextField txfNomeDoPlano;
	private OuvinteTelaPlanoTeste ouvinteTelaPlanoTeste;

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
		scrollPane.setBounds(10, 66, 424, 144);
		contentPanel.add(scrollPane);
		
		tblPlano = new JTable();
		tblPlano.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Script"
			}
		));
		tblPlano.getColumnModel().getColumn(0).setPreferredWidth(255);
		scrollPane.setViewportView(tblPlano);
		
		txfNomeDoPlano = new JTextField();
		txfNomeDoPlano.setText("Plano 1");
		txfNomeDoPlano.setBounds(94, 8, 340, 20);
		contentPanel.add(txfNomeDoPlano);
		txfNomeDoPlano.setColumns(10);
		
		JLabel lblNomeDoPlano = new JLabel("Nome do plano");
		lblNomeDoPlano.setBounds(10, 11, 91, 14);
		contentPanel.add(lblNomeDoPlano);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(343, 216, 91, 23);
		contentPanel.add(btnSalvar);
		
		JLabel lblScript = new JLabel("Script");
		lblScript.setBounds(10, 41, 46, 14);
		contentPanel.add(lblScript);
		
		JComboBox cmbScript = new JComboBox();
		cmbScript.setModel(new DefaultComboBoxModel(new String[] {"spir0001", "spir0002", "spir0003"}));
		cmbScript.setBounds(54, 36, 279, 22);
		contentPanel.add(cmbScript);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String script = String.valueOf(cmbScript.getSelectedItem());
				Integer id  = cmbScript.getSelectedIndex();
				ouvinteTelaPlanoTeste.adicionar(id, script);
			}
		});
		btnAdicionar.setBounds(343, 36, 91, 23);
		contentPanel.add(btnAdicionar);
		
		JButton btnAcima = new JButton("Subir");
		btnAcima.setBounds(10, 216, 91, 23);
		contentPanel.add(btnAcima);
		
		JButton btnBaixo = new JButton("Descer");
		btnBaixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaixo.setBounds(111, 216, 91, 23);
		contentPanel.add(btnBaixo);
	}
	
	public void incluirScriptNaListagem(String script){
		DefaultTableModel model = (DefaultTableModel)tblPlano.getModel();
		model.addRow(new String[]{script});
	}
	
	public void setOuvinte(OuvinteTelaPlanoTeste ouvinteTelaPlanoTeste) {
		this.ouvinteTelaPlanoTeste = ouvinteTelaPlanoTeste;
	}
	
	@Override
	public void exibir() {
		setVisible(true);
	}
}
