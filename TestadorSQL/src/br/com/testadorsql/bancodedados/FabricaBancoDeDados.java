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
	
	public BancoDeDadosTipoDeScript criarBancoDeDadosTipoDeScript(){
		return new BancoDeDadosTipoDeScript(fabricaDeConexaoLocal);
	}
	
	public BancoDeDadosScript criarBancoDeDadosScript(){
		return new BancoDeDadosScript(fabricaDeConexaoLocal);
	}
	
	public BancoDeDadosPlanoDeTeste criarBancoDeDadosPlanoDeTeste(){
		return new BancoDeDadosPlanoDeTeste(fabricaDeConexaoLocal);
	}
	
	public void executaSQLDeCriacao(){
		fabricaDeConexaoLocal.executaSQLDeCriacao();
	}
}
