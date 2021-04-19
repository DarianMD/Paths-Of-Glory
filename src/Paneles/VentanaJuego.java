package Paneles;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


//Ventana principal del juego
public class VentanaJuego extends JFrame implements ActionListener {
	
	//Panel del menu principal
	private PanelMenu panelMenu = new PanelMenu();
	//Panel donde se crean y enseñan los equipos
	private PanelCreacionEquipos panelCreacionEquipos = new PanelCreacionEquipos();
	//Panel donde se muestran los equipos creados
	private PanelDisplayEquipos panelDisplayEquipos = new PanelDisplayEquipos();
	//Panel donde se muestran los creadores
	private PanelCreadores panelCreadores = new PanelCreadores();
	//Ventana para crear equipos
	private FormularioCreacionEquipos formulario = new FormularioCreacionEquipos();

	//Array list donde se van guardando los paneles de cada equipo creado equipos creados
	private ArrayList<PanelEquipoCreado> equiposCreados = new ArrayList<PanelEquipoCreado>();
	
	//Array list donde se guarda el nombre y datos de cada equipo creado
	private ArrayList<String[]> estadoEquipos = new ArrayList<String[]>();
	
	
	public VentanaJuego() {
		//Configuracion inicial de la ventana
		setSize(1600,900);
		setTitle("Path of glory");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Funciones de la clase para el funcionamiento del juego
		añadirPanelesIniciales();
		abrirBotonesAEventos();
	}

	//Añade el panel del menu inicial y hace invisibles los demas paneles
	public void añadirPanelesIniciales() {
		add(panelMenu);

		add(panelCreacionEquipos);
		panelCreacionEquipos.setVisible(false);
		
		
		add(panelCreadores);
		panelCreadores.setVisible(false);
	
		
		panelDisplayEquipos.setBounds(400, 0, 1200, 710);
		panelCreacionEquipos.add(panelDisplayEquipos);
		panelCreacionEquipos.addFondoPantalla();
		panelDisplayEquipos.addFondo();
		
		formulario.setVisible(false);
	}

	//Abre los botones de todos los paneles a recibir eventos
	public void abrirBotonesAEventos() {
		//Eventos del menu principal
		panelMenu.getBotonJugar().addActionListener(this);
		panelMenu.getBotonComoJugar().addActionListener(this);
		panelMenu.getBotonCreadores().addActionListener(this);
		panelMenu.getBotonSalir().addActionListener(this);
		
		//Eventos del menu de creacion de equipos
		panelCreacionEquipos.getBotonJugarPartida().addActionListener(this);
		panelCreacionEquipos.getBotonCrearEquipo().addActionListener(this);
		panelCreacionEquipos.getBotonVolverMenu().addActionListener(this);
		
		panelDisplayEquipos.setLayout(null);
		
		//Eventos del formulario de creacion de equipos
		formulario.getBotonCrear().addActionListener(this);
	}
	
	
	//Limpia toda la informacion de los paneles (reinicia el juego)
	public void limpiarEquipos() {
		panelDisplayEquipos.removeAll();
		equiposCreados.clear();
		
		//Añadimos los fondos de nuevo para que no se borren
		panelDisplayEquipos.addFondo();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		//Eventos menu inicial
		if(e.getSource() == panelMenu.getBotonJugar()) {
			panelMenu.setVisible(false);
			panelCreacionEquipos.setVisible(true);
		}
		
		if(e.getSource() == panelMenu.getBotonComoJugar()) {
			

		}
		
		if(e.getSource() == panelMenu.getBotonCreadores()) {
			panelMenu.setVisible(false);
			panelCreadores.setVisible(true);
			
		}
		
		if(e.getSource() == panelMenu.getBotonSalir()) {
			System.exit(0);
		}


		//Eventos menu creacion equipos
		if(e.getSource() == panelCreacionEquipos.getBotonJugarPartida()) {
				System.out.println("IN PROGRESS.....");
		}
		if(e.getSource() == panelCreacionEquipos.getBotonCrearEquipo() && equiposCreados.size()<4) {
			formulario.setVisible(true);
		}
		if(e.getSource() == panelCreacionEquipos.getBotonVolverMenu()) {
			panelCreacionEquipos.limpiarPanelCreacionEquipos();
			panelCreacionEquipos.setVisible(false);
			this.limpiarEquipos();
			panelMenu.setVisible(true);
		}
		
		
		//Eventos formulario creacion equipos
		if(e.getSource() == formulario.getBotonCrear()) {
			String[] infoEquipo = formulario.devolverArrayNuevoEquipo();
			
			if(infoEquipo[0].length() > 0 && equiposCreados.size() < 4) {
				formulario.limpiarFomulario();
				equiposCreados.add(new PanelEquipoCreado());
				equiposCreados.get(equiposCreados.size()-1).setBounds(0,(180*(equiposCreados.size()-1)+5) , 1200, 160);
				panelDisplayEquipos.add(equiposCreados.get(equiposCreados.size()-1));
				equiposCreados.get(equiposCreados.size()-1).inicializarComponentesPanel(infoEquipo[0], infoEquipo[1]);
				panelDisplayEquipos.addFondo();
				this.repaint();
				
				estadoEquipos.add(infoEquipo);
				formulario.setVisible(false);
			}
		}
	}

	public static void main(String[] args) {
		try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
		VentanaJuego ventana = new VentanaJuego();
	}
}