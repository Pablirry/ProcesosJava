package Ejercicio_02;

public class Principal {

	public static void main(String[] args) {
		Thread hilo = new Thread(new Interfaz());
		hilo.start();

	}

}
