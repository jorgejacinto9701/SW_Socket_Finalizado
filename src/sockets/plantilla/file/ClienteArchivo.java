package sockets.plantilla.file;

import java.net.*;
import java.io.*;

public class ClienteArchivo {

	private final String HOST = "localhost";

	private final Integer PUERTO = 3456;

	private final String ARCHIVO = "C:/AAAAA.txt";

	public ClienteArchivo() {
		Socket socketCliente = null;
		try {
			socketCliente = new Socket(HOST, PUERTO);

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
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ClienteArchivo();
	}

}
