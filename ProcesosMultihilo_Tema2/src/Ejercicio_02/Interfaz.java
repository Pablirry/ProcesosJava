package Ejercicio_02;

public class Interfaz implements Runnable {

	@Override
	public void run() {
		for (char letra = 'A'; letra <= 'E'; letra++) {
			System.out.println(letra);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("El hilo fue interrumpido");
			}
		}
		
	}
	
	

}
