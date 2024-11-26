package Actividades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio_12 {

	public static void main(String[] args) {
		
		try {
			ProcessBuilder pb = new ProcessBuilder("powershell", "Start-Process", "calc.exe");
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
