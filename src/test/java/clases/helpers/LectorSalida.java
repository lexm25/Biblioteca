package clases.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LectorSalida {

	public LectorSalida() {
		// TODO Auto-generated constructor stub
	}
	
	public static byte[] dameSalida(String fileNamePath) throws FileNotFoundException, IOException {
		byte[] salida = null;
		
		File archivo = new File(fileNamePath);
		salida = new byte[(int) archivo.length()];

	    // funny, if can use Java 7, please uses Files.readAllBytes(path)
	    try(FileInputStream fis = new FileInputStream(archivo)){
	        fis.read(salida);
	    }
		
		return salida;
	}

}
