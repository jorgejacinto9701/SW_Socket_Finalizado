package sockets.plantilla.file.envio;

import java.net.*;
import java.io.*;

public class SocketServerRecibirArchivosArchivo {

	private final Integer PUERTO = 3456;

	private Socket socketCliente;


	public SocketServerRecibirArchivosArchivo() {
		System.out.println("FileServer: esperando peticiones TCP/IP");
		System.out.println("_______________________________________");

		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			while (true) {

				socketCliente = servidor.accept();// /esta escuchando hasta que
												// alguien se conecte
				System.out.println("------SE ATENDIO A UN CLIENTE--------------");
				System.out.println("EL CLIENTE " + socketCliente.getInetAddress());
				
				String ARCHIVO_DESTINO = "D:/_hasta/llego.png";
				
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


			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SocketServerRecibirArchivosArchivo();
	}

}
