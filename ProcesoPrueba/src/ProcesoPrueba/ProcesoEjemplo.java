package ProcesoPrueba;

import java.io.File;
import java.io.IOException;

public class ProcesoEjemplo {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java -jar", "C:\\Users\\pablo\\Desktop\\Calculadora.jar");
		
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
