package Actividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio_14 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Estas seguro de detener el proceso: ");
		String confir = sc.nextLine();
		
		if (confir.equalsIgnoreCase("s")) {
			try {
				String comando = "powershell.exe Stop-Process -Name notepad -Force";
				Process proceso = Runtime.getRuntime().exec(comando);
				
				BufferedReader buffer = new BufferedReader(new InputStreamReader(proceso.getInputStream()));			
				
				System.out.println("El proceso se detuvo");
				
				
			} catch (IOException e) {
				System.out.println("Error al detener el proceso");
				e.printStackTrace();
			}
		} else {
			System.out.println("Operacion cancelada");
		}
		
		sc.close();

	}

}
