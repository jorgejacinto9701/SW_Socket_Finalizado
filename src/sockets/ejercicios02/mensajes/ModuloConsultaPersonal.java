package sockets.ejercicios02.mensajes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class ModuloConsultaPersonal extends JFrame implements ActionListener {

	public JLabel lblDistrito;
	public JTextField txtBusqueda;
	public JLabel jLabel1;
	public JLabel lblEsatado;
	public JLabel lblFecha;
	public JLabel lblEdad;
	public JLabel lblApellido;
	public JLabel lblNombre;

	public ModuloConsultaPersonal() {
		this.setSize(370, 242);
		setLayout(new BorderLayout());

		JPanel pnlGenrico = new JPanel();
		setLayout(new GridLayout(1, 2));

		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(8, 2, 5, 5));
		pnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		pnl.add(new JLabel("Codigo:"));

		txtBusqueda = new JTextField();
		pnl.add(txtBusqueda);

		pnl.add(new JLabel("Nombre:"));

		lblNombre = new JLabel();
		pnl.add(lblNombre);
		lblNombre.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		lblNombre.setOpaque(true);
		lblNombre.setBackground(new java.awt.Color(192,192,192));

		pnl.add(new JLabel("Apellido:"));

		lblApellido = new JLabel();
		pnl.add(lblApellido);
		lblApellido.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		lblApellido.setOpaque(true);
		lblApellido.setBackground(new java.awt.Color(192,192,192));

		pnl.add(new JLabel("Edad:"));

		lblEdad = new JLabel();
		pnl.add(lblEdad);
		lblEdad.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		lblEdad.setOpaque(true);
		lblEdad.setBackground(new java.awt.Color(192,192,192));

		pnl.add(new JLabel("Fecha Nacimiento :"));

		lblFecha = new JLabel();
		pnl.add(lblFecha);
		lblFecha.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		lblFecha.setOpaque(true);
		lblFecha.setBackground(new java.awt.Color(192,192,192));

		pnl.add(new JLabel("Estado Civil:"));

		lblEsatado = new JLabel();
		pnl.add(lblEsatado);
		lblEsatado.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		lblEsatado.setOpaque(true);
		lblEsatado.setBackground(new java.awt.Color(192,192,192));

		jLabel1 = new JLabel();
		pnl.add(jLabel1);
		jLabel1.setText("Distrito");

		lblDistrito = new JLabel();
		pnl.add(lblDistrito);
		lblDistrito.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		lblDistrito.setOpaque(true);
		lblDistrito.setBackground(new java.awt.Color(192,192,192));

		pnlGenrico.add(pnl);
		add(pnlGenrico);

		txtBusqueda.addActionListener(this);
		
		setVisible(true);
		this.setTitle("Ingreso de Personal");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtBusqueda) {
			new ClienteMensaje(this);
		}
	}

	public static void main(String[] args) {
		 new ModuloConsultaPersonal();
	}

	

	
}
