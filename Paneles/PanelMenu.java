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
	private ImageIcon fondo_guerra = new ImageIcon("/Botones/fondofinal.jpg");

	JButton[] buttons = new JButton[] {botonJugar, botonContinuarPartida,botonSalir,botonComoJugar,botonInfoCreadores};
	int num = 0;
	int contador = 0;
	int botones = 0;

	int sizex = 725;
	int[] sizey = new int[]{243,643,1043}; 
	int size1 = 290;
	int size2 = 100;

	int size_move1 = 100;
	int size_move2 = 100;
	int[] loc_move = new int[] {50,1428};



	public PanelMenu() {
		setSize(1600,900);
		setLayout(null);
		inicializarBotones();
		setVisible(true);
	}

	//Funcion para inicializar los botones del panel
	public void inicializarBotones() {
		this.boton_bounds();
		this.boton_add();
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
		} 

		contador--;
	}

	/* public void boton_image() {
		botonJugar.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_jugar.png")));
		botonContinuarPartida.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_continuar.png")));
		botonComoJugar.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_como_jugar.png")));
		botonInfoCreadores.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_creadores.png")));
		botonSalir.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/Boton_Menu/boton_salir.png")));

	} */

	public void boton_add() {
		this.add(botonAnterior);
		this.add(botonSiguiente);
		this.add(botonJugar);
		this.add(botonContinuarPartida);
		this.add(botonComoJugar);
		this.add(botonInfoCreadores);
		this.add(botonSalir);

	}

	public void Siguiente() {

		num = 0;
		contador += 1;
		botones = 0;
		
		for(int x = 0; x < buttons.length; x++) {
			botones += 1;

			
			if(botones + 1 > 4) {
				botones = 0;
			}
			
			if(contador + 1 > 4) {
				contador = 0;
			}
			else {
				contador++;
			}
			
			System.out.println("Botones : " + botones);
			System.out.println("Contador : " + contador);
			System.out.println("Num : " + num);			

			if(botones >= contador) {
				
				buttons[botones].setBounds(sizey[0 + num], sizex, size1, size2);
				buttons[botones].setVisible(true);
				if(num + 1 > 2) {
					num--;
				}
				else {
					num++;
				}
			}
			else {
				buttons[botones].setVisible(false);
			}

		} 


	}

	public void Anterior() {
		int anterior = 0;
		int siguiente = 2;

		for(int x = 0; x < buttons.length; x++) {


			if(x == num && x >= anterior - 1 && x <= siguiente - 1 ) {
				buttons[x].setBounds(sizey[0 + num], sizex, size1, size2);
				buttons[x].setVisible(true);
				num++;
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
}