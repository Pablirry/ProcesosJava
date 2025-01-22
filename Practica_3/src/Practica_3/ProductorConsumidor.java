package Practica_3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProductorConsumidor {

    public static void main(String[] args) {
        // Crear una cola con capacidad de 10 elementos
        BlockingQueue<Integer> cola = new LinkedBlockingQueue<>(10);

        // Crear y arrancar el hilo del productor
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    // Producir un elemento y ponerlo en la cola
                    cola.put(i);
                    System.out.println("Producido: " + i);
                    // Simular tiempo de producción
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Manejar la interrupción del hilo
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        // Crear y arrancar los hilos de los consumidores
        for (int i = 1; i <= 3; i++) {
            int id = i;
            new Thread(() -> {
                while (true) {
                    try {
                        // Tomar un elemento de la cola y procesarlo
                        int dato = cola.take();
                        System.out.println("Consumidor " + id + " proceso: " + dato);
                        // Simular tiempo de procesamiento
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        // Manejar la interrupción del hilo
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }
}
