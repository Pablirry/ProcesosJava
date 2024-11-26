package Ejercicio_04;

public class Principal {

	public static void main(String[] args) {
		Interfaz hilo1 = new Interfaz("Pablo");
		Interfaz hilo2 = new Interfaz("Pedro");
		Interfaz hilo3 = new Interfaz("Jaime");
		Interfaz hilo4 = new Interfaz("Luis");
		Interfaz hilo5 = new Interfaz("Carlos");
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		

	}

}
