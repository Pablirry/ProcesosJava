package Practica;

import java.util.concurrent.Semaphore;

public class ControlFlujo {

	private static Semaphore semA = new Semaphore(2);
	private static Semaphore semB = new Semaphore(0);

	public static void main(String[] args) {
		new Thread(() -> {
			try {
				semA.acquire(2);
				System.out.println("Tarea crítica completada");
				semB.release(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				semB.acquire();
				System.out.println("Tarea posterior ejecutada");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
