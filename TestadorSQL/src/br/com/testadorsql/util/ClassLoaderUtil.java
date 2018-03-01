package br.com.testadorsql.util;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderUtil {
	private static final File BIBLIOTECA = new File(FileUtil.diretorioAtual().getAbsolutePath().concat(File.separator).concat("ext"));
	private static final String EXTENSAO_JAR = ".jar";

	@SuppressWarnings("rawtypes")
	public static final void carregarJar(File arquivoJar) {
		try {
			URL url = arquivoJar.toURI().toURL();			
			Class[] parameters = new Class[] { URL.class };

			URLClassLoader sysLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
			Class<URLClassLoader> sysClass = URLClassLoader.class;

			Method method = sysClass.getDeclaredMethod("addURL", parameters);
			method.setAccessible(true);
			method.invoke(sysLoader, new Object[] { url });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static final void carregarDiretorio(File diretorio){
		for(File arquivo: FileUtil.listarTodosArquivos(diretorio)){
			if(arquivo.getName().endsWith(EXTENSAO_JAR))
				carregarJar(arquivo);
		}			
	}
	
	public static final void carregarBiblioteca(){
		if(BIBLIOTECA.exists() && BIBLIOTECA.canRead())
			carregarDiretorio(BIBLIOTECA);	
	}
}
