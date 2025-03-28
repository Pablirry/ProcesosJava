package Practica;

import java.util.concurrent.Semaphore;

public class SemaforoBinario {

	private static Semaphore semaforo = new Semaphore(1);

	public static void main(String[] args) {
		Runnable tarea = () -> {
			try {
				semaforo.acquire();
				System.out.println("Hilo " + Thread.currentThread().getId() + " en sección crítica");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		};

		new Thread(tarea).start();
		new Thread(tarea).start();
	}

}
