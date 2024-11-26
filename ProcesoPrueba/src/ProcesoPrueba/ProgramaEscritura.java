package ProcesoPrueba;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProgramaEscritura {

	public static void main(String[] args) {

		try {
			File directorio = new File("\"C:\\Users\\pablo\\Desktop\\PruebasProcesos");
			ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java -jar", "Lectura.jar");
			pb.directory();

			Process p = pb.start();

			OutputStream out = p.getOutputStream();
			out.write("Hola mundo".getBytes());
			out.flush();

			InputStream in = p.getInputStream();
			int texto;
			while ((texto = in.read()) != -1) {
				System.out.println((char) texto);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
