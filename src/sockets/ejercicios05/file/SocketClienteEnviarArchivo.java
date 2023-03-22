package sockets.ejercicios05.file;

import java.net.*;
import java.io.*;

public class SocketClienteEnviarArchivo {

	private final String HOST = "localhost";
	private final Integer PUERTO = 3456;

	@SuppressWarnings("unused")
	public SocketClienteEnviarArchivo(String rutas) {
		System.out.println(rutas);

		try {

			Socket cliente = new Socket(HOST, PUERTO);

			// 1 ENVO DEL NOMBRE DEL ARCHIVO
			// ====================================
			// Permite el envio de cualquier objeto
			ObjectOutputStream ous = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			String[] ruta = rutas.split(",");
			String nombres = "";
			
			for (int i = 0; i < ruta.length; i++) {
				File fileInicio = new File(ruta[i]);
				nombres = fileInicio.getName();
				if(i != ruta.length -1){
					nombres += ",";
				}
			}
			
			ous.writeObject(nombres);

			// 2 ENVO DE LOS PAQUETES DE BYTES DEL ARCHIVO
			// ============================================
			
			for (int i = 0; i < ruta.length; i++) {
				System.out.println(ruta[i]);
				File file = new File(ruta[i]);
				FileInputStream fis = new FileInputStream(file);
				DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

				int leido;
				while ((leido = fis.read()) != -1) {
					salida.write(leido);
				}
				
				fis.close();
				salida.close();
			}
			cliente.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
