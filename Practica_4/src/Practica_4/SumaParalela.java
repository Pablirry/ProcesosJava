package Practica_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumaParalela {
	public static void main(String[] args) {
        int[] numeros = new int[1000];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1; // Llenar el array con números del 1 al 1000
        }

        int numHilos = 4;
        ExecutorService pool = Executors.newFixedThreadPool(numHilos);

        int tamParte = numeros.length / numHilos;
        Future<Integer>[] resultados = new Future[numHilos];

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * tamParte;
            int fin = (i == numHilos - 1) ? numeros.length : inicio + tamParte;
            int idHilo = i + 1;

            resultados[i] = pool.submit(() -> {
                int sumaParcial = 0;
                System.out.println("Hilo " + idHilo + " procesando desde " + inicio + " hasta " + (fin - 1));
                for (int j = inicio; j < fin; j++) {
                    sumaParcial += numeros[j];
                    System.out.println("Hilo " + idHilo + " suma: " + numeros[j] + ", suma parcial: " + sumaParcial);
                }
                System.out.println("Hilo " + idHilo + " terminó con suma parcial: " + sumaParcial);
                return sumaParcial;
            });
        }

        int sumaTotal = 0;
        for (int i = 0; i < numHilos; i++) {
            try {
                int sumaHilo = resultados[i].get();
                sumaTotal += sumaHilo;
                System.out.println("Resultado recibido del hilo " + (i + 1) + ": " + sumaHilo);
            } catch (Exception e) {
                System.err.println("Error al obtener el resultado del hilo: " + e.getMessage());
            }
        }

        pool.shutdown();
        System.out.println("Suma total: " + sumaTotal);
    }

}
