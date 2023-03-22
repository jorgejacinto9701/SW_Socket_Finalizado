package sockets.ejercicios01.mensajes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMensaje {

	
	private final Integer PUERTO = 13;

	private Socket socketCliente;
	
	@SuppressWarnings("unused")
	public ServidorMensaje(){
		try {
			ServerSocket  socketServidor = new ServerSocket(PUERTO);
			while(true){
				System.out.println("______ Servidor Esperando peticiones _____");
				System.out.println("__________________________________________");

				socketCliente = socketServidor.accept();

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
				 

				String mensaje = entrada.readLine();
				
				if (mensaje.equalsIgnoreCase("Sistemas"))
					salida.println("Juan,Manuela,Maria");
				else if (mensaje.equalsIgnoreCase("Logistica"))
					salida.println("Pedro,Sonia,Elsa,Jhonny");
				else if (mensaje.equalsIgnoreCase("Ventas"))
					salida.println("Teresa,Alberto,Maria,Patty");
				
				 
				 socketCliente.close();	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ServidorMensaje();
	}

}
