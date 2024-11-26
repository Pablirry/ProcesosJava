package Actividades;

import java.io.IOException;

public class Ejercicio_02 {
	
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
		Process proceso1 = LanzarPrograma("mspaint");
		if(proceso1 != null) {
			System.out.println("Primer proceso de paint lanzado");
		}
		
		Process proceso2 = LanzarPrograma("mspaint");
		if(proceso2 != null) {
			System.out.println("Segundo proceso de paint lanzado");
		}
	}

}
