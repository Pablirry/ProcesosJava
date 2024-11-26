package Actividades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio_11 {

	public static void main(String[] args) {
		
		try {
			ProcessBuilder pb = new ProcessBuilder("powershell", "Get-Process");
			Process proceso = pb.start();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			
			proceso.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
