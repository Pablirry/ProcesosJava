package Practica_6;

public class ContadorSincronizado {
	private static int contador = 0;

    // Método sincronizado para incrementar el contador
    public static synchronized void incrementar(int hiloId) {
        contador++;
        System.out.println("Hilo " + hiloId + " incrementó el contador a: " + contador);
        try {
            Thread.sleep(100); // Simula un tiempo de procesamiento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Hilo " + hiloId + " interrumpido.");
        }
    }

    public static void main(String[] args) {
        int numHilos = 10; // Número de hilos
        int iteraciones = 10; // Incrementos por hilo
        Thread[] hilos = new Thread[numHilos];

        // Crear y arrancar hilos
        for (int i = 0; i < numHilos; i++) {
            int hiloId = i + 1; // Identificador del hilo
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < iteraciones; j++) {
                    incrementar(hiloId); // Incrementar el contador
                }
            });
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.err.println("Error esperando al hilo: " + e.getMessage());
            }
        }

        // Mostrar el resultado final
        System.out.println("Valor final del contador: " + contador);
    }

}
