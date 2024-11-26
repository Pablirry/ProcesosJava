package Ejercicio_01;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el tiempo en milisegundos para que los hilos estén activos: ");
        long tiempo = scanner.nextLong();

        for (int i = 1; i <= 5; i++) {
            Thread hilo = new Thread(new Interfaz("Hilo " + i, tiempo));
            hilo.start();
        }

        scanner.close();
			
			
		}

}
