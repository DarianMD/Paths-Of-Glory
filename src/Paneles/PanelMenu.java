package Paneles;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

//Panel del menu inicial
public class PanelMenu extends JPanel {


	private JButton botonJugar = new JButton("Jugar");
	private JButton botonContinuarPartida = new JButton("Continuar partida");
	private JButton botonComoJugar = new JButton("Como Jugar");
	private JButton botonSalir = new JButton("Salir");
	private JButton botonInfoCreadores = new JButton("Creadores");
	private JButton botonSiguiente = new JButton("Siguiente");
	private JButton botonAnterior = new JButton("Anterior");


	//TO-DO
	private JButton botonSonido = new JButton();
	

	private JButton botonAjustes = new JButton();

	private JLabel fondo = new JLabel();
	private ImageIcon fondo_guerra = new ImageIcon("./assets/Fondos/fondo_final.jpg");
	
	private JLabel marco = new JLabel();
	private ImageIcon marco_menu = new ImageIcon("./assets/Fondos/marco_menu.png");
	

	JButton[] buttons = new JButton[] {botonJugar, botonContinuarPartida,botonSalir,botonComoJugar,botonInfoCreadores};
	int num = 0;
	int contador = 0;
	int botones = 0;

	int sizex = 725;
	int[] sizey = new int[]{243,643,1043}; 
	int size1 = 280;
	int size2 = 90;

	int size_move1 = 85;
	int size_move2 = 100;
	int[] loc_move = new int[] {50,1428};
	



	public PanelMenu() {
		setSize(1600,900);
		setLayout(null);
		inicializarBotones();
	}

	//Funcion para inicializar los botones del panel
	public void inicializarBotones() {
		
		this.boton_image();
		this.boton_bounds();
		this.marco_add();
		this.fondo_add();
		repaint();
	}


	public void boton_bounds(){
	
		botonSiguiente.setBounds(loc_move[1], sizex, size_move1, size_move2);
		botonAnterior.setBounds(loc_move[0], sizex, size_move1, size_move2);

		for(int y = 0; y < buttons.length; y++) {
			buttons[y].setVisible(false);
		}

		for(int x = 0; x < buttons.length; x++) {
			if(x == num && x >= 0 && x <= 2) {
				buttons[x].setBounds(sizey[0 + num], sizex, size1, size2);
				buttons[x].setVisible(true);
				num++;
				contador++;
			}
			else {
				buttons[x].setVisible(false);}

			
		}
	
	}
		
		

	 public void boton_image() {
		botonJugar.setIcon(new ImageIcon("./assets/Botones/Botones_Menu/boton_jugar.png"));
		botonContinuarPartida.setIcon(new ImageIcon("./assets/Botones/Botones_Menu/boton_continuar.png"));
		botonComoJugar.setIcon(new ImageIcon("./assets/Botones/Botones_Menu/boton_como_jugar.png"));
		botonInfoCreadores.setIcon(new ImageIcon("./assets/Botones/Botones_Menu/boton_creadores.png"));
		botonSalir.setIcon(new ImageIcon("./assets/Botones/Botones_Menu/boton_salir.png"));
		botonSiguiente.setIcon(new ImageIcon("./assets/Botones/Botones_Menu/flecha_derecha.png"));
		botonAnterior.setIcon(new ImageIcon("./assets/Botones/Botones_Menu/flecha_izquierda.png"));
		
		this.add(botonAnterior);
		this.add(botonSiguiente);
		this.add(botonJugar);
		this.add(botonContinuarPartida);
		this.add(botonComoJugar);
		this.add(botonInfoCreadores);
		this.add(botonSalir);
		
	
	} 

			
	public void fondo_add() {
		fondo.setBounds(0, 0, 1600, 900);
		fondo.setIcon(fondo_guerra);
		this.add(fondo);

	}
	
	public void marco_add() {
		marco.setBounds(0, 0, 1600, 900);
		marco.setIcon(marco_menu);
		this.add(marco);

	}
	
	public void Siguiente() {

		int numero = 0;
		
		for(int x = 0; x < buttons.length; x++) {
					
			if( x >= contador) {
				buttons[x].setBounds(sizey[0 + numero], sizex, size1, size2);
				buttons[x].setVisible(true);
				numero++;
			
			}
			else {
				buttons[x].setVisible(false);
			}
		} 

	
		
	}

	public void Anterior() {

		int numero = 0;
		int contadors = 3;
		
		for(int x = 0; x < buttons.length; x++) {

			if(x < contadors ) {
				buttons[x].setBounds(sizey[0 + numero], sizex, size1, size2);
				buttons[x].setVisible(true);
				numero++;
			}
			else {
				buttons[x].setVisible(false);
			}
		}
		
	
		
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

	public JButton getBotonAnterior() {
		return this.botonAnterior;
	}

	public JButton getBotonSiguiente() {
		return this.botonSiguiente;
	}
	
	public JButton getBotonContinuarPartida() {
		return botonContinuarPartida;
	}

	public void setBotonContinuarPartida(JButton botonContinuarPartida) {
		this.botonContinuarPartida = botonContinuarPartida;
	}
}