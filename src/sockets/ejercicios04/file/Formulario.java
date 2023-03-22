package sockets.ejercicios04.file;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class Formulario extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList lstArchivos;
	private JPanel pnlSur;
	private JButton btnEnviar;
	private JPanel pnlNorte;
	private JButton btnAgregar;
	private JButton btnEscoger;
	private JPanel pnlDos;
	private JPanel pnlUno;
	private JButton btnEliminar;
	private JScrollPane scp;
	private JLabel lblRuta;
	private DefaultListModel dlm;
	
	public Formulario() {
		
		dlm = new DefaultListModel();
		lstArchivos = new JList(dlm);
		scp = new JScrollPane(lstArchivos);
		
		
		getContentPane().add(scp, BorderLayout.CENTER);
		
		pnlSur = new JPanel();
		GridLayout pnlSurLayout = new GridLayout(1, 2);
		pnlSurLayout.setColumns(2);
		pnlSur.setLayout(pnlSurLayout);
		getContentPane().add(pnlSur, BorderLayout.SOUTH);

		pnlNorte = new JPanel();
		GridLayout pnlNorteLayout = new GridLayout(2, 1);
		pnlNorteLayout.setColumns(1);
		pnlNorteLayout.setRows(2);
		pnlNorte.setLayout(pnlNorteLayout);
		getContentPane().add(pnlNorte, BorderLayout.NORTH);

		pnlUno = new JPanel();
		GridLayout pnlUnoLayout = new GridLayout(1, 2);
		pnlUnoLayout.setColumns(2);
		pnlUno.setLayout(pnlUnoLayout);
		pnlNorte.add(pnlUno);

		btnEscoger = new JButton();
		pnlUno.add(btnEscoger);
		btnEscoger.setText("Escoger");

		btnAgregar = new JButton();
		pnlUno.add(btnAgregar);
		btnAgregar.setText("Agregar");

		pnlDos = new JPanel();
		BorderLayout pnlDosLayout = new BorderLayout();
		pnlDos.setLayout(pnlDosLayout);
		pnlNorte.add(pnlDos);

		lblRuta = new JLabel();
		pnlDos.add(lblRuta, BorderLayout.CENTER);
		lblRuta.setBackground(new java.awt.Color(255,255,255));
		lblRuta.setOpaque(true);
		lblRuta.setForeground(new java.awt.Color(0,0,255));
		lblRuta.setFont(new java.awt.Font("Tahoma",1,14));

		btnEnviar = new JButton();
		pnlSur.add(btnEnviar);
		btnEnviar.setText("Enviar");

		btnEliminar = new JButton();
		pnlSur.add(btnEliminar);
		btnEliminar.setText("Eliminar");
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(550, 300);
		setVisible(true);

		btnAgregar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnEnviar.addActionListener(this);
		btnEscoger.addActionListener(this);
		

	}
	
	public static void main(String[] args) {
		new Formulario();
	}

	String archivo ="";
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEscoger){
			JFileChooser jfilechooser = new JFileChooser();
			Integer valor = jfilechooser.showOpenDialog(this);
			if (valor == JFileChooser.APPROVE_OPTION){
				archivo = jfilechooser.getSelectedFile().getPath();
				lblRuta.setText(archivo);
			}
		}
		if(e.getSource() == btnAgregar){
			if(archivo.trim().length()>0 && !dlm.contains(archivo.trim())){
				dlm.addElement(archivo);
				lblRuta.setText(null);
			}
		}
		if(e.getSource() == btnEnviar){
			for (int i = 0; i < dlm.getSize(); i++) {
				new SocketClienteEnviarArchivo(String.valueOf(dlm.getElementAt(i)));
			}
		}
		if(e.getSource() == btnEliminar){
			if(!lstArchivos.isSelectionEmpty())
			dlm.removeElement(lstArchivos.getSelectedValue());
		}
	}

}
