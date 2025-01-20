package Examen;

public class ex_Thread {
    public static void main(String[] args) {
        // Crear los procesos
        String[] processes = {"Proceso 1", "Proceso 2", "Proceso 3"};

        // Número de veces que se repetirá la ejecución
        int repetitions = 3;

        for (int r = 1; r <= repetitions; r++) {
            System.out.println("Ejecución número " + r);

            // Crear y ejecutar los hilos
            WorkerThread thread1 = new WorkerThread("Hilo 1", processes, 0);
            WorkerThread thread2 = new WorkerThread("Hilo 2", processes, 1);

            thread1.start();
            thread2.start();

            // Asegurar que los hilos terminen antes de la próxima iteración
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Fin de la ejecución número " + r + "\n");
        }
    }
}

class WorkerThread extends Thread {
    private final String threadName;
    private final String[] processes;
    private final int threadId;

    public WorkerThread(String threadName, String[] processes, int threadId) {
        this.threadName = threadName;
        this.processes = processes;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < processes.length; i++) {
            if (i % 2 == threadId) { // Asignar procesos alternadamente a los hilos
                System.out.println(processes[i] + " se ejecuta en " + threadName);
                try {
                    Thread.sleep(1000); // Simular trabajo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

