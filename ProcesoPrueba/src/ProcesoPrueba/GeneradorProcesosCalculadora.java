package ProcesoPrueba;

import java.io.IOException;

public class GeneradorProcesosCalculadora {

	public static void main(String[] args) throws InterruptedException{
		
		ProcessBuilder process = new ProcessBuilder("calc.exe");
		
		try {
			Process p = process.start();
			int exitCode = p.waitFor();

			System.out.println(exitCode);
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
