package sockets.ejercicios07.objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class ClienteObjetos {
	
	private final String HOST = "localhost";

	private final Integer PUERTO = 13;
	
	 @SuppressWarnings("unused") 
	public ClienteObjetos(JFrame form){
		
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

			//Empezamos a recibir los parametros del formulario
			ModuloIngresoPersonal formulario = (ModuloIngresoPersonal)form;
			
			//Se crea un objeto donde sew establece los parametros
			BeanPersona bean = new BeanPersona();
			bean.setCodigo(formulario.txtCodigo.getText());
			bean.setNombre(formulario.txtNombre.getText());
			bean.setApellido(formulario.txtApellido.getText());
			bean.setEdad(formulario.txtEdad.getText());

			if (formulario.rbtFemenino.isSelected()) {
				bean.setSexo("Femenino");
			} else {
				bean.setSexo("Masculino");
			}
			bean.setEstadoCivi(formulario.jcbEstCivil.getSelectedItem().toString());
		
			salida.writeObject(bean);
			
			
			 
			
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
		 
	}

}
