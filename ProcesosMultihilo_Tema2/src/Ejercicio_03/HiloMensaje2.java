package Ejercicio_03;

public class HiloMensaje2 extends Thread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Mensaje " + (i + 1) + " hilo 2");
            try {
                Thread.sleep(1025);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	

}
