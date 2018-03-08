package br.com.testadorsql.tela;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

public class TelaCriarScript extends JDialog implements Tela{
	private static final long serialVersionUID = 3909980133737965531L;
	private final JPanel contentPanel = new JPanel();
	private final JComboBox cmbTipo = new JComboBox();

	public static interface OuvinteTelaCriarScript{
		public void adicionar(String nome, String tipo);
	}
	
	private OuvinteTelaCriarScript ouvinteTelaCriarScript;
	
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
		
		JLabel lblScript = new JLabel("Script");
		lblScript.setBounds(10, 61, 46, 14);
		contentPanel.add(lblScript);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 422, 356);
		contentPanel.add(scrollPane);
		
		JTextArea txtScript = new JTextArea();
		scrollPane.setViewportView(txtScript);
		txtScript.setTabSize(4);
		txtScript.setWrapStyleWord(true);
		
		JLabel label = new JLabel("Tipo");
		label.setBounds(10, 36, 29, 14);
		contentPanel.add(label);
		cmbTipo.setBounds(50, 36, 281, 22);
		contentPanel.add(cmbTipo);
		cmbTipo.setMaximumRowCount(-1);
		
		JComboBox cmbNome = new JComboBox();
		cmbNome.setEditable(true);
		cmbNome.setBounds(50, 7, 281, 22);
		contentPanel.add(cmbNome);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = String.valueOf(cmbNome.getSelectedItem());
				String tipo = String.valueOf(cmbTipo.getSelectedItem());
				
				ouvinteTelaCriarScript.adicionar(nome, tipo);
			}
		});
		btnAdicionar.setBounds(341, 7, 91, 51);
		contentPanel.add(btnAdicionar);
	}
	
	public void setOuvinteTelaCriarScript(OuvinteTelaCriarScript ouvinteTelaCriarScript) {
		this.ouvinteTelaCriarScript = ouvinteTelaCriarScript;
	}
	
	@Override
	public void exibir() {
		setVisible(true);
	}
	
	public void adicionar(Integer id, String tipo){

		cmbTipo.addItem(tipo);
	}
}
