package Ejercicio_04;

public class Interfaz extends Thread {
	
	private String nombre;
	
	public Interfaz (String nombre) {
		this.nombre = nombre;
	}
	
	@Override
    public void run() {
        for(int i = 0; i < 5; i++) {
        	System.out.println("Hilo " + (i+1) + " " + nombre);
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(nombre + " fue interrumpido");
			}
        }
    }

}
