package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelInformacion extends JPanel{
	
	private JLabel jugador;
	private JLabel puntos;
	private JLabel nivel;
	private Ventana ventana;
	private String nom;
	private int score;
	private int level;
	
	public PanelInformacion(Ventana vent) {
		
		ventana = vent;
		
		TitledBorder border = BorderFactory.createTitledBorder( "Juego" );
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		
		setLayout(new GridLayout(1,6));
		setPreferredSize(new Dimension( 650, 50));
		
		score = 0;
		level = 0;
		setNom(ventana.getUsuario());
		refrescarInfo(nom);
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score =+ score;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	public void refrescarInfo(String usuario) {
		jugador = new JLabel("Jugador: " + usuario);
		puntos = new JLabel("Puntos: " + score);
		nivel = new JLabel("Nivel: " + level);
		
		add(jugador);
		add(puntos);
		add(nivel);
		
	}

	/**
	 * @return the jugador
	 */
	public JLabel getJugador() {
		return jugador;
	}

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(JLabel jugador) {
		this.jugador = jugador;
	}

	/**
	 * @return the puntos
	 */
	public JLabel getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(JLabel puntos) {
		this.puntos = puntos;
	}

	/**
	 * @return the nivel
	 */
	public JLabel getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(JLabel nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the ventana
	 */
	public Ventana getVentana() {
		return ventana;
	}

	/**
	 * @param ventana the ventana to set
	 */
	public void setVentana(Ventana ventana) {
		this.ventana = ventana;
	}
	
	public String darNombre() {
		
		String nombre = jugador.getText() + " ";
		return nombre;
	}
	
	public String darPuntaje() {
		
		String puntaje = puntos.getText() + " ";
		return puntaje;
	}
	
	public String darNivel() {
		
		String level = nivel.getText();
		return level;
	}
}
