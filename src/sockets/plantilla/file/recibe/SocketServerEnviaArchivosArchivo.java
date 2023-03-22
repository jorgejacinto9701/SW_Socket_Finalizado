package sockets.plantilla.file.recibe;

import java.net.*;
import java.io.*;

public class SocketServerEnviaArchivosArchivo {

	private final String ARCHIVO_ORIGEN = "c:/logo.jpg";

	private final Integer PUERTO = 3456;

	private Socket socketCliente;


	public SocketServerEnviaArchivosArchivo() {
		System.out.println("FileServer: esperando peticiones TCP/IP");
		System.out.println("_______________________________________");

		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			while (true) {

				socketCliente = servidor.accept();// /esta escuchando hasta que
												// alguien se conecte
				System.out.println("SE ATENDIO A UN CLIENTE");
	
				File archivo = new File(ARCHIVO_ORIGEN);				
				FileInputStream fis = new FileInputStream(archivo);
				
				DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

				// --- procesando flujos
				int leido;
				while ((leido = fis.read()) != -1) {
					salida.write(leido);
				}

				System.out.println("EL CLIENTE " + socketCliente.getInetAddress());
				
				fis.close();
				salida.close();
				socketCliente.close();


			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SocketServerEnviaArchivosArchivo();
	}

}
