package Paneles;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Panel que contiene el creador de equipos y el panel donde se ven los equipos ya creados
public class PanelCreacionEquipos extends JPanel {
	
	//Botones panel
	private JButton botonCrearEquipo = new JButton("Añadir equipo");
	private JButton botonJugarPartida = new JButton("Jugar");
	private JButton botonVolverMenu = new JButton("Volver al menu");
	
	private JLabel fondo = new JLabel();
	private ImageIcon imagenFondo = new ImageIcon("./assets/Fondos/FondoMenuEquipos.png");
	
	//Panel donde se veran los equipos
	private PanelDisplayEquipos panelEquipos = new PanelDisplayEquipos();
	
	
	int size_y = 285;
	int size_x = 100;
	
	
	public PanelCreacionEquipos() {
		setSize(1600,900);
		setLayout(null);
		inicializarBotones();
		setVisible(true);
	}
	
	//Funcion para inicializar los botones
	public void inicializarBotones() {
		botonCrearEquipo.setBounds(30, 30, size_y, size_x);
		botonJugarPartida.setBounds(1270, 750, size_y, size_x);
		botonVolverMenu.setBounds(30, 750, size_y, size_x);
		
		
		botonCrearEquipo.setIcon(new ImageIcon("./assets/Botones/Botones_Equipos/boton_añadir_equipo.jpg"));
		botonVolverMenu.setIcon(new ImageIcon("./assets/Botones/Botones_Equipos/boton_volver_al_menu.jpg"));
		botonJugarPartida.setIcon(new ImageIcon("./assets/Botones/Botones_Equipos/boton_jugar.jpg"));


		this.add(botonCrearEquipo);
		this.add(botonJugarPartida);
		this.add(botonVolverMenu);
		
	}
	
	public void addFondoPantalla() {
		
		fondo.setBounds(0, 0, 1600, 900);
		fondo.setIcon(imagenFondo);
		
		this.add(fondo);
	}
	
	//Elimina todas las modificaciones que hayamos hecho al panel dejandolo por defecto
	public void limpiarPanelCreacionEquipos() {
		setBackground(null);
	}
	
	//Getters
	public JButton getBotonCrearEquipo() {
		return this.botonCrearEquipo;
	}
	
	public JButton getBotonJugarPartida() {
		return this.botonJugarPartida;
	}
	
	public JButton getBotonVolverMenu() {
		return this.botonVolverMenu;
	}
	
	public PanelDisplayEquipos getPanelDisplayEquipos() {
		return this.panelEquipos;
	}
}
