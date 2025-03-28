package Practica;

public class RecursoCompartido {
    private int[] buffer;

    public RecursoCompartido() {
        this.buffer = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    public void incrementarValores() {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i]++;
        }
    }

    public int[] leerBuffer() {
        return buffer.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < buffer.length; i++) {
            sb.append(buffer[i]);
            if (i < buffer.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}