package Actividades;

public class Ejercicio_13 {

	public static void main(String[] args) {
		try {
			ProcessBuilder proceso1 = new ProcessBuilder("cmd", "/c", "echo Poceso 1");
			Process p1 = proceso1.start();
			
			int exitCode = p1.waitFor();
			
			System.out.println("Proceso 1 finalizó con código " + exitCode);
			
			if(exitCode == 0) {
				ProcessBuilder proceso11 = new ProcessBuilder("cmd", "/c", "echo Proceso 1.1");
				Process p11 = proceso11.start();
				int exitCode2 = p11.waitFor();
				System.out.println("Proceso 1.1 finalizó con código " + exitCode2);
			}else {
				ProcessBuilder proceso12 = new ProcessBuilder("cmd", "/c", "echo Proceso 1.2");
				Process p12 = proceso12.start();
				int exitCode3 = p12.waitFor();
				System.out.println("Proceso 1.2 finalizó con código " + exitCode3);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
