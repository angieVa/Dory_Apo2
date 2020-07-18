package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener{
	
	public static final String GUARDAR = "Guardar";
	public static final String INICIAR = "Iniciar";
	public static final String VER_PUNTAJES = "Ver puntajes";
	
	
	private Ventana ventana;
	private JButton butGuardar;
	private JButton butIniciar;
	private JButton butPuntajes;
	private boolean comenzar;
	private String usuario;
	

	public PanelOpciones(Ventana vent) {
		
		ventana = vent;
		
		TitledBorder border = BorderFactory.createTitledBorder( "Opciones" );
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		
		setLayout(new GridLayout(1,3));
		setPreferredSize(new Dimension( 650, 50));
		
		butGuardar = new JButton("Guardar");
		butGuardar.setActionCommand(GUARDAR);
		butGuardar.addActionListener( this );
		
		butIniciar = new JButton("Iniciar");
		butIniciar.setActionCommand(INICIAR);
		butIniciar.addActionListener( this );
		
		butPuntajes = new JButton("Ver puntajes");
		butPuntajes.setActionCommand(VER_PUNTAJES);
		butPuntajes.addActionListener(this);
		
		add(butGuardar);
		add(butPuntajes);
		add(butIniciar);
		
			}
	
	public void actionPerformed(ActionEvent evento) {
		
		String comando = evento.getActionCommand();
		
		if(comando.equals(INICIAR)) {
			
			usuario = JOptionPane.showInputDialog(this, "Introduzca su nombre de usuario");
				if(usuario != null) {
				
				if(usuario.equals("")) {
					
					JOptionPane.showMessageDialog(this, "Introduzca un nombre de usuario válido", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					setUsuario(usuario);
					ventana.PonerUsuario();
					comenzar = true;
					ventana.setComenzar(comenzar);
				
				}
			}
			
		}else if(comando.equals(GUARDAR)) {
			
			ventana.guardarPuntajes();
			JOptionPane.showMessageDialog(this, "Se guardado con exito", "Guardar", JOptionPane.INFORMATION_MESSAGE);
			
		}else if(comando.equals(VER_PUNTAJES)) {
			String op = JOptionPane.showInputDialog(null,"1. Buscar por puntaje"
                    +"2.  Ver por Nombre"
                    +"3.  Ver por puntaje");
                  

			ventana.leerPuntajes();
			ventana.OrganizarPuntuaciones();
			
			
		}
	
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

	/**
	 * @return the butGuardar
	 */
	public JButton getButGuardar() {
		return butGuardar;
	}

	/**
	 * @param butGuardar the butGuardar to set
	 */
	public void setButGuardar(JButton butGuardar) {
		this.butGuardar = butGuardar;
	}

	/**
	 * @return the butIniciar
	 */
	public JButton getButIniciar() {
		return butIniciar;
	}

	/**
	 * @param butIniciar the butIniciar to set
	 */
	public void setButIniciar(JButton butIniciar) {
		this.butIniciar = butIniciar;
	}

	/**
	 * @return the butPuntajes
	 */
	public JButton getButPuntajes() {
		return butPuntajes;
	}

	/**
	 * @param butPuntajes the butPuntajes to set
	 */
	public void setButPuntajes(JButton butPuntajes) {
		this.butPuntajes = butPuntajes;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
