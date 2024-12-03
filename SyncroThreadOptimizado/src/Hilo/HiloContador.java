package Hilo;

public class HiloContador extends Thread {
	
	private Contador contador;

    public HiloContador() {
        this.contador = new Contador(" " + this.getName());
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            contador.incrementar();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido.");
            }
        }
    }

}
