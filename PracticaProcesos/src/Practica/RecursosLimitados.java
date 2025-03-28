package Practica;

import java.util.concurrent.Semaphore;

public class RecursosLimitados {

	private static final int MAX_RECURSOS = 3;
	private static Semaphore semaforo = new Semaphore(MAX_RECURSOS);

	static class UsuarioRecurso extends Thread {
		public void run() {
			try {
				semaforo.acquire();
				System.out.println("Usuario obteniendo recurso. Disponibles: " + semaforo.availablePermits());
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
				System.out.println("Recurso liberado. Disponibles: " + semaforo.availablePermits());
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new UsuarioRecurso().start();
		}
	}
}
