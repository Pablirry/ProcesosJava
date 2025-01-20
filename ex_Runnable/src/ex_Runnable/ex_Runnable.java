package ex_Runnable;

public class ex_Runnable {
	
	public static void main(String[] args) {
        // Crear los procesos
        String[] processes = {"Proceso 1", "Proceso 2", "Proceso 3"};

        // Número de veces que se repetirá la ejecución
        int repetitions = 3;

        for (int r = 1; r <= repetitions; r++) {
            System.out.println("Ejecución número " + r);

            // Crear los hilos
            Thread thread1 = new Thread(new Worker("Hilo 1", processes, 0));
            Thread thread2 = new Thread(new Worker("Hilo 2", processes, 1));
            Thread thread3 = new Thread(new Worker("Hilo 3", processes, 2));

            // Iniciar los hilos
            thread1.start();
            thread2.start();
            thread3.start();

            // Asegurarse de que los hilos terminan antes de iniciar la siguiente iteración
            try {
                thread1.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Fin de la ejecución número " + r + "\n");
        }
    }
}

class Worker implements Runnable {
    private final String threadName;
    private final String[] processes;
    private final int threadId;

    public Worker(String threadName, String[] processes, int threadId) {
        this.threadName = threadName;
        this.processes = processes;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < processes.length; i++) {
            if (i % 3 == threadId) { // Asignar procesos alternadamente a los hilos
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
