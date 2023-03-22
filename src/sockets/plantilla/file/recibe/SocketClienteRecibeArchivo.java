package sockets.plantilla.file.recibe;

import java.net.*;
import java.io.*;

public class SocketClienteRecibeArchivo {

	private final String HOST = "10.21.5.31";

	private final Integer PUERTO = 3456;

	private final String ARCHIVO_DESTINO = "c:/copia.jpg";

	public SocketClienteRecibeArchivo() {
		

		try {
			Socket socketCliente = new Socket(HOST, PUERTO);


			// --- creando los flujos
			File archivoDestino = new File(ARCHIVO_DESTINO);
			FileOutputStream fos = new FileOutputStream(archivoDestino);
			
			DataInputStream entrada =
				new DataInputStream(socketCliente.getInputStream());

			// ---procesando flujos
			int leido;
			while ((leido = entrada.read()) != -1) {
				fos.write(leido);
			}

			fos.close();
			entrada.close();
			socketCliente.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new SocketClienteRecibeArchivo();
	}

}
