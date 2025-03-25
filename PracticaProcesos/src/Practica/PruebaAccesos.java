package Practica;

public class PruebaAccesos {
    private static final int NUM_LECTORES = 5;
    private static final int NUM_ESCRITORES = 3;

    public static void main(String[] args) {

        System.out.println("=== PRUEBA CON PRIORIDAD DE LECTURA ===");
        PrioridadLectura recursoLectura = new PrioridadLectura();
        ejecutarPrueba(recursoLectura);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== PRUEBA CON PRIORIDAD DE ESCRITURA ===");
        PrioridadEscritura recursoEscritura = new PrioridadEscritura();
        ejecutarPrueba(recursoEscritura);
    }

    private static void ejecutarPrueba(Object recurso) {

        for (int i = 0; i < NUM_LECTORES; i++) {
            if (recurso instanceof PrioridadLectura) {
                new LectorThread((PrioridadLectura)recurso).start();
            } else {
                new LectorThread((PrioridadEscritura)recurso).start();
            }
        }

        for (int i = 0; i < NUM_ESCRITORES; i++) {
            if (recurso instanceof PrioridadLectura) {
                new EscritorThread((PrioridadLectura)recurso).start();
            } else {
                new EscritorThread((PrioridadEscritura)recurso).start();
            }
        }
    }

    static class LectorThread extends Thread {
        private PrioridadLectura recursoLectura;
        private PrioridadEscritura recursoEscritura;

        public LectorThread(PrioridadLectura recurso) {
            this.recursoLectura = recurso;
        }

        public LectorThread(PrioridadEscritura recurso) {
            this.recursoEscritura = recurso;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (recursoLectura != null) {
                        recursoLectura.iniciarLectura();
                        Thread.sleep(1000);
                        recursoLectura.terminarLectura();
                    } else {
                        recursoEscritura.iniciarLectura();
                        Thread.sleep(1000);
                        recursoEscritura.terminarLectura();
                    }
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class EscritorThread extends Thread {
        private PrioridadLectura recursoLectura;
        private PrioridadEscritura recursoEscritura;

        public EscritorThread(PrioridadLectura recurso) {
            this.recursoLectura = recurso;
        }

        public EscritorThread(PrioridadEscritura recurso) {
            this.recursoEscritura = recurso;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (recursoLectura != null) {
                        recursoLectura.iniciarEscritura();
                        Thread.sleep(2000);
                        recursoLectura.terminarEscritura();
                    } else {
                        recursoEscritura.iniciarEscritura();
                        Thread.sleep(2000);
                        recursoEscritura.terminarEscritura();
                    }
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}