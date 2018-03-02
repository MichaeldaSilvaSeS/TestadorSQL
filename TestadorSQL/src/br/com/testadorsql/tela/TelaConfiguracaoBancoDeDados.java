package br.com.testadorsql.tela;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TelaConfiguracaoBancoDeDados extends JDialog implements Tela {
	private static final long serialVersionUID = 2519490420752153984L;
	
	public static interface OuvinteTelaConfiguracaoBancoDeDados{
		public void salvar(String driver, String stringDeConexao, String usuario, String senha);
		public void testar(String driver, String stringDeConexao, String usuario, String senha);
	}
	
	private JTable tblConexao;
	private OuvinteTelaConfiguracaoBancoDeDados ouvinteTelaConfiguracaoBancoDeDados;

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
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel model = tblConexao.getModel();
				
				int linha = -1;
				String driver = String.valueOf(model.getValueAt(++linha, 1));
				String stringDeConexao = String.valueOf(model.getValueAt(++linha, 1));
				String usuario = String.valueOf(model.getValueAt(++linha, 1));
				String senha = String.valueOf(model.getValueAt(++linha, 1));
				
				usuario = (usuario == "null" ? "" : usuario);
				senha = (senha == "null" ? "" : senha);
				
				ouvinteTelaConfiguracaoBancoDeDados.salvar(driver,stringDeConexao,usuario,senha);
			}
		});
		btnSalvar.setBounds(341, 239, 91, 23);
		panel.add(btnSalvar);
		
		JButton btnTestar = new JButton("Testar");
		btnTestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel model = tblConexao.getModel();
				
				int linha = -1;
				String driver = String.valueOf(model.getValueAt(++linha, 1));
				String stringDeConexao = String.valueOf(model.getValueAt(++linha, 1));
				String usuario = String.valueOf(model.getValueAt(++linha, 1));
				String senha = String.valueOf(model.getValueAt(++linha, 1));
				
				usuario = (usuario == "null" ? "" : usuario);
				senha = (senha == "null" ? "" : senha);
				
				ouvinteTelaConfiguracaoBancoDeDados.testar(driver,stringDeConexao,usuario,senha);
			}
		});
		btnTestar.setBounds(240, 239, 91, 23);
		panel.add(btnTestar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 422, 217);
		panel.add(scrollPane);
		
		tblConexao = new JTable();
		tblConexao.setModel(new DefaultTableModel(
			new Object[][] {
				{"Driver", ""},
				{"String de Conexao", null},
				{"Usuario", null},
				{"Senha", null},
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
		tblConexao.getColumnModel().getColumn(0).setPreferredWidth(180);
		tblConexao.getColumnModel().getColumn(1).setPreferredWidth(240);
		scrollPane.setViewportView(tblConexao);

	}
	
	public void setOuvinteTelaConfiguracaoBancoDeDados(OuvinteTelaConfiguracaoBancoDeDados ouvinteTelaConfiguracaoBancoDeDados){
		this.ouvinteTelaConfiguracaoBancoDeDados = ouvinteTelaConfiguracaoBancoDeDados;
	}
	
	@Override
	public void exibir() {
		setVisible(true);
	}
	
	public void exibirMensagemDeTesteFalha(String mensagem){
		JOptionPane.showMessageDialog(this, mensagem, "Teste", JOptionPane.WARNING_MESSAGE);
	}
	
	public void exibirMensagemDeTesteSucesso(String mensagem){
		JOptionPane.showMessageDialog(this, mensagem, "Teste", JOptionPane.INFORMATION_MESSAGE);
	}
}
