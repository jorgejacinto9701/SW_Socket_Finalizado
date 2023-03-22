package sockets.ejercicios09.mixto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteObjetos {
	
	private final String HOST = "localhost";

	private final Integer PUERTO = 13;
	
	 @SuppressWarnings("unused") 
	public ClienteObjetos(){
		
		Socket socketCliente = null;
		try {
			socketCliente = new Socket(HOST,PUERTO);
			//--------------------------------------------
			//   Medios para la comunicacin para OBJETOS
			//--------------------------------------------
			ObjectOutputStream salida=new ObjectOutputStream(socketCliente.getOutputStream());
			ObjectInputStream entrada= new ObjectInputStream(socketCliente.getInputStream());

			//--------------------------------------------
			//  Empieza la comunicacin!!!!
			//--------------------------------------------


			 
			 
			
			
			
			entrada.close();
			salida.close();
			socketCliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 new ClienteObjetos();
	}

}
