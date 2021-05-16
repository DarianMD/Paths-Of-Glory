package JuegoPaneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.*;

import Paneles.VentanaJuego;
import utils.ModeloDatos;

public class PanelPartida extends JPanel {

	//Text area donde se ponen los eventos de cada turno
	private JTextArea areaMensajesPartida = new JTextArea();

	
	

	//Botones principales para acciones en cada turno
	private JButton botonAtacar = new JButton("Atacar");
	private JButton botonDefender = new JButton("Defender");
	private JButton botonPasarTurno = new JButton("Pasar turno");
	private JButton botonGuardar = new JButton("Guardar");
	private JScrollPane scrollBar =new JScrollPane(this.areaMensajesPartida,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


	//Etiquetas del menu de la partida
	private JLabel etiquetaNombreEquipoJugandoTurno = new JLabel();
	private JLabel etiquetaVidasRestantesEquipos = new JLabel();
	private JLabel etiquetaCantidadAtaque = new JLabel();
	private JLabel etiquetaEnergiaEquipo = new JLabel("Energia : 50");
	private JLabel fondo = new JLabel();
	private JLabel fondoNombresEquipos = new JLabel();
	private ImageIcon imagenFondo = new ImageIcon("./assets/Fondos/jugarfondo.png");
	
	

	//Slider para elegir la cantidad de energia a usar
	private JSlider sliderCantidadAtaque = new JSlider();

	//Caja donde se muestan los nombres de los equipos enemigos
	JComboBox cajaNombresEquiposEnemigos = new JComboBox();

	
	private Font  fuente1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 23);
	private Font  fuente2  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 17);



	public JButton getBotonGuardar() {
		return botonGuardar;
	}


	public void setBotonGuardar(JButton botonGuardar) {
		this.botonGuardar = botonGuardar;
	}


	//Constructor
	public PanelPartida() {
		setSize(1600,900);
		setLayout(null);
		this.inicializarComponentes();
		setVisible(true);
	}

	
	public void inicializarComponentes() {
		this.colocarComponentesPanel();
		this.añadirComponentesPanel();
	}

	public void colocarComponentesPanel() {
		
		this.scrollBar.setBounds(450, 100,1000, 500);	    
		this.botonAtacar.setBounds(1000,750,185,100);
		this.botonAtacar.setEnabled(false);
		this.botonAtacar.setIcon(new ImageIcon("./assets/Botones/Botones_Juego/boton_atacar.jpg"));

		
		this.botonDefender.setBounds(1250,750, 185, 100);
		this.botonDefender.setIcon(new ImageIcon("./assets/Botones/Botones_Juego/boton_defender.jpg"));

		
		this.botonPasarTurno.setBounds(10,  750, 188, 100);
		this.botonPasarTurno.setIcon(new ImageIcon("./assets/Botones/Botones_Juego/boton_pasar_turno.jpg"));

		
		this.botonGuardar.setBounds(300, 750,185,100);
		this.botonGuardar.setIcon(new ImageIcon("./assets/Botones/Botones_Juego/boton_guardar.jpg"));


		this.sliderCantidadAtaque.setBounds(1000, 620, 400, 100);
		this.sliderCantidadAtaque.setValue(0);
		this.sliderCantidadAtaque.setMaximum(50);
		
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( 0 ), new JLabel("0") );
		labelTable.put( new Integer( 50/2 ), new JLabel("25") );
		labelTable.put( new Integer( 50 ), new JLabel("50") );
		sliderCantidadAtaque.setLabelTable( labelTable );
		sliderCantidadAtaque.setPaintLabels(true);

		this.etiquetaCantidadAtaque.setBounds(1500, 640, 300, 50);
		this.etiquetaCantidadAtaque.setFont(this.fuente1);
		this.etiquetaCantidadAtaque.setText("0");

		this.cajaNombresEquiposEnemigos.setBounds(1150, 0, 400, 60);
		this.cajaNombresEquiposEnemigos.setFont(fuente2);
		
		this.etiquetaVidasRestantesEquipos.setBounds(20, 300, 200, 200);
		this.etiquetaVidasRestantesEquipos.setFont(fuente2);
		
		this.etiquetaNombreEquipoJugandoTurno.setBounds(20, 50, 500, 500);
		this.etiquetaNombreEquipoJugandoTurno.setFont(fuente1);
		
		this.etiquetaEnergiaEquipo.setBounds(20, 150, 200, 100);
		this.etiquetaEnergiaEquipo.setFont(fuente1);
		
		fondo.setBounds(0, 0, 1600, 900);
		fondo.setIcon(imagenFondo);
		
		
		
	}
	


	public void añadirComponentesPanel() {
		this.add(scrollBar);
		this.add(botonAtacar);
		this.add(botonDefender);
		this.add(botonPasarTurno);
		this.add(botonGuardar);
		this.add(sliderCantidadAtaque);
		this.add(etiquetaCantidadAtaque);
		this.add(cajaNombresEquiposEnemigos);
		this.add(etiquetaVidasRestantesEquipos);
		this.add(etiquetaNombreEquipoJugandoTurno);
		this.add(etiquetaEnergiaEquipo);
		this.add(fondo);
	}

	
	
	//Setters y getters
	public JTextArea getAreaMensajesPartida() {
		return areaMensajesPartida;
	}


	public void setAreaMensajesPartida(JTextArea areaMensajesPartida) {
		this.areaMensajesPartida = areaMensajesPartida;
	}


	public JButton getBotonAtacar() {
		return botonAtacar;
	}


	public void setBotonAtacar(JButton botonAtacar) {
		this.botonAtacar = botonAtacar;
	}


	public JButton getBotonDefender() {
		return botonDefender;
	}


	public void setBotonDefender(JButton botonDefender) {
		this.botonDefender = botonDefender;
	}


	public JButton getBotonPasarTurno() {
		return botonPasarTurno;
	}


	public void setBotonPasarTurno(JButton botonPasarTurno) {
		this.botonPasarTurno = botonPasarTurno;
	}


	public JLabel getEtiquetaNombreEquipoJugandoTurno() {
		return etiquetaNombreEquipoJugandoTurno;
	}


	public void setEtiquetaNombreEquipoJugandoTurno(JLabel etiquetaNombreEquipoJugandoTurno) {
		this.etiquetaNombreEquipoJugandoTurno = etiquetaNombreEquipoJugandoTurno;
	}


	public JLabel getEtiquetaVidasRestantesEquipos() {
		return etiquetaVidasRestantesEquipos;
	}


	public void setEtiquetaVidasRestantesEquipos(JLabel etiquetaVidasRestanesEquipos) {
		this.etiquetaVidasRestantesEquipos = etiquetaVidasRestanesEquipos;
	}


	public JLabel getEtiquetaCantidadAtaque() {
		return etiquetaCantidadAtaque;
	}


	public void setEtiquetaCantidadAtaque(JLabel etiquetaCantidadAtaque) {
		this.etiquetaCantidadAtaque = etiquetaCantidadAtaque;
	}


	public JSlider getSliderCantidadAtaque() {
		return sliderCantidadAtaque;
	}


	public void setSliderCantidadAtaque(JSlider sliderCantidadAtaque) {
		this.sliderCantidadAtaque = sliderCantidadAtaque;
	}


	public JComboBox getCajaNombresEquiposEnemigos() {
		return cajaNombresEquiposEnemigos;
	}


	public void setCajaNombresEquiposEnemigos(JComboBox cajaNombresEquiposEnemigos) {
		this.cajaNombresEquiposEnemigos = cajaNombresEquiposEnemigos;
	}


	public JLabel getEtiquetaEnergiaEquipo() {
		return etiquetaEnergiaEquipo;
	}


	public void setEtiquetaEnergiaEquipo(JLabel etiquetaEnergiaEquipo) {
		this.etiquetaEnergiaEquipo = etiquetaEnergiaEquipo;
	}
	
	

	

}
