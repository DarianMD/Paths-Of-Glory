package Juego;

import javax.swing.JFrame;

public class VentanaPartida extends JFrame {

	private PanelJuego panelJuego = new PanelJuego();
	
	
	public VentanaPartida() {
		setSize(1600,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panelJuego);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	
	
}
