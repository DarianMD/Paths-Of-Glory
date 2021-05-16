package JuegoPaneles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import JuegoPaises.*;;

public class PanelGanador extends JPanel {

	private JLabel etiquetaGanador = new JLabel("Gana el equipo Uno");
	private JButton botonVolverMenu = new JButton("Volver al menu");
	private JTextArea areaTextoEventosPartida = new JTextArea();
	private JScrollPane scrollBar =new JScrollPane(this.areaTextoEventosPartida,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private JLabel fondo = new JLabel();
	private Font  fuente1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 23);

	public PanelGanador() {
		setSize(1600,900);
		this.inicializarComponentes();
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		this.añadirComponentes();
		setVisible(true);
	}

	public void inicializarComponentes() {
		this.etiquetaGanador.setBounds(508,100, 500, 100);
		this.etiquetaGanador.setFont(this.fuente1);
		this.botonVolverMenu.setBounds(670, 650, 200,100);
		this.scrollBar.setBounds(530, 330, 500, 300);
		
		this.fondo.setBounds(0, 0, 1600, 900);
		this.fondo.setIcon(new ImageIcon("./assets/Fondos/fondoGanador.jpg"));
	}


	public void añadirComponentes() {
		this.add(etiquetaGanador);
		this.add(botonVolverMenu);
		this.add(scrollBar);
		this.add(fondo);
	}


	public void añadirNombreGanadorPanel(Pais equipoGanador) {
		String nombreGanador = equipoGanador.getNombre();
		this.etiquetaGanador.setText("Ha ganado el equipo "+nombreGanador);
	}



	public JLabel getEtiquetaGanador() {
		return etiquetaGanador;
	}

	public void setEtiquetaGanador(JLabel etiquetaGanador) {
		this.etiquetaGanador = etiquetaGanador;
	}

	public JButton getBotonVolverMenu() {
		return botonVolverMenu;
	}

	public void setBotonVolverMenu(JButton botonVolverMenu) {
		this.botonVolverMenu = botonVolverMenu;
	}

	public JTextArea getAreaTextoEventosPartida() {
		return areaTextoEventosPartida;
	}

	public void setAreaTextoEventosPartida(JTextArea areaTextoEventosPartida) {
		this.areaTextoEventosPartida = areaTextoEventosPartida;
	}

	public JScrollPane getScrollBar() {
		return scrollBar;
	}

	public void setScrollBar(JScrollPane scrollBar) {
		this.scrollBar = scrollBar;
	}
}
