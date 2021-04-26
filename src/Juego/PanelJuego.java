package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Juego.Paises.*;

import javax.swing.*;

public class PanelJuego extends JPanel implements ActionListener {

	
	private ModeloPartida partida = new ModeloPartida();
	
	private Pais equipoJugandoTurno;
	
	private JTextArea mensajesEventosJuego = new JTextArea();
	private JButton botonAtacar = new JButton("Atacar");
	private JButton pasarTurno = new JButton("Pasar turno");
	
	public PanelJuego() {
		setSize(1600,900);
		setVisible(true);
	}
	
	
	public void inicializarComponentes() {
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
