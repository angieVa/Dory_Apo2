package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelOceano extends JPanel implements MouseListener {

	private Ventana ventana;
	private JLabel imagen;
	private int puntaje = 0;
	public PanelOceano(Ventana vent) {
		
		ventana = vent;
			
		setBorder( new LineBorder( Color.GRAY ));
		setBackground( Color.WHITE );
		setLayout(new GridLayout(1,1));
		setPreferredSize(new Dimension( 650, 610));
		
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	
		Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage ("datos/ima.jpeg");
        g.drawImage (imagen, 0, 0, this);
		
		
		
		for(int i = 0; i < ventana.getPeces().size(); i++) {
			
			int x = ventana.getPeces().get(i).getX();
			int y = ventana.getPeces().get(i).getY();
			int w = ventana.getPeces().get(i).getW();
			int h = ventana.getPeces().get(i).getH();
			
			g.setColor(Color.BLACK);
			g.fillOval(x, y, w, h);
			g.drawOval(x,y,w,h);
			
			if(ventana.getPeces().get(i).getNombre().equals("datos/Destiny.png")) {
				
				 t = Toolkit.getDefaultToolkit ();
		         imagen = t.getImage (ventana.getPeces().get(i).getNombre());
		         g.drawImage (imagen, ventana.getPeces().get(i).getX()-50,ventana.getPeces().get(i).getY()-10 , this);
				
			}else if(ventana.getPeces().get(i).getNombre().equals("datos/Chiqui.png")) {
				
				 t = Toolkit.getDefaultToolkit ();
		         imagen = t.getImage (ventana.getPeces().get(i).getNombre());
		         g.drawImage (imagen, ventana.getPeces().get(i).getX()-2,ventana.getPeces().get(i).getY()-25 , this);
				
			}else if(ventana.getPeces().get(i).getNombre().equals("datos/Hank.png")) {
				
				 t = Toolkit.getDefaultToolkit ();
		         imagen = t.getImage (ventana.getPeces().get(i).getNombre());
		         g.drawImage (imagen, ventana.getPeces().get(i).getX()-55,ventana.getPeces().get(i).getY()-17 , this);
				
			}else if(ventana.getPeces().get(i).getNombre().equals("datos/Dory.png")) {
				
				 t = Toolkit.getDefaultToolkit ();
		         imagen = t.getImage (ventana.getPeces().get(i).getNombre());
		         g.drawImage (imagen, ventana.getPeces().get(i).getX()-40,ventana.getPeces().get(i).getY()-10 , this);
				
			}else if(ventana.getPeces().get(i).getNombre().equals("datos/MrRaya.png")) {
				
				 t = Toolkit.getDefaultToolkit ();
		         imagen = t.getImage (ventana.getPeces().get(i).getNombre());
		         g.drawImage (imagen, ventana.getPeces().get(i).getX()-36,ventana.getPeces().get(i).getY()-7 , this);
				
			}else {
				 t = Toolkit.getDefaultToolkit ();
		         imagen = t.getImage (ventana.getPeces().get(i).getNombre());
		         g.drawImage (imagen, ventana.getPeces().get(i).getX()-17,ventana.getPeces().get(i).getY()-15 , this);
			}
		

			
			if(ventana.getPeces().get(i).getX()>=650) {
				
				ventana.getPeces().get(i).seguir();
			}
				
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent evento) {
		
		if(evento.getButton() == MouseEvent.BUTTON1) {
			if(ventana.isComenzar() == true) {
			if(evento.getX() >= ventana.getPeces().get(3).getX() && evento.getX() <= ventana.getPeces().get(3).getX()+ 50) {
				
				if(evento.getY() >= ventana.getPeces().get(3).getY() && evento.getY() <= ventana.getPeces().get(3).getY()+80) {
					
					puntaje += 2;
					setPuntaje(puntaje);
					ventana.subirPuntaje(puntaje);
				}else {
					
					puntaje -= 2;
					setPuntaje(puntaje);
					ventana.subirPuntaje(puntaje);
					
				}
			}else {
				puntaje -= 2;
				setPuntaje(puntaje);
				ventana.subirPuntaje(puntaje);
				
			}

			
		}else {
			JOptionPane.showMessageDialog(this, "De click en Iniciar para comenzar el juego", "Error", JOptionPane.WARNING_MESSAGE);
		}
			
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
	 * @return the imagen
	 */
	public JLabel getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
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

	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
