package Paneles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class PanelEquipoCreado extends JPanel{
	
	private JLabel imagenEquipo = new JLabel();
	private JLabel nombreEquipo = new JLabel();
	private Font fuenteLetra = new Font("Arial", Font.BOLD, 45);
	private JButton botonEliminarEquipo = new JButton("X");
	
	private JLabel fondo = new JLabel();
	
	
	public PanelEquipoCreado() {
		setLayout(null);
		setVisible(true);
	}
	
	public void inicializarComponentesPanel(String nombreEquipo, String imagenEquipo) {
		this.imagenEquipo.setBounds(15, 30, 100, 100);
		this.imagenEquipo.setIcon(new ImageIcon(this.returnRutaImagenBandera(imagenEquipo)));
		this.add(this.imagenEquipo);
		
		this.nombreEquipo.setBounds(150, 75, 1000, 75);
		this.nombreEquipo.setText(nombreEquipo);
		this.nombreEquipo.setFont(this.fuenteLetra);
		this.nombreEquipo.setForeground(Color.white);
		this.add(this.nombreEquipo);
		
		
		botonEliminarEquipo.setBounds(1100,100,50,50);
		this.add(botonEliminarEquipo);
		
		fondo.setBounds(0, 0, 1170, 160);
		this.fondo.setIcon(new ImageIcon(this.returnRutaFondoBandera(imagenEquipo)));
		this.add(fondo);
	}
	
	//Devuelve la ruta relativa de las imagenes de bandera
	public String returnRutaImagenBandera(String nombrePais) {
		
		switch(nombrePais) {
		case"España":
			return "./assets/ImagenesBanderas/espania.png";
			
		case"Alemania":
			return "./assets/ImagenesBanderas/alemania.png";
		
		case "Francia":
			return "./assets/ImagenesBanderas/francia.png";
		
		case "Italia":
			return "./assets/ImagenesBanderas/italia.png";
			
		case "Marruecos":
			return "./assets/ImagenesBanderas/Marruecos.png";
			
		case "Noruega":
			return "./assets/ImagenesBanderas/Noruega.png";
			
		case "Portugal":
			return "./assets/ImagenesBanderas/portugal.png";
		
		case "URSS":
			return "./assets/ImagenesBanderas/urss.png";
			
		case "USA":
			return "./assets/ImagenesBanderas/usa.png";
		
		case "Rumania":
			return "./assets/ImagenesBanderas/rumania.png";	
		}
		return "";
	}
	
	public String returnRutaFondoBandera(String nombrePais) {
		switch(nombrePais) {
		case"España":
			return "./assets/FondosBanderas/fondoEspana.png";
			
		case"Alemania":
			return "./assets/FondosBanderas/fondoAlemania.png";
		
		case "Francia":
			return "./assets/FondosBanderas/fondoFrancia.png";
		
		case "Italia":
			return "./assets/FondosBanderas/fondoItalia.png";
			
		case "Marruecos":
			return "./assets/FondosBanderas/fondoMarruecos.png";
			
		case "Noruega":
			return "./assets/FondosBanderas/fondoNoruega.png";
			
		case "Portugal":
			return "./assets/FondosBanderas/fondoPortugal.png";
		
		case "URSS":
			return "./assets/FondosBanderas/fondoURSS.png";
			
		case "USA":
			return "./assets/FondosBanderas/fondoUSA.png";
		
		case "Rumania":
			return "./assets/FondosBanderas/fondoRumania.png";	
		}
		return "";
	}
	
	public JButton getBotonEliminar() {
		return this.botonEliminarEquipo;
	}
}
