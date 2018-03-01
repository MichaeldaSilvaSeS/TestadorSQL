package br.com.testadorsql.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {
		
	public static final File diretorioAtual(){
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		return new File(s);
	}
	
	public static final Collection<File> listarTodosArquivos(File diretorio){
		List<File> lista = new LinkedList<File>();
		
		for (File file : diretorio.listFiles()) {
		    if (file.isFile()) {
		    	lista.add(file);
		    }else if(file.isDirectory()){
		    	lista.addAll(listarTodosArquivos(file));
		    }
		}
		
		return lista;
	}

}
