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
			return "./src/ImagenesBanderas/espania.png";
			
		case"Alemania":
			return "./src/ImagenesBanderas/alemania.png";
		
		case "Francia":
			return "./src/ImagenesBanderas/francia.png";
		
		case "Italia":
			return "./src/ImagenesBanderas/italia.png";
			
		case "Marruecos":
			return "./src/ImagenesBanderas/Marruecos.png";
			
		case "Noruega":
			return "./src/ImagenesBanderas/Noruega.png";
			
		case "Portugal":
			return "./src/ImagenesBanderas/portugal.png";
		
		case "URSS":
			return "./src/ImagenesBanderas/urss.png";
			
		case "USA":
			return "./src/ImagenesBanderas/usa.png";
		
		case "Rumania":
			return "./src/ImagenesBanderas/rumania.png";	
		}
		return "";
	}
	
	public String returnRutaFondoBandera(String nombrePais) {
		switch(nombrePais) {
		case"España":
			return "./src/FondosBanderas/fondoEspana.png";
			
		case"Alemania":
			return "./src/FondosBanderas/fondoAlemania.png";
		
		case "Francia":
			return "./src/FondosBanderas/fondoFrancia.png";
		
		case "Italia":
			return "./src/FondosBanderas/fondoItalia.png";
			
		case "Marruecos":
			return "./src/FondosBanderas/fondoMarruecos.png";
			
		case "Noruega":
			return "./src/FondosBanderas/fondoNoruega.png";
			
		case "Portugal":
			return "./src/FondosBanderas/fondoPortugal.png";
		
		case "URSS":
			return "./src/FondosBanderas/fondoURSS.png";
			
		case "USA":
			return "./src/FondosBanderas/fondoUSA.png";
		
		case "Rumania":
			return "./src/FondosBanderas/fondoRumania.png";	
		}
		return "";
	}
	
	public JButton getBotonEliminar() {
		return this.botonEliminarEquipo;
	}
}
