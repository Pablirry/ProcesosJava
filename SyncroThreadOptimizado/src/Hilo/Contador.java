package Hilo;

public class Contador {
	
	private int cuenta;
    private String nombreHilo;

    public Contador(String nombreHilo) {
        super();
        this.cuenta = 0;
        this.nombreHilo = nombreHilo;
    }

    public synchronized void incrementar() {
        cuenta++;
        System.out.println("Cuenta actual: " + cuenta  + nombreHilo);
    }

}
