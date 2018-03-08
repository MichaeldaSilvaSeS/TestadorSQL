package br.com.testadorsql.modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloPlanoDeTeste {
	private String nome;
	private List<String> scripts;
	private Integer versao_atual;
	
	public ModeloPlanoDeTeste(){
		versao_atual = 1;
		scripts = new ArrayList<>();
	}
	
	public void incluirScript(String script){
		scripts.add(script);
	}
	
	public void removerScript(Integer indice){
		scripts.remove(indice);
	}
	
	public void subirScript(Integer indice){
		if(indice < 1 || indice >= scripts.size())
			return;
		
		String scriptAcima =  scripts.get(indice-1);
		String scriptAtual =  scripts.get(indice);
		
		scripts.set(indice, scriptAcima);
		scripts.set(indice-1, scriptAtual);
	}
	
	public void descerScript(Integer indice){
		if(indice < 0 || indice >= scripts.size())
			return;
		
		String scriptAtual =  scripts.get(indice);
		String scriptAbaixo =  scripts.get(indice+1);
		
		scripts.set(indice+1, scriptAtual);
		scripts.set(indice, scriptAbaixo);		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<String> getScripts() {
		return scripts;
	}
	
	public void setScripts(List<String> scripts) {
		this.scripts = scripts;
	}

	public Integer getVersao_atual() {
		return versao_atual;
	}

	public void setVersao_atual(Integer versao_atual) {
		this.versao_atual = versao_atual;
	}
}
