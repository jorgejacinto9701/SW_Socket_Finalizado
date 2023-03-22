package sockets.ejercicios07.objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorObjetos {

	
	private final Integer PUERTO = 13;

	private Socket socketCliente;
	
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

				//--------------------------------------------
				//  Empieza la comunicacin!!!!
				//--------------------------------------------
					
				 try {
					BeanPersona bean = (BeanPersona) entrada.readObject();
					System.out.println(bean.getCodigo());
					System.out.println(bean.getNombre());
					System.out.println(bean.getApellido());
					System.out.println(bean.getEdad());
					System.out.println(bean.getEstadoCivi());
					System.out.println(bean.getSexo());
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				  
				 
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
