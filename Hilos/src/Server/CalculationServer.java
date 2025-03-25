package Server;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class CalculationServer {
    private static final int PORT = 9878; 
    private static final ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor de cálculo en ejecución...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                pool.execute(new CalculationHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CalculationHandler implements Runnable {
    private Socket socket;
    
    public CalculationHandler(Socket socket) {
        this.socket = socket;
    }

@Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("Ingrese una operación (ej. 5 + 3):");
            String operation = reader.readLine();
            String result = evaluateExpression(operation);
            writer.println("Resultado: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String evaluateExpression(String operation) {
        try {
            String[] parts = operation.split(" ");
            int num1 = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int num2 = Integer.parseInt(parts[2]);
            switch (operator) {
                case "+": return String.valueOf(num1 + num2);
                case "-": return String.valueOf(num1 - num2);
                case "*": return String.valueOf(num1 * num2);
                case "/": return num2 != 0 ? String.valueOf(num1 / num2) : "Error: División por cero";
                default: return "Operación no válida";
            }
        } catch (Exception e) {
            return "Error en la entrada";
        }
    }
}

