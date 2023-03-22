package sockets.ejercicios08.objetos;

import java.io.Serializable;

@SuppressWarnings("serial")

public class BeanPersona implements Serializable{
	
	private String codigo;
	private String nombre;
	private String apellido;
	private String edad;
	private String sexo;
	private String estadoCivi;
	
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getEstadoCivi() {
		return estadoCivi;
	}
	public void setEstadoCivi(String estadoCivi) {
		this.estadoCivi = estadoCivi;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

}
