package Actividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_15 {

	public static void main(String[] args) {
		
		try {
			String comando = "powershell.exe Get-Process | Sort-Object -Property CPU | Out-File -FilePath cpu.txt";
			
			Process proceso = Runtime.getRuntime().exec(comando);
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
			
			String linea;
			while ((linea = buffer.readLine()) != null) {
				System.out.println("Error: " +linea);
			}
			
			System.out.println("La lista ha sdo guardada");
		} catch (IOException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}

	}

}
