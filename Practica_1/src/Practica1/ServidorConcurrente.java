package Practica1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorConcurrente {
	
	public static void main(String[] args) {
        int puerto = 12345; // Puerto del servidor

        // Intentar abrir un socket de servidor en el puerto especificado
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                // Esperar a que un cliente se conecte
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + clienteSocket.getInetAddress());

                // Crear un hilo para manejar al cliente
                new Thread(new ManejadorCliente(clienteSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}

// Clase para manejar a cada cliente en un hilo separado
class ManejadorCliente implements Runnable {
    private Socket clienteSocket;

    public ManejadorCliente(Socket socket) {
        this.clienteSocket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true)
        ) {
            // Enviar mensaje de bienvenida al cliente
            salida.println("Bienvenido al servidor multihilo!");

            String mensaje;
            // Leer mensajes del cliente
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Mensaje de " + clienteSocket.getInetAddress() + ": " + mensaje);

                // Responder al cliente
                salida.println("Servidor recibió: " + mensaje);
            }
        } catch (IOException e) {
            System.err.println("Error con el cliente: " + e.getMessage());
        } finally {
            try {
                clienteSocket.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el socket del cliente: " + e.getMessage());
            }
        }
    }


}
