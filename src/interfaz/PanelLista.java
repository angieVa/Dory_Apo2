package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import modelo.Usuario;

public class PanelLista extends JFrame{

	
	private JList listaUsuarios;
	private JScrollPane scroll;
	private Ventana ventana;
	
	public PanelLista(Ventana ventana) {
		
		setTitle("Puntuaciones");
		setSize(400, 400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,0));
		
		listaUsuarios = new JList();
		scroll = new JScrollPane(listaUsuarios);
		
		listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(scroll);
		
		
	}
	
	
	public void refrescarLista(ArrayList<Usuario> usuarios) {
		
		listaUsuarios.setListData(usuarios.toArray());
		listaUsuarios.setSelectedIndex(0);
		
	}
}
