package Paneles;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelComoJugar extends JPanel {
	
	private JButton botonSiguiente = new JButton("Siguiente");
	private JButton botonAnterior = new JButton("Anterior");
	private JButton botonVolverMenu = new JButton("Volver al menu");
	//Imagen de fondo
	private JLabel fondo2 = new JLabel();
	private ImageIcon imagenFondo2 = new ImageIcon("./assets/Fondos/comojugar.png");
	//Fondos reglas
	private JLabel reglas = new JLabel();
	private ImageIcon juego = new ImageIcon("./assets/Fondos/comojugar.png");
	private ImageIcon tipos = new ImageIcon("./assets/Fondos/comojugar2.png");
	private ImageIcon estadisticas = new ImageIcon("./assets/Fondos/comojugar3.png");
	private ImageIcon controles = new ImageIcon("./assets/Fondos/comojugar4.png");
	
	
	public int numeroReglas;
	
	public PanelComoJugar() {
		setSize(1600,900);
		setLayout(null);
		inicializarBotones();
		setVisible(true);
	}
	
	
	public void inicializarBotones() {

		botonVolverMenu.setBounds(30, 25, 285, 100);
		botonAnterior.setBounds(150, 660, 88, 100);
		botonSiguiente.setBounds(1350, 660, 88, 100);
		
		
	
		botonVolverMenu.setIcon(new ImageIcon("./assets/Botones/Botones_Equipos/boton_volver_al_menu.jpg"));
		botonAnterior.setIcon(new ImageIcon("./assets/Botones/Botones_Equipos/atras.png"));
		botonSiguiente.setIcon(new ImageIcon("./assets/Botones/Botones_Equipos/siguiente.png"));
	
		
		this.add(botonSiguiente);
		this.add(botonAnterior);
		this.add(botonVolverMenu);
		
	}
	public void IniciarFondo() {
		this.addReglas();
		this.addFondoPantalla();

	}
	public void addFondoPantalla() {

		fondo2.setBounds(0, 0, 1600, 900);
		fondo2.setIcon(imagenFondo2);
		this.add(fondo2);
		

	}
	public void addReglas() {
		reglas.setBounds(0,0,1600,900);
		this.add(reglas);
	}

	
	
	public void changeReglas(int numero) {
		
		if(numero == 0) {
			reglas.setIcon(juego);

		}
		else if(numero == 1) {
			reglas.setIcon(tipos);

		}
		else if(numero == 2) {
			reglas.setIcon(estadisticas);
		}
		else if(numero == 3) {
			reglas.setIcon(controles);

		}
	}
	
		public JButton getBotonSiguiente() {
			return this.botonSiguiente;
		}

		public JButton getBotonAnterior() {
			return this.botonAnterior;
		}

		public JButton getBotonVolverMenu() {
			return this.botonVolverMenu;
		}

	}
	
