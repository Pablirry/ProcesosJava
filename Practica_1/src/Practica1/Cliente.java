package Practica1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	
	public static void main(String[] args) {
        String host = "localhost"; // Dirección del servidor
        int puerto = 12345;       // Puerto del servidor

        // Intentar establecer una conexión con el servidor
        try (Socket socket = new Socket(host, puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor!");

            // Leer el mensaje de bienvenida del servidor
            System.out.println("Servidor: " + entrada.readLine());

            String mensaje;
            // Enviar mensajes al servidor desde la consola
            while (true) {
                System.out.print("Tu mensaje: ");
                mensaje = teclado.readLine();

                // Si el mensaje es "salir", cerrar la conexión
                if ("salir".equalsIgnoreCase(mensaje)) {
                    System.out.println("Cerrando conexión...");
                    break;
                }

                // Enviar mensaje al servidor
                salida.println(mensaje);

                // Leer la respuesta del servidor
                System.out.println("Servidor: " + entrada.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
