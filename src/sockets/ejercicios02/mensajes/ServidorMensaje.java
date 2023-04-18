package sockets.ejercicios02.mensajes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServidorMensaje {

	private final Integer PUERTO = 13;

	private Socket socketCliente;

	@SuppressWarnings("unused")
	public ServidorMensaje() {
		try {
			ServerSocket socketServidor = new ServerSocket(PUERTO);
			while (true) {
				System.out
						.println("______ Servidor Esperando peticiones _____");
				System.out
						.println("__________________________________________");

				socketCliente = socketServidor.accept();

				// --------------------------------------------
				// Medios para la comunicacin para MENSAJE
				// --------------------------------------------
				BufferedReader entrada = new BufferedReader(
						new InputStreamReader(socketCliente.getInputStream()));
				PrintWriter salida = new PrintWriter(socketCliente
						.getOutputStream(), true);

				// salida.println() -> Permite enviar mensajes
				// entrada.readLine() -> Permite recibir mensajes


				
				
				socketCliente.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String buscaUsuario(String codigo) {

		String sentenciaSQL = "select * from tb_vendedor where cod_ven = ? ";

		String cadena = null;
		try {
			// 1 Se Carga el Driver de Coneccion(Archivo *.jar)
			Class.forName("com.mysql.jdbc.Driver");

			// 2 Se pide acceso a la base de Datos
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_struts", "root", "admin");

			// 3 Se prepara la sentencia
			PreparedStatement pstmt = cnx.prepareStatement(sentenciaSQL);
			pstmt.setString(1, codigo);

			// 4 Se ejecuta la sentencia
			ResultSet rs = pstmt.executeQuery();

			// 5 Se coge el valor recibido y se manda al parametro nombre
			if (rs.next()) {
				 cadena = rs.getString(2)+ "," +
				 		  rs.getString(3)+ "," +
				 		  rs.getString(4)+ "," +
				 		  rs.getString(5)+ "," +
				 		  rs.getString(6)+ "," +
				 		  rs.getString(7);
			}

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente excepcion "
					+ e.getMessage());
		}
		return cadena;
	}

	public static void main(String[] args) {
		new ServidorMensaje();
	}

}
