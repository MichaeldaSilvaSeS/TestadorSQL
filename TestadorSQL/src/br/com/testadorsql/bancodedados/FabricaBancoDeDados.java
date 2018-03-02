package br.com.testadorsql.bancodedados;

public class FabricaBancoDeDados {

	private FabricaDeConexaoLocal fabricaDeConexaoLocal;
	private FabricaDeConexaoRemota fabricaDeConexaoRemota;
	
	public FabricaBancoDeDados() {
		this.fabricaDeConexaoLocal = new FabricaDeConexaoLocal();
		this.fabricaDeConexaoRemota = new FabricaDeConexaoRemota(fabricaDeConexaoLocal);
	}

	public BancoDeDadosConfiguracaoBancoDeDados criarBancoDeDadosConfiguracaoBancoDeDados(){
		return new BancoDeDadosConfiguracaoBancoDeDados(fabricaDeConexaoLocal, fabricaDeConexaoRemota);
	}
	
	public void executaSQLDeCriacao(){
		fabricaDeConexaoLocal.executaSQLDeCriacao();
	}
}
