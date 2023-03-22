package sockets.ejercicios04.file;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class SocketServerRecibirArchivosArchivo {

	private final Integer PUERTO = 3456;

	private Socket cliente;

	public SocketServerRecibirArchivosArchivo() {
		System.out.println("FileServer: esperando peticiones TCP/IP");
		System.out.println("_______________________________________");

		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			while (true) {

				cliente = servidor.accept();

				// 1 RECIBE DEL NOMBRE DEL ARCHIVO
				// ====================================
				// Permite el envio de cualquier objeto
				ObjectOutputStream ous = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

				String fileName = (String) ois.readObject();
				System.out.println("EL NOMBRE DEL ARCHIVO :" + fileName);
				String ARCHIVO_DESTINO = "D:/_hasta/" + fileName;

				// Recibe solo archivos PDF
				String extension = fileName.substring(fileName.length() - 3);
				if (extension.equals("pdf")) {

					// 2 RECIBE LOS PAQUETES DE BYTES DEL ARCHIVO
					// ============================================
					// --- creando los flujos
					File archivoDestino = new File(ARCHIVO_DESTINO);
					FileOutputStream fos = new FileOutputStream(archivoDestino);
					DataInputStream entrada = new DataInputStream(cliente.getInputStream());

					int leido;
					while( (leido = entrada.read())!= -1){
						fos.write(leido);
					}

					fos.close();
					entrada.close();
				}
				cliente.close();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SocketServerRecibirArchivosArchivo();
	}

}
