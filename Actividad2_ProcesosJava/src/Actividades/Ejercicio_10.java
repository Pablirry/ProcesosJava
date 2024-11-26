package Actividades;

import java.io.File;
import java.io.IOException;

public class Ejercicio_10 {
	
	public static void main(String[] args) throws IOException {
	
	File outputFile = new File("D:\\DAM_AFA\\2-DAM-1\\Programacion_de_servicios_y_procesos\\Workspace-procesos\\Actividad2_ProcesosJava\\output.txt");
	
	ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", "dir", "C:\\Users\\pablo");
	
	proceso.redirectOutput(outputFile);
	
	proceso.start();
	
	}

}
