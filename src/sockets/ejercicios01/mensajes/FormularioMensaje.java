package sockets.ejercicios01.mensajes;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class FormularioMensaje extends JFrame implements ActionListener{
	public JButton btnEnvio;
	public JComboBox jcbArea;
	public JTextArea txtMensaje;

	public FormularioMensaje(){
		setSize(500,300);
		setLayout(new BorderLayout());
		
		btnEnvio = new JButton();
		btnEnvio.setText("Envio Mensaje");
		btnEnvio.addActionListener(this);
		add(btnEnvio, BorderLayout.SOUTH);
		
		txtMensaje = new JTextArea();
		add(txtMensaje, BorderLayout.CENTER);

		jcbArea = new JComboBox(new String[] {"Sistemas", "Logistica" ,"Ventas"});
		add(jcbArea, BorderLayout.NORTH);

		
		setVisible(true);
	}
	public static void main(String[] args) {
		new FormularioMensaje();

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEnvio){
			new ClienteMensaje(this);
		}
		
	}

}
