package Ejercicio_05;

public class Interfaz extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Hilo interrumpido");
			}

		}

	}

}
