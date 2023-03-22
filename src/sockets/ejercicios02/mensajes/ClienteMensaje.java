package sockets.ejercicios02.mensajes;

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

			ModuloConsultaPersonal formulario = (ModuloConsultaPersonal) form;
			
			//1 se envia el codigo al servidor		 
			salida.println(formulario.txtBusqueda.getText()); 
			
			//2 recibe los parametros
			String[] mensaje = entrada.readLine().split(",");
			 
			//3 Se muestra en el formulario
			formulario.lblNombre.setText(mensaje[0]);
			formulario.lblApellido.setText(mensaje[1]);
			formulario.lblEdad.setText(mensaje[2]);
			formulario.lblFecha.setText(mensaje[3]);
			formulario.lblEsatado.setText(mensaje[4]);
			formulario.lblDistrito.setText(mensaje[5]);
			
			socketCliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
