package br.com.testadorsql.controlador;

import java.sql.SQLException;

import br.com.testadorsql.bancodedados.BancoDeDadosConfiguracaoBancoDeDados;
import br.com.testadorsql.modelo.ModeloConfiguracaoBancoDeDados;
import br.com.testadorsql.tela.TelaConfiguracaoBancoDeDados;
import br.com.testadorsql.tela.TelaConfiguracaoBancoDeDados.OuvinteTelaConfiguracaoBancoDeDados;

public class ControladorConfiguracaoBancoDeDados implements OuvinteTelaConfiguracaoBancoDeDados, Controlador{
	private TelaConfiguracaoBancoDeDados telaConfiguracaoBancoDeDados;
	private BancoDeDadosConfiguracaoBancoDeDados conexaoConfiguracaoBancoDeDados;

	public ControladorConfiguracaoBancoDeDados(TelaConfiguracaoBancoDeDados telaConfiguracaoBancoDeDados,
			BancoDeDadosConfiguracaoBancoDeDados fabricaDeConexaoRemota) {
		super();
		this.telaConfiguracaoBancoDeDados = telaConfiguracaoBancoDeDados;
		this.conexaoConfiguracaoBancoDeDados = fabricaDeConexaoRemota;
	}

	@Override
	public void testar(String driver, String stringDeConexao, String usuario, String senha) {
		try {
			conexaoConfiguracaoBancoDeDados.testarConexao(driver, stringDeConexao,usuario,senha);
			telaConfiguracaoBancoDeDados.exibirMensagemDeTesteSucesso("Conexao foi estabelecida");
		} catch (ClassNotFoundException e) {
			telaConfiguracaoBancoDeDados.exibirMensagemDeTesteFalha("Nao foi possivel carregar o driver");
		} catch (SQLException e) {
			e.printStackTrace();
			telaConfiguracaoBancoDeDados.exibirMensagemDeTesteFalha("Nao foi possivel estabelecer conexao");
		}
	}
	
	@Override
	public void carregar(){
		this.telaConfiguracaoBancoDeDados.setOuvinteTelaConfiguracaoBancoDeDados(this);
		ModeloConfiguracaoBancoDeDados pesquisarConfiguracao = this.conexaoConfiguracaoBancoDeDados.pesquisarConfiguracao();
				
		this.telaConfiguracaoBancoDeDados.exibir(pesquisarConfiguracao.getDriver(),pesquisarConfiguracao.getStringDeConexao(),
				pesquisarConfiguracao.getUsuario(),pesquisarConfiguracao.getSenha());
	}

	@Override
	public void salvar(String driver, String stringDeConexao, String usuario, String senha) {
		try {
			conexaoConfiguracaoBancoDeDados.testarConexao(driver, stringDeConexao,usuario,senha);
			conexaoConfiguracaoBancoDeDados.salvar(driver, stringDeConexao, usuario, senha);
			telaConfiguracaoBancoDeDados.exibirMensagemDeTesteSucesso("Dados da conexao foram salvos");
		} catch (ClassNotFoundException e) {
			telaConfiguracaoBancoDeDados.exibirMensagemDeTesteFalha("Nao foi possivel carregar o driver");
		} catch (SQLException e) {
			e.printStackTrace();
			telaConfiguracaoBancoDeDados.exibirMensagemDeTesteFalha("Nao foi possivel estabelecer conexao");
		} catch(Exception e){
			telaConfiguracaoBancoDeDados.exibirMensagemDeTesteFalha("Nao foi possivel estabelecer conexao local");
		}
	}	
}
