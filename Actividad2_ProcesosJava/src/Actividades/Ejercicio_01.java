package Actividades;

import java.io.IOException;

public class Ejercicio_01 {
	
	public static Process LanzarPrograma(String programa) {
		Process proceso = null;
		try {
			proceso = new ProcessBuilder(programa).start();
		} catch (IOException e) {
			System.out.println("Error al lanzar el programa");
		}
		return proceso;
	}
	
	public static void main(String[] args) {
		Process proceso = LanzarPrograma("calc");
		
		if(proceso != null) {
			System.out.println("Calculadora lanzada.");
		}
	}

}
