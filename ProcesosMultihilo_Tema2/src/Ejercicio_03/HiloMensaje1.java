package Ejercicio_03;

public class HiloMensaje1 extends Thread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Mensaje " + (i + 1) + " hilo 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Hilo 1 interrumpido");
            }
        }
    }

}
