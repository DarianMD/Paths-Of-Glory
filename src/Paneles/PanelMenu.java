package Paneles;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

//Panel del menu inicial
public class PanelMenu extends JPanel {

	private JButton botonJugar = new JButton("Jugar");
	private JButton botonContinuarPartida = new JButton("Continuar partida");
	private JButton botonComoJugar = new JButton("Como Jugar");
	private JButton botonSalir = new JButton("Salir");
	private JButton botonInfoCreadores = new JButton("Creadores");

	//TO-DO
	private JButton botonSonido = new JButton();
	private JButton botonAjustes = new JButton();
	
	private JLabel fondo = new JLabel();
	private ImageIcon fondo_guerra = new ImageIcon("/Botones/fondofinal.jpg");


	


	int sizex = 725;
	int[] sizey = new int[]{243,643,1043}; 
	int size1 = 290;
	int size2 = 100;


	public PanelMenu() {
		setSize(1600,900);
		setLayout(null);
		inicializarBotones();
		setVisible(true);
	}

	//Funcion para inicializar los botones del panel
	public void inicializarBotones() {
		this.boton_bounds();
		this.boton_image();
		this.boton_add();
	}


	public void boton_bounds(){
		
		botonJugar.setBounds(sizey[0], sizex, size1, size2);
		botonContinuarPartida.setBounds(sizey[1], sizex, size1, size2);
		botonComoJugar.setBounds(sizey[2], sizex, size1, size2);
		botonInfoCreadores.setBounds(550, 490, size1, size2);
		botonInfoCreadores.setVisible(false);
		botonSalir.setBounds(550, 620, size1, size2);
		botonSalir.setVisible(false);

	}

	public void boton_image() {
		botonJugar.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_jugar.png")));
		botonContinuarPartida.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_continuar.png")));
		botonComoJugar.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_como_jugar.png")));
		botonInfoCreadores.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_creadores.png")));
		botonSalir.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_salir.png")));

	}

	public void boton_add() {
		this.add(botonJugar);
		this.add(botonContinuarPartida);
		this.add(botonComoJugar);
		this.add(botonInfoCreadores);
		this.add(botonSalir);

	}


	//Getters de los botones
	public JButton getBotonJugar() {
		return this.botonJugar;
	}

	public JButton getBotonComoJugar() {
		return this.botonComoJugar;
	}

	public JButton getBotonCreadores() {
		return this.botonInfoCreadores;
	}

	public JButton getBotonSalir() {
		return this.botonSalir;
	}
}
