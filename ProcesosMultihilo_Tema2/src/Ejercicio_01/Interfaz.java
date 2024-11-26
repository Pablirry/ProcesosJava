package Ejercicio_01;

public class Interfaz implements Runnable {
	
	private String nombre;
	private long tiempo;
	
	public Interfaz (String nombre, long tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}
	
	@Override
	public void run() {
		long inicio = System.currentTimeMillis();
		while (System.currentTimeMillis() - inicio < tiempo) {
			System.out.println(nombre + " está corriendo");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(nombre + " fue interrumpido");
			}
		}
		
		System.out.println(nombre + " ha terminado");
		
	}

}
