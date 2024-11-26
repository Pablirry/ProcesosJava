package ProcesoPrueba;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class generadorProcesos {

	public static void main(String[] args) throws IOException {
		
		ProcessBuilder process = new ProcessBuilder("notepad.exe" , "D:\\DAM AFA\\2-DAM-1\\Programacion de servicios y procesos\\Tema 1\\ejemplo.txt");
		
		
		/* Map<String, String> env = process.environment();
		System.out.println(env);
		System.out.println(env.get("NUMBER_OF_PROCESSORS"));
		*/
		
		List<String> list = process.command();
		Iterator<String> it = list.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
		
		try {
			process.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
