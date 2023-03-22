package sockets.plantilla.file.envio;

import java.net.*;
import java.io.*;

public class SocketClienteEnviarArchivo {

	private final String HOST = "localhost";

	private final Integer PUERTO = 3456;

	private final String ARCHIVO_ORIGEN = "D:/_desde/imagen.png";

	public SocketClienteEnviarArchivo() {
		

		try {
			Socket socketCliente = new Socket(HOST, PUERTO);

			File archivo = new File(ARCHIVO_ORIGEN);				
			FileInputStream fis = new FileInputStream(archivo);
			
			DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

			// --- procesando flujos
			int leido;
			while ((leido = fis.read()) != -1) {
				salida.write(leido);
			}

			fis.close();
			salida.close();
			socketCliente.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new SocketClienteEnviarArchivo();
	}

}
