package Actividades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio_05 {

	public static void main(String[] args) {

		try {
			
			ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "java -jar C:\\Users\\pablo\\Desktop\\PruebasProcesos\\Ejercicio_8.jar");

			
			processBuilder.redirectErrorStream(true);

		
			Process process = processBuilder.start();

			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String linea;	
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea); 
			}
			
			BufferedReader errores = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String linea2;	
			while ((linea2 = reader.readLine()) != null) {
				System.out.println(linea2); 
			}
			
			int exitCode = process.waitFor();
			System.out.println("\nProceso JAR terminado con el código: " + exitCode);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
