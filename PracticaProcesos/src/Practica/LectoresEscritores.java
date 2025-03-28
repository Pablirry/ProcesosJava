package Practica;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class LectoresEscritores {
    private int lectores = 0;            // Lectores activos
    private int escritoresEsperando = 0; // Escritores en espera
    private boolean escribiendo = false;  // Hay un escritor activo
    private ReentrantLock lock = new ReentrantLock();
    private Condition lectoresCondition = lock.newCondition();
    private Condition escritoresCondition = lock.newCondition();

    public void iniciarLectura() throws InterruptedException {
        lock.lock();
        try {
            // Los lectores esperan si hay un escritor activo o escritores esperando
            while (escribiendo || escritoresEsperando > 0) {
                lectoresCondition.await();
            }
            lectores++;
        } finally {
            lock.unlock();
        }
    }

    public void terminarLectura() {
        lock.lock();
        try {
            lectores--;
            // Si es el último lector, notifica a los escritores
            if (lectores == 0) {
                escritoresCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void iniciarEscritura() throws InterruptedException {
        lock.lock();
        try {
            escritoresEsperando++;
            // Espera mientras haya lectores o un escritor activo
            while (escribiendo || lectores > 0) {
                escritoresCondition.await();
            }
            escritoresEsperando--;
            escribiendo = true;
        } finally {
            lock.unlock();
        }
    }

    public void terminarEscritura() {
        lock.lock();
        try {
            escribiendo = false;
            // Si hay escritores esperando, les da prioridad
            if (escritoresEsperando > 0) {
                escritoresCondition.signal();
            } else {
                // Si no hay escritores, despierta a todos los lectores
                lectoresCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}