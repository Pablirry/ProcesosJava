package Practica;

import java.util.concurrent.Semaphore;

public class PrioridadEscritura {
    private Semaphore mutex;
    private Semaphore escritura;
    private Semaphore lecturaPermitida;
    private int lectoresActivos;
    private int escritoresEsperando;
    private RecursoCompartido recurso;

    public PrioridadEscritura() {
        this.mutex = new Semaphore(1);
        this.escritura = new Semaphore(1);
        this.lecturaPermitida = new Semaphore(1);
        this.lectoresActivos = 0;
        this.escritoresEsperando = 0;
        this.recurso = new RecursoCompartido();
    }

    public void iniciarLectura() throws InterruptedException {
        lecturaPermitida.acquire();
        mutex.acquire();
        if (escritoresEsperando > 0) {
            mutex.release();
            lecturaPermitida.release();
            Thread.sleep(100); // Dar oportunidad a los escritores
            iniciarLectura(); // Reintentar
            return;
        }
        lectoresActivos++;
        if (lectoresActivos == 1) {
            escritura.acquire();
        }
        mutex.release();
        lecturaPermitida.release();

        // Lectura
        System.out.println("Lector " + Thread.currentThread().getId() + 
                         " lee: " + recurso.toString());
    }

    public void terminarLectura() throws InterruptedException {
        mutex.acquire();
        lectoresActivos--;
        if (lectoresActivos == 0) {
            escritura.release();
        }
        mutex.release();
    }

    public void iniciarEscritura() throws InterruptedException {
        mutex.acquire();
        escritoresEsperando++;
        mutex.release();

        escritura.acquire();
        mutex.acquire();
        escritoresEsperando--;
        mutex.release();

        // Escritura
        recurso.incrementarValores();
        System.out.println("Escritor " + Thread.currentThread().getId() + 
                         " escribe: " + recurso.toString());
    }

    public void terminarEscritura() {
        escritura.release();
    }
}