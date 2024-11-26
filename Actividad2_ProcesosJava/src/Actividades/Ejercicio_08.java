package Actividades;

import java.util.Map;

public class Ejercicio_08 {
	
	public static void main(String[] args) {
		
		ProcessBuilder processBuilder = new ProcessBuilder();
		
		Map<String, String> env = processBuilder.environment();
			System.out.println(env);
		
	}

}
