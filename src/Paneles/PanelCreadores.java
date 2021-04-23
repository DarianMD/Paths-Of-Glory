package Paneles;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCreadores extends JPanel {

	private JButton botonSiguiente = new JButton("Siguiente");
	private JButton botonAnterior = new JButton("Anterior");
	private JButton botonVolverMenu = new JButton("Volver al menu");
	private JLabel fondo = new JLabel();
	private ImageIcon imagenFondo = new ImageIcon("./assets/Fondos/fondo_creadores.png");

	private JLabel creador = new JLabel();
	private ImageIcon darian_info = new ImageIcon("./assets/Creadores/darian_manasturean.png");
	private ImageIcon sergio_info = new ImageIcon("./assets/Creadores/sergio_martin.png");
	private ImageIcon gabriel_info = new ImageIcon("./assets/Creadores/gabriel_voica.png");



	private JLabel prueba = new JLabel();
	private ImageIcon pruebas = new ImageIcon("./assets/Fondos/prueba.png");
	
	public int numeroCreadores;


	public PanelCreadores() {
		setSize(1600,900);
		setLayout(null);
		inicializarBotones();
		setVisible(true);
	}


	public void inicializarBotones() {
		botonSiguiente.setBounds(1100, 700, 280, 100);
		botonAnterior.setBounds(200, 700, 280, 100);
		botonVolverMenu.setBounds(25, 25, 380, 105);

		botonSiguiente.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/flecha_derecha.png")));
		botonAnterior.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/flecha_izquierda.png")));
		botonVolverMenu.setIcon(new ImageIcon(PanelCreadores.class.getResource("/Botones/volver_menu.png")));

		this.add(botonSiguiente);
		this.add(botonAnterior);
		this.add(botonVolverMenu);

	}

	public void IniciarFotos() {
		this.addCreadores();
		this.addFondoTexto();
		this.addFondoPantalla();

	}

	public void addFondoPantalla() {

		fondo.setBounds(0, 0, 1600, 900);
		fondo.setIcon(imagenFondo);
		this.add(fondo);

	}

	public void changeCreadores(int numero) {
		creador.setBounds(450,150,700,700);


		if(numero == 1) {
			creador.setIcon(darian_info);

		}
		else if(numero == 2) {
			creador.setIcon(sergio_info);

		}
		else if(numero == 3) {
			creador.setIcon(gabriel_info);

		}
	}


	public void addCreadores() {
		this.add(creador);
	}

	public void addFondoTexto() {
		prueba.setBounds(450,150,700,700);
		prueba.setIcon(pruebas);
		this.add(prueba);
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
