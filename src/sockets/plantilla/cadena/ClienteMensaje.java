package sockets.plantilla.cadena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteMensaje {
	
	private final String HOST = "localhost";

	private final Integer PUERTO = 13;
	
	 @SuppressWarnings("unused") 
	public ClienteMensaje(){
		
		Socket socketCliente = null;
		try {
			socketCliente = new Socket(HOST,PUERTO);
			//--------------------------------------------
			//   Medios para la comunicacin para MENSAJE
			//--------------------------------------------
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(),true);
			
			// salida.println() -> Permite enviar mensajes
 			// entrada.readLine() -> Permite recibir mensajes
			
			//--------------------------------------------
			//  Empieza la comunicacin!!!!
			//--------------------------------------------


			 
			 
			
			
			
			
			socketCliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 new ClienteMensaje();
	}

}
