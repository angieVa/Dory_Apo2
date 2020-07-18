package hilo;

import java.util.ArrayList;

import interfaz.Ventana;
import modelo.Peces;



public class HiloPeces extends Thread {

	private Ventana ventana;
	private ArrayList<Peces> peces;
	
	public HiloPeces(ArrayList<Peces> peces, Ventana ventana) {
		this.peces = peces;
		this.ventana = ventana;
	}
	
	public void run() {
		
		while(true) {
			
			int nivel = ventana.getInfo().getLevel();
			if(nivel == 0) {
				
				for(int i=0; i<peces.size();i++) {

					peces.get(i).mover(5);	
				}
			}else if(nivel == 1) {
				
				for(int i=0; i<peces.size();i++) {

					peces.get(i).mover(12);	
				}
			}else if(nivel == 2) {
			
				for(int i=0; i<peces.size();i++) {

					peces.get(i).mover(17);	
				}
			}else if(nivel == 3) {
			
			for(int i=0; i<peces.size();i++) {

				peces.get(i).mover(25);
			}
		}
			try {
				
				Thread.sleep(50);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ventana.repaint();
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
	 * @return the peces
	 */
	public ArrayList<Peces> getPeces() {
		return peces;
	}

	/**
	 * @param peces the peces to set
	 */
	public void setPeces(ArrayList<Peces> peces) {
		this.peces = peces;
	}

	
}
