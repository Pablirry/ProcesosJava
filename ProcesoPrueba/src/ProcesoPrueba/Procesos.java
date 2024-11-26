package ProcesoPrueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Procesos {

	public static void main(String[] args) throws IOException {
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "DIR");
		
		try {
		Process p = pb.start();
		InputStream st = p.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String linea;
		while ((linea = reader.readLine()) != null) {
			System.out.println(linea);
		}
		
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
		

	}

}
