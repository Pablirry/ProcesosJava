package Actividades;

import java.util.Map;

public class Ejercicio_09 {
	
	public static void main(String[] args) {
		
		ProcessBuilder processBuilder = new ProcessBuilder();
		
		Map<String, String> env = processBuilder.environment();
		
		env.put("MI_VARIABLE", "ESTALLARME YA");
		
		System.out.println("MI VARIABLE ES: " + env.get("MI_VARIABLE"));
		
	}

}
