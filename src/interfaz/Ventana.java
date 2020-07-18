package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.sun.istack.internal.logging.Logger;

import hilo.HiloPeces;
import modelo.Peces;
import modelo.Usuario;

public class Ventana extends JFrame{
	
	private PanelOpciones opcion;
	private PanelOceano oceano;
	private PanelInformacion info;
	private ArrayList<Peces> peces;
	private ArrayList<Usuario> listaU;
	private String usuario = "";
	private int scoreU;
	private boolean comenzar;
	private PanelLista lista;
	
	public Ventana() {
		
		setTitle("Atrapando a Dory");
		setSize(650, 690);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		oceano = new PanelOceano(this);
		add(oceano, BorderLayout.NORTH);
		
		info = new PanelInformacion(this);
		add(info, BorderLayout.CENTER);
		
		opcion = new PanelOpciones(this);
		add(opcion, BorderLayout.SOUTH);
	
		peces = new ArrayList<Peces>();
		listaU = new ArrayList<Usuario>();
		
		añadirPeces();

		
		pack(); 
	}

	public void añadirPeces() {
		 
		Peces pez = new Peces(80,320,30,30, "datos/Destiny.png");
		peces.add(pez);
		
		pez = new Peces(110,400,30,30, "datos/Chiqui.png");
		peces.add(pez);
		
		pez = new Peces(210,290,30,30, "datos/Hank.png");
		peces.add(pez);
		
		pez = new Peces(60,500,30,30, "datos/Dory.png");
		peces.add(pez);
		
		pez = new Peces(240,430,30,30, "datos/MrRaya.png");
		peces.add(pez);
		
		pez = new Peces(340,380,30,30, "datos/Nemo.png");
		peces.add(pez);
		
	}
	
	public void moverPeces() {
		HiloPeces hiloP = new HiloPeces(peces, this);
		hiloP.start();
	}

	public void PonerUsuario() {
		
		usuario = opcion.getUsuario();
		setUsuario(usuario);
		info.removeAll();
		info.refrescarInfo(usuario);
		info.updateUI();
	}
	
	public void subirPuntaje(int puntaje) {
		
		PonerUsuario();
		info.removeAll();
		int score = puntaje;
		info.setScore(puntaje);
		
		if(info.getScore() < 10) {
			
			int level = 1;
			info.setLevel(level);
			
		}else if(info.getScore() >= 10 && info.getScore() < 20) {
			int level = 2;
			info.setLevel(level);
			
			
		}else {
			int level = 3;
			info.setLevel(level);
			
		}
		
		PonerUsuario();

	}


	public void guardarPuntajes() {
		
		 String ruta = "archivos/datos.txt";
		 File archivo = new File(ruta);
		 FileOutputStream salida = null;
		 ObjectOutputStream writer = null;
		 Usuario usuarioTemp = null;
		 
		try {
			
			System.out.println("Escribiendo en archivo");
			salida = new FileOutputStream(archivo);
			writer = new ObjectOutputStream(salida);
			
			usuarioTemp = new Usuario(usuario, info.getScore(), info.getLevel());
			
			listaU.add(usuarioTemp);
			writer.writeObject(listaU);
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
        	
        	if(salida != null) {
        		try {
        			salida.close();
        			if(writer != null) {
        				writer.close();
        			}
        		}catch(IOException ex){
        			
        			ex.printStackTrace();
        			
        		}
        	}
        }
		
	} 
	
	public void leerPuntajes() {
		
		FileInputStream entrada = null;
		ObjectInputStream reader = null;
		File archivo = new File ("archivos/datos.txt");
		        try {
					
		        	System.out.println("Leyendo archivo");
		        	entrada = new FileInputStream(archivo);
		        	reader = new ObjectInputStream(entrada);
		        	
		        	listaU = (ArrayList<Usuario>) reader.readObject();
		        	
		        	for(Usuario lis:listaU) {
		        		
		        		System.out.println(lis.toString());
		        	}
		        	
		        }catch(Exception ex){
		        	ex.printStackTrace();
		       
		        }finally {
		        	if(entrada != null) {
		        		try {
		        			entrada.close();
		        			if(reader != null) {
		        				reader.close();
		        			}
		        		
		        		}catch(IOException ex) {
		        			
		        			ex.printStackTrace();
		        	}
		        	
		        }
		        }
	}
	
	public void OrganizarPuntuaciones() {
		
		lista.refrescarLista(listaU);
		
	}
	
	public void guardarUsuario(String nombre, int puntaje, int nivel) {
		
		Usuario usuario1 = new Usuario(nombre, puntaje, nivel);
		listaU.add(usuario1);
		
	}
	

	
/**
	public void prueba() {
		
		for(int i = 0; i < listaU.size(); i++) {
			
			System.out.println("---------------------");
			System.out.println(listaU.get(i).toString());
			
		}
		
		
	}
*/

	public int valorScore() {
		
		return info.getScore();
	}
	
	public int valorLevel() {
		
		return info.getLevel();
	}
	
	
	/**
	 * @return the opcion
	 */
	public PanelOpciones getOpcion() {
		return opcion;
	}


	/**
	 * @param opcion the opcion to set
	 */
	public void setOpcion(PanelOpciones opcion) {
		this.opcion = opcion;
	}


	/**
	 * @return the oceano
	 */
	public PanelOceano getOceano() {
		return oceano;
	}


	/**
	 * @param oceano the oceano to set
	 */
	public void setOceano(PanelOceano oceano) {
		this.oceano = oceano;
	}


	/**
	 * @return the info
	 */
	public PanelInformacion getInfo() {
		return info;
	}


	/**
	 * @param info the info to set
	 */
	public void setInfo(PanelInformacion info) {
		this.info = info;
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
	
	
	/**
	 * @return the comenzar
	 */
	public boolean isComenzar() {
		return comenzar;
	}

	/**
	 * @param comenzar the comenzar to set
	 */
	public void setComenzar(boolean comenzar) {
		this.comenzar = comenzar;
	}


	/**
	 * @return the listaU
	 */
	public ArrayList<Usuario> getListaU() {
		return listaU;
	}

	/**
	 * @param listaU the listaU to set
	 */
	public void setListaU(ArrayList<Usuario> listaU) {
		this.listaU = listaU;
	}

	/**
	 * @return the scoreU
	 */
	public int getScoreU() {
		return scoreU;
	}

	/**
	 * @param scoreU the scoreU to set
	 */
	public void setScoreU(int scoreU) {
		this.scoreU = scoreU;
	}

	public static void main(String[] args) {
		
		Ventana juego = new Ventana();
		PanelLista listaA = new PanelLista(juego);
		juego.setVisible(true);
		listaA.setVisible(true);
		juego.moverPeces();
	}
}
