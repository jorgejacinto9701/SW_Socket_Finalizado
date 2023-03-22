package sockets.ejercicios07.objetos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class ModuloIngresoPersonal extends JFrame implements ActionListener {

	String EstadoCivil[] = { "Soltero", "Casado", "Viudo", "Divorciado" };

	String NombreAplicacion = "Ingreso de Personal";

	JTextField txtCodigo = new JTextField();

	JTextField txtNombre = new JTextField();

	JTextField txtApellido = new JTextField();

	JTextField txtEdad = new JTextField();

	ButtonGroup group = new ButtonGroup();

	JRadioButton rbtMasculino = new JRadioButton("Masculino");

	JRadioButton rbtFemenino = new JRadioButton("Femenino");

	JComboBox jcbEstCivil = new JComboBox(EstadoCivil);

	JLabel lblImagen 		= new JLabel();
	String ruta;

	/*
	 * Se crea el boton aceptar que permitir el ingreso del personal
	 */

	JButton btnAceptar = new JButton("Ingresar");

	JButton btnLimpiar = new JButton("Limpiar");


	public ModuloIngresoPersonal() {
		this.setSize(400, 320);
		setLayout(new BorderLayout());

		JPanel pnlGenrico = new JPanel();
		setLayout(new GridLayout(1, 2));

		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(8, 2, 5, 5));
		pnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		pnl.add(new JLabel("Codigo:"));
		pnl.add(txtCodigo);

		pnl.add(new JLabel("Nombre:"));
		pnl.add(txtNombre);

		pnl.add(new JLabel("Apellido:"));
		pnl.add(txtApellido);

		pnl.add(new JLabel("Edad:"));
		pnl.add(txtEdad);

		pnl.add(new JLabel("Sexo:"));
		JPanel pnl01 = new JPanel();
		pnl01.setLayout(new FlowLayout());
		pnl01.add(rbtFemenino);
		pnl01.add(rbtMasculino);
		pnl.add(pnl01);

		pnl.add(new JLabel("Estado Civil:"));
		pnl.add(jcbEstCivil);

		pnl.add(btnAceptar);
		pnl.add(btnLimpiar);

		rbtFemenino.setSelected(true);

		group.add(rbtFemenino);
		group.add(rbtMasculino);

		btnAceptar.addActionListener(this);
		btnLimpiar.addActionListener(this);

		pnlGenrico.add(pnl);
		add(pnlGenrico);

		setVisible(true);
		this.setTitle("Ingreso de Personal");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			new ClienteObjetos(this);
		}
		if (e.getSource() == btnLimpiar) {
			limpiar();
		}

	}

	public static void main(String[] args) {
		 new ModuloIngresoPersonal();
	}

	public void limpiar() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEdad.setText("");

		rbtFemenino.setSelected(true);
		jcbEstCivil.setSelectedIndex(0);

		lblImagen.setIcon(null);
	}


	
}
