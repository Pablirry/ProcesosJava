package Practica;

import java.util.concurrent.Semaphore;

public class PrioridadLectura {
    private Semaphore mutex;
    private Semaphore escritura;
    private int lectoresActivos;
    private RecursoCompartido recurso;

    public PrioridadLectura() {
        this.mutex = new Semaphore(1);
        this.escritura = new Semaphore(1);
        this.lectoresActivos = 0;
        this.recurso = new RecursoCompartido();
    }

    public void iniciarLectura() throws InterruptedException {
        mutex.acquire();
        lectoresActivos++;
        if (lectoresActivos == 1) {
            escritura.acquire();
        }
        mutex.release();

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
        escritura.acquire();
        // Escritura
        recurso.incrementarValores();
        System.out.println("Escritor " + Thread.currentThread().getId() +
                " escribe: " + recurso.toString());
    }

    public void terminarEscritura() {
        escritura.release();
    }
}