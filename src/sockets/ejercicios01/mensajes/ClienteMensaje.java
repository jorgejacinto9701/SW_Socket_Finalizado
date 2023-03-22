package sockets.ejercicios01.mensajes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class ClienteMensaje {
	
	private final String HOST = "localhost";

	private final Integer PUERTO = 13;
	
	 @SuppressWarnings("unused") 
	public ClienteMensaje(JFrame form){
		
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

			FormularioMensaje formulario = (FormularioMensaje)form;

			//1 se envia el area al cual pertenece
			String mensaje = formulario.jcbArea.getSelectedItem().toString();
			salida.println(mensaje);
			 
			//2 se recibe los integrantes de la area constituida
			String[] integrantes = entrada.readLine().split(",");
			 
			
			//3 limpio la caja de texto
			formulario.txtMensaje.setText("");
			
			//4 se pinta en la caja de texto los integrantes
			for (String empleado : integrantes) {
				formulario.txtMensaje.append(empleado+ "\n")	;
			}
			
			
			
			
			socketCliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
