package Practica;

import java.util.concurrent.Semaphore;

public class Barrera {

	private static final int N_HILOS = 4;
	private static Semaphore barrera = new Semaphore(0);
	private static Semaphore mutex = new Semaphore(1);
	private static int contador = 0;

	public static void main(String[] args) {
		for (int i = 0; i < N_HILOS; i++) {
			new Thread(() -> {
				try {
					System.out.println("Hilo esperando en barrera");
					mutex.acquire();
					contador++;
					mutex.release();

					if (contador == N_HILOS) {
						barrera.release(N_HILOS);
					}

					barrera.acquire();
					System.out.println("Todos los hilos superaron la barrera");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}

}
