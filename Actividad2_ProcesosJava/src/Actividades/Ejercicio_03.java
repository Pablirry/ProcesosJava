package Actividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio_03 {
	
	public static void main(String[] args) {
		
		ProcessBuilder processBuilder = new ProcessBuilder("ping", "-n", "3", "google.com");
		
		try {
			Process proceso = processBuilder.start();
			
			InputStream inputStream = proceso.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
			String linea;
			
			while ((linea = buffer.readLine()) != null) {
				System.out.println(linea);
			}
			
			int exitCode = proceso.waitFor();
			
			System.out.println("Proceso finalizado con codigo de salida: " + exitCode);
			
		} catch (IOException | InterruptedException e) {
			System.out.println("ERROR");
		}
		
	}

}
