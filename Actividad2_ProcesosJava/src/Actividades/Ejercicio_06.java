package Actividades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio_06 {
	
	public static void main(String[] args) {

        try {
            // Notepad
            ProcessBuilder notepadProcessBuilder = new ProcessBuilder("notepad.exe");

            // Redirigir la salida de errores de Notepad
            notepadProcessBuilder.redirectErrorStream(true);

            // Iniciar el proceso de Notepad
            Process notepadProcess = notepadProcessBuilder.start();

            // Capturar la salida de Notepad
            BufferedReader notepadReader = new BufferedReader(new InputStreamReader(notepadProcess.getInputStream()));
            String notepadLine;
            while ((notepadLine = notepadReader.readLine()) != null) {
                System.out.println(notepadLine);
            }

            // Esperar a que Notepad finalice antes de iniciar la Calculadora
            int notepadExitCode = notepadProcess.waitFor();
            System.out.println("\nNotepad terminado con el código: " + notepadExitCode);

            // Lanzar la Calculadora
            ProcessBuilder calcProcessBuilder = new ProcessBuilder("calc.exe");

            // Redirigir la salida de errores de la Calculadora
            calcProcessBuilder.redirectErrorStream(true);

            // Iniciar el proceso de la Calculadora
            Process calcProcess = calcProcessBuilder.start();

            // Capturar la salida de la Calculadora
            BufferedReader calcReader = new BufferedReader(new InputStreamReader(calcProcess.getInputStream()));
            String calcLine;
            while ((calcLine = calcReader.readLine()) != null) {
                System.out.println(calcLine);
            }

            // Esperar a que la Calculadora finalice
            int calcExitCode = calcProcess.waitFor();
            System.out.println("\nCalculadora terminada con el código: " + calcExitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
