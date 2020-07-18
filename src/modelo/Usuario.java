package modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String nombre;
	private int puntaje;
	private int nivel;
	
	public Usuario(String nombre, int puntaje, int nivel) {
		
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.nivel = nivel;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * @param puntaje the puntaje to set
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public String toString() {
		return "Nombre: " + nombre + "     Puntaje: " + puntaje + "      Nivel: " + nivel + "\n";
		
		
	}
}
