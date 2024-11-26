package Ejercicio_03;

public class Principal {

	public static void main(String[] args) {
		HiloMensaje1 hilo1 = new HiloMensaje1();
		HiloMensaje2 hilo2 = new HiloMensaje2();
		
		hilo1.start();
		hilo2.start();

	}

}
