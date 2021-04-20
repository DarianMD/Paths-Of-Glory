package Paneles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class PanelEquipoCreado extends JPanel{
	
	private JLabel imagenEquipo = new JLabel();
	private JLabel nombreEquipo = new JLabel();
	private Font fuenteLetra = new Font("Agency FB", Font.BOLD, 45);
	
	
	public PanelEquipoCreado() {
		setBackground(Color.white);
		setLayout(null);
		setVisible(true);
	}
	
	public void inicializarComponentesPanel(String nombreEquipo, String imagenEquipo) {
		this.imagenEquipo.setBounds(15, 30, 100, 100);
		this.imagenEquipo.setIcon(new ImageIcon(this.returnRutaImagenBandera(imagenEquipo)));
		this.add(this.imagenEquipo);
		
		this.nombreEquipo.setBounds(150, 50, 1000, 75);
		this.nombreEquipo.setText(nombreEquipo);
		this.nombreEquipo.setFont(this.fuenteLetra);
		this.add(this.nombreEquipo);
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
}
