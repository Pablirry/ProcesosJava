package ejemplos;

public class Principal {

    public static void main(String[] args) {
        
        Ejemplo_multihilo1 hilo1 = new Ejemplo_multihilo1();
        Ejemplo_multihilo2 hilo2 = new Ejemplo_multihilo2();

        hilo1.start();
        hilo2.start();
    }

    public static class Ejemplo_multihilo1 extends Thread {

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i + " -> Hilo 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("No se puede ejecutar el hilo 1");
                }
            }
        }
    }

    public static class Ejemplo_multihilo2 extends Thread {

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i + " -> Hilo 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("No se puede ejecutar el hilo 2");
                }
            }
        }
    }
}
