package Hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HiloConExecutorService {
    public static void main(String[] args) {
        // Crear un pool de hilos fijo con 2 hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Crear tareas
        Runnable tarea1 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Tarea 1, iteración: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Tarea 1 fue interrumpida.");
                }
            }
            System.out.println("Tarea 1 completada.");
        };

        Runnable tarea2 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Tarea 2, iteración: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Tarea 2 fue interrumpida.");
                }
            }
            System.out.println("Tarea 2 completada.");
        };

        // Ejecutar tareas
        executor.submit(tarea1);
        executor.submit(tarea2);

        // Apagar el executor
        executor.shutdown();
    }
}
