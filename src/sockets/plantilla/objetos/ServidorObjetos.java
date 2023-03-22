package sockets.plantilla.objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorObjetos {

	
	private final Integer PUERTO = 13;

	private Socket socketCliente;
	
	@SuppressWarnings("unused")
	public ServidorObjetos(){
		try {
			ServerSocket  socketServidor = new ServerSocket(PUERTO);
			while(true){
				System.out.println("______ Servidor Esperando peticiones _____");
				System.out.println("__________________________________________");

				socketCliente = socketServidor.accept();

				//--------------------------------------------
				//   Medios para la comunicacin para OBJETOS
				//--------------------------------------------
				ObjectOutputStream salida=new ObjectOutputStream(socketCliente.getOutputStream());
				ObjectInputStream entrada= new ObjectInputStream(socketCliente.getInputStream());
		
				//salida.writeObject
				//entrada.readObject()
				//--------------------------------------------
				//  Empieza la comunicacin!!!!
				//--------------------------------------------
					
				 

				
				
				
				
				 
				entrada.close();
				salida.close();
				socketCliente.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServidorObjetos();
	}

}
