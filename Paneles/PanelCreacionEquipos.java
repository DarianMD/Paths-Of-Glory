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
	
	
	
	public PanelCreacionEquipos() {
		setSize(1600,900);
		setLayout(null);
		inicializarBotones();
		setVisible(true);
	}
	
	//Funcion para inicializar los botones
	public void inicializarBotones() {
		botonCrearEquipo.setBounds(30, 30, 300, 100);
		botonJugarPartida.setBounds(1270, 750, 300, 100);
		botonVolverMenu.setBounds(30, 750, 300, 100);
		
		
		
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
