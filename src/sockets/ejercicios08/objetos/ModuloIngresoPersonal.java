package sockets.ejercicios08.objetos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ModuloIngresoPersonal extends JFrame implements ActionListener,
		ListSelectionListener {

	List<BeanPersona> lstMemoriaPersonas = new ArrayList<BeanPersona>();

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

	JButton btnEnvioPorLote = new JButton("EnvioPorLote");

	DefaultListModel dtm = new DefaultListModel();

	JList jlist = new JList(dtm);

	JScrollPane jsp = new JScrollPane(jlist);

	public ModuloIngresoPersonal() {
		setSize(400, 500);
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
		pnl.add(btnEnvioPorLote);

		rbtFemenino.setSelected(true);

		group.add(rbtFemenino);
		group.add(rbtMasculino);

		btnAceptar.addActionListener(this);
		btnEnvioPorLote.addActionListener(this);
		jlist.addListSelectionListener(this);

		pnlGenrico.add(pnl);
		pnlGenrico.add(jsp);

		add(pnlGenrico);

		setVisible(true);
	}

	/*
	 * Se ingresa cada elemento a cada respexcito bean que estos asu vez son
	 * ingresados al vector
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {

			// 1_ Se Carga el Bean llamado Persona
			
			BeanPersona bean = new BeanPersona();

			bean.setCodigo(txtCodigo.getText());
			bean.setNombre(txtNombre.getText());
			bean.setApellido(txtApellido.getText());
			bean.setEdad(txtEdad.getText());

			if (rbtFemenino.isSelected()) {
				bean.setSexo("Femenino");
			} else {
				bean.setSexo("Masculino");
			}
			bean.setEstadoCivi(jcbEstCivil.getSelectedItem().toString());


			// 2_ Se agrega el bean a la lista
			lstMemoriaPersonas.add(bean);

			// 3_ Se aade al model de del JList(Componenet visual)
			dtm.addElement(bean.getNombre());
			
			//4 se procede a la limpieza
			limpiar();

		}
		
		
		if (e.getSource() == btnEnvioPorLote) {
			new ClienteObjetos(lstMemoriaPersonas);
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

	public void valueChanged(ListSelectionEvent arg0) {

			
		for (BeanPersona bean : lstMemoriaPersonas) {
			
	
			// Si existe algun bean cuyo nombre sea igual al seleccionado
			if (bean.getNombre().equals(
					(jlist.getSelectedValue().toString()))) {

				// Mostrar sus datos
				JOptionPane.showMessageDialog(this,
						"<html>" 
								+ "Nombre:  " + bean.getNombre()+ "<br>" 
								+ "Apellido: " + bean.getApellido() + "<br>" 
								+ "Sexo : " + bean.getSexo() + "<br>"
								+ "Estado Civil : " + bean.getEstadoCivi() + "<br>" 
								+ "Edad : 		" + bean.getEdad()
								+ "</html>",
						"Titulo - Personal",JOptionPane.INFORMATION_MESSAGE);

			}
		}

	}
}
