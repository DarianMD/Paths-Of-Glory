package JuegoPaneles;

import java.awt.Color;
import java.awt.Font;
import java.util.Hashtable;

import javax.swing.*;

public class PanelPartida extends JPanel {

	//Text area donde se ponen los eventos de cada turno
	private JTextArea areaMensajesPartida = new JTextArea();

	//Botones principales para acciones en cada turno
	private JButton botonAtacar = new JButton("Atacar");
	private JButton botonDefender = new JButton("Defender");
	private JButton botonPasarTurno = new JButton("Pasar turno");

	//Etiquetas del menu de la partida
	private JLabel etiquetaNombreEquipoJugandoTurno = new JLabel();
	private JLabel etiquetaVidasRestantesEquipos = new JLabel();
	private JLabel etiquetaCantidadAtaque = new JLabel();
	private JLabel etiquetaEnergiaEquipo = new JLabel("Energia : 50");
	private JLabel fondo = new JLabel();
	private ImageIcon imagenFondo = new ImageIcon("./assets/Fondos/jugarfondo.png");
	

	//Slider para elegir la cantidad de energia a usar
	private JSlider sliderCantidadAtaque = new JSlider();

	//Caja donde se muestan los nombres de los equipos enemigos
	JComboBox cajaNombresEquiposEnemigos = new JComboBox();

	
	Font  fuente1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 25);


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
		this.areaMensajesPartida.setBounds(200, 30,986, 500);
		this.areaMensajesPartida.setEditable(false);
	    
		this.botonAtacar.setBounds(1150,750,200,100);
		this.botonAtacar.setEnabled(false);
		
		this.botonDefender.setBounds(1370,750, 200, 100);
		
		this.botonPasarTurno.setBounds(10,  750, 200, 100);

		this.sliderCantidadAtaque.setBounds(1160, 620, 400, 50);
		this.sliderCantidadAtaque.setValue(0);
		this.sliderCantidadAtaque.setMaximum(50);
		
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( 0 ), new JLabel("0") );
		labelTable.put( new Integer( 50/2 ), new JLabel("25") );
		labelTable.put( new Integer( 50 ), new JLabel("50") );
		sliderCantidadAtaque.setLabelTable( labelTable );
		sliderCantidadAtaque.setPaintLabels(true);

		this.etiquetaCantidadAtaque.setBounds(1169, 560, 300, 50);
		this.etiquetaCantidadAtaque.setText("50");

		this.cajaNombresEquiposEnemigos.setBounds(1380, 0, 200, 30);
		
		this.etiquetaVidasRestantesEquipos.setBounds(20, 300, 200, 200);
		
		this.etiquetaNombreEquipoJugandoTurno.setBounds(20, 50, 200, 100);
		
		this.etiquetaEnergiaEquipo.setBounds(20, 150, 200, 100);
		
		fondo.setBounds(0, 0, 1600, 900);
		fondo.setIcon(imagenFondo);
		
	}
	


	public void añadirComponentesPanel() {
		this.add(areaMensajesPartida);
		this.add(botonAtacar);
		this.add(botonDefender);
		this.add(botonPasarTurno);
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
