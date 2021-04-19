package Paneles;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Panel donde se enseñan los equipos una vez creados
public class PanelDisplayEquipos extends JPanel {
	
	private JLabel fondo = new JLabel();
	private ImageIcon iconoFondo = new ImageIcon("./src/Fondos/fondoEquipos.png");
	
	public PanelDisplayEquipos() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(Color.gray);
		setVisible(true);
	}
	
	public void addFondo() {
		fondo.setBounds(0, 0, 1200, 710);
		fondo.setIcon(iconoFondo);
		this.add(fondo);
	}
}