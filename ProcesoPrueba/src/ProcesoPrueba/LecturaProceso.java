package ProcesoPrueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaProceso {

	public static void main(String[] args) {

		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);
			System.out.println("Introduce cadena de texto: ");
			String texto = br.readLine();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
