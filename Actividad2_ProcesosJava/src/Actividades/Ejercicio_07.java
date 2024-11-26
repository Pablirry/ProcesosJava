package Actividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio_07 {

	public static void main(String[] args) {
		
		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start", "C:\\Users\\pablo\\Desktop\\PruebasProcesos\\texto.txt");
		
		try {
			Process proceso = processBuilder.start();
			
			InputStream inputStream = proceso.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
			String linea;
			
			while ((linea = buffer.readLine()) != null) {
				System.out.println(linea);
			}
			
			
		} catch (IOException e) {
			System.out.println("ERROR");
		}
	}
}
