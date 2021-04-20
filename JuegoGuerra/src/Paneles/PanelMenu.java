package Paneles;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

//Panel del menu inicial
public class PanelMenu extends JPanel {
	
	private JButton botonJugar = new JButton("Jugar");
	private JButton botonComoJugar = new JButton("Como Jugar");
	private JButton botonSalir = new JButton("Salir");
	private JButton botonInfoCreadores = new JButton("Creadores");
	
	//TO-DO
	private JButton botonSonido = new JButton();
	private JButton botonAjustes = new JButton();
	
	
	
	public PanelMenu() {
		setSize(1600,900);
		setLayout(null);
		inicializarBotones();
		setVisible(true);
	}
	
	//Funcion para inicializar los botones del panel
	public void inicializarBotones() {
		botonJugar.setBounds(650, 100, 300, 100);
		botonComoJugar.setBounds(650, 200, 300, 100);
		botonInfoCreadores.setBounds(650, 300, 300, 100);
		botonSalir.setBounds(650, 400, 300, 100);
		
		this.add(botonJugar);
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
