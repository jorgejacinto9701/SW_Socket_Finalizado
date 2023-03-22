package sockets.plantilla.file;

import java.net.*;
import java.io.*;

public class ServidorArchivo {

	private final Integer PUERTO = 3456;

	private Socket socketCliente;

	private final String ARCHIVO = "C:/AAAA.txt";

	
	public ServidorArchivo() {

		try {
			ServerSocket socketServidor = new ServerSocket(PUERTO);
			while (true) {
				System.out.println("______ Servidor Esperando peticiones _____");
				System.out.println("__________________________________________");
				
				socketCliente = socketServidor.accept();
				
				//--------------------------------------------
				//   Medios para la comunicacin para FILE
				//--------------------------------------------
				File archivo = new File(ARCHIVO);				
				FileInputStream fis = new FileInputStream(archivo);
				FileOutputStream fos = new FileOutputStream(archivo);
				
				DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
				DataInputStream entrada =	new DataInputStream(socketCliente.getInputStream());
				
				//--------------------------------------------
				//  Empieza la comunicacin!!!!
				//--------------------------------------------

				
				
				
				
				
				
				


				fis.close();
				fos.close();
				salida.close();
				entrada.close();
				socketCliente.close();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServidorArchivo();
	}

}
