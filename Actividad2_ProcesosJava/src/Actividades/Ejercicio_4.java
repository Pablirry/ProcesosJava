package Actividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio_4 {

	public static void main(String[] args) {

		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "java -jar C:\\Users\\pablo\\Desktop\\PruebasProcesos\\Ejercicio_4.jar");

		try {

			Process proceso = processBuilder.start();
			
			InputStream inputStream = proceso.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));

			System.out.println("Archivo JAR ejecutado correctamente.");

			int exitCode = proceso.waitFor();
			System.out.println("El proceso terminó con el código: " + exitCode);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
