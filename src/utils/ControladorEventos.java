package utils;
import java.awt.Color;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import JuegoPaises.*;
import JuegoPaneles.VentanaPartida;
import JuegoUtils.ControladorPartida;
import JuegoUtils.ModeloPartida;
import Paneles.PanelEquipoCreado;
import Paneles.VentanaJuego;
import conexionBaseDeDatos.ConexionBaseDatos;

/**
 * 
 * Esta clase controla los eventos de todos los menus ajenos a la partida.
 * Utiliza un modelo de datos donde se guardan diferentes vistas y informacion
 *
 *@version 1.2
 *
 */
public class ControladorEventos implements ActionListener{

	/**
	 * Modelo de datos y ventana donde se iran mostrando las vistas
	 * 
	 */
	private ModeloDatos modelo;
	private VentanaJuego ventana;

	public ControladorEventos(ModeloDatos modelo) {
		this.modelo = modelo;
		ventana =(VentanaJuego) SwingUtilities.getWindowAncestor(modelo.getPanelMenu());
		this.abrirBotonesAEventos();
	}


	/**
	 * La funcion abre los botones y componentes utilizados a la escucha de eventos
	 * 
	 */
	public void abrirBotonesAEventos() {
		//Eventos del menu principal
		modelo.getPanelMenu().getBotonJugar().addActionListener(this);
		modelo.getPanelMenu().getBotonComoJugar().addActionListener(this);
		modelo.getPanelMenu().getBotonCreadores().addActionListener(this);
		modelo.getPanelMenu().getBotonSalir().addActionListener(this);
		modelo.getPanelMenu().getBotonAnterior().addActionListener(this);
		modelo.getPanelMenu().getBotonSiguiente().addActionListener(this);

		//Eventos del menu de creacion de equipos
		modelo.getPanelCreacionEquipos().getBotonJugarPartida().addActionListener(this);
		modelo.getPanelCreacionEquipos().getBotonCrearEquipo().addActionListener(this);
		modelo.getPanelCreacionEquipos().getBotonVolverMenu().addActionListener(this);

		//Eventos de comojugar
		modelo.getPanelComoJugar().getBotonVolverMenu().addActionListener(this);
		modelo.getPanelComoJugar().getBotonAnterior().addActionListener(this);
		modelo.getPanelComoJugar().getBotonSiguiente().addActionListener(this);

		//Eventos de creadores
		modelo.getPanelCreadores().getBotonSiguiente().addActionListener(this);
		modelo.getPanelCreadores().getBotonAnterior().addActionListener(this);
		modelo.getPanelCreadores().getBotonVolverMenu().addActionListener(this);

		modelo.getPanelDisplayEquipos().setLayout(null);

		//Eventos del formulario de creacion de equipos
		modelo.getFormulario().getBotonCrear().addActionListener(this);

		modelo.getPanelMenu().getBotonContinuarPartida().addActionListener(this);
	}


	/**
	 * Reset de informacion en todos los paneles.
	 * 
	 */
	public void limpiarEquipos() {
		modelo.getPanelDisplayEquipos().removeAll();
		modelo.getEquiposCreados().clear();
		modelo.setNumEquipos(0);
		modelo.getPanelDisplayEquipos().addFondo(); //Añadimos los fondos de nuevo para que no se borren
	}


	/**
	 * Esta funcion añade al modelo los equipos creados por el cliente
	 * 
	 * @return equipos creados con sus respectivos tipos
	 */
	public ArrayList<Pais> iniciarPartidaConEquiposCreados() {
		ArrayList<Pais> equipos = new ArrayList<Pais>();

		for(int i=0;i<modelo.getEstadoEquipos().size();i++) {
			switch(modelo.getEstadoEquipos().get(i)[1]) {
			case "España":
				equipos.add(new PaisEspania(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "Alemania":
				equipos.add(new PaisAlemania(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "Francia":
				equipos.add(new PaisFrancia(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "Italia":
				equipos.add(new PaisItalia(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "Marruecos":
				equipos.add(new PaisMarruecos(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "URSS":
				equipos.add(new PaisURSS(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "USA":
				equipos.add(new PaisEspania(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "Rumania":
				equipos.add(new PaisEspania(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "Portugal":
				equipos.add(new PaisEspania(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "Noruega":
				equipos.add(new PaisNoruega(modelo.getEstadoEquipos().get(i)[0]));
				break;
			case "Inglaterra":
				equipos.add(new PaisEspania(modelo.getEstadoEquipos().get(i)[0]));
				break;
			}
		}
		return equipos;
	}



	/**
	 * Todos las funciones de los eventos del menu
	 * 
	 * @version 1.2
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		//Eventos menu inicial
		if(e.getSource() == modelo.getPanelMenu().getBotonJugar()) {
			modelo.getPanelMenu().setVisible(false);
			modelo.getPanelCreacionEquipos().setVisible(true);

		}

		if(e.getSource() == modelo.getPanelMenu().getBotonComoJugar()) {
			modelo.getPanelMenu().setVisible(false);
			modelo.getPanelComoJugar().setVisible(true);
		}

		if(e.getSource() == modelo.getPanelMenu().getBotonContinuarPartida()) {
			ConexionBaseDatos con = ConexionBaseDatos.getInstance();
			ArrayList<Pais> equipos = con.getEquiposGuardados();

			if(equipos.size() > 1) {
				ControladorPartida partida = new ControladorPartida();
				partida.iniciarPartida(equipos);

				JFrame ventana =(JFrame) SwingUtilities.getWindowAncestor(this.modelo.getPanelMenu());
				ventana.dispose();
			}
		}
	
		if(e.getSource() == modelo.getPanelMenu().getBotonCreadores()) {
			modelo.getPanelMenu().setVisible(false);
			modelo.getPanelCreadores().setVisible(true);
		}
		
		if(e.getSource() == modelo.getPanelMenu().getBotonAnterior()) {
			modelo.getPanelMenu().Anterior();
		}
		
		if(e.getSource() == modelo.getPanelMenu().getBotonSiguiente()) {
			modelo.getPanelMenu().Siguiente();
		}

		if(e.getSource() == modelo.getPanelMenu().getBotonSalir()) {
			System.exit(0);
		}


		//Eventos menu creacion equipos
		if(e.getSource() == modelo.getPanelCreacionEquipos().getBotonJugarPartida()) {
			
			if(this.modelo.getEquiposCreados().size() >= 2) {
				JFrame ventana =(JFrame) SwingUtilities.getWindowAncestor(this.modelo.getPanelMenu());
				ventana.setVisible(false);
				ArrayList<Pais> equipos = this.iniciarPartidaConEquiposCreados();

				ControladorPartida partida = new ControladorPartida();
				partida.iniciarPartida(equipos);
			}
		}
		
		if(e.getSource() == modelo.getPanelCreacionEquipos().getBotonCrearEquipo() && modelo.getEquiposCreados().size()<4) {
			modelo.getFormulario().setVisible(true);
		}
		
		if(e.getSource() == modelo.getPanelCreacionEquipos().getBotonVolverMenu()) {
			modelo.getPanelCreacionEquipos().limpiarPanelCreacionEquipos();
			modelo.getPanelCreacionEquipos().setVisible(false);
			this.limpiarEquipos();
			this.modelo.getEstadoEquipos().clear();
			modelo.getPanelMenu().setVisible(true);
		}


		//Eventos formulario creacion equipos
		if(e.getSource() == modelo.getFormulario().getBotonCrear()) {
			
			String[] infoEquipo = modelo.getFormulario().devolverArrayNuevoEquipo(); 

			if(infoEquipo[0].length() > 0 && modelo.getEquiposCreados().size() < 4 && !(this.modelo.getNombresEquipos().contains(infoEquipo[0]))) {
				this.modelo.getNombresEquipos().add(infoEquipo[0]);
				modelo.getFormulario().limpiarFomulario();
				modelo.getEquiposCreados().add(new PanelEquipoCreado());

				PanelEquipoCreado equipo = modelo.getEquiposCreados().get(modelo.getEquiposCreados().size()-1);

				modelo.getPanelDisplayEquipos().add(equipo);
				equipo.setBounds(7, (180*modelo.getNumEquipos()+5), 1170, 160);
				modelo.setNumEquipos(modelo.getNumEquipos()+1);
				modelo.getEquiposCreados().get(modelo.getEquiposCreados().size()-1).inicializarComponentesPanel(infoEquipo[0], infoEquipo[1]);
				equipo.getBotonEliminar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton botonSalir =(JButton) e.getSource();
						JPanel panelEquipo = (JPanel) botonSalir.getParent();
						modelo.getPanelDisplayEquipos().remove(panelEquipo);
						modelo.getPanelDisplayEquipos().repaint();
						modelo.getEquiposCreados().remove(panelEquipo);
						modelo.getEstadoEquipos().remove(panelEquipo.getY()/180);
						modelo.setNumEquipos(modelo.getNumEquipos()-1);
						for(int i=0;i<modelo.getEquiposCreados().size();i++) {
							modelo.getEquiposCreados().get(i).setBounds(7, (180*i)+5, 1170, 160);
							modelo.getPanelCreacionEquipos().repaint();
						}
					}
				});

				modelo.getPanelDisplayEquipos().addFondo();
				modelo.getPanelCreacionEquipos().repaint();
				modelo.getEstadoEquipos().add(infoEquipo);
				modelo.getFormulario().setVisible(false);
			}
		}

		//Evento creadores
		modelo.getPanelCreadores().changeCreadores(modelo.getNumeroCreador());

		if(e.getSource() == modelo.getPanelCreadores().getBotonSiguiente() && modelo.getNumeroCreador() < 3) {
			modelo.setNumeroCreador(modelo.getNumeroCreador()+1);
			modelo.getPanelCreadores().changeCreadores(modelo.getNumeroCreador());
		}
		else if(e.getSource() == modelo.getPanelCreadores().getBotonAnterior() && modelo.getNumeroCreador() > 1) {
			modelo.setNumeroCreador(modelo.getNumeroCreador()-1);
			modelo.getPanelCreadores().changeCreadores(modelo.getNumeroCreador());
		}
		else if(e.getSource() == modelo.getPanelCreadores().getBotonVolverMenu()) {
			modelo.getPanelCreadores().setVisible(false);
			modelo.getPanelMenu().setVisible(true);
		}

		//Evento comojugar
		modelo.getPanelComoJugar().changeReglas(modelo.getNumeroRegla());


		if(e.getSource() == modelo.getPanelComoJugar().getBotonSiguiente() && modelo.getNumeroRegla() < 3) {
			System.out.println("yeye " + modelo.getNumeroRegla());
			modelo.setNumeroRegla(modelo.getNumeroRegla()+1);
			modelo.getPanelComoJugar().changeReglas(modelo.getNumeroRegla());
		}
		else if(e.getSource() == modelo.getPanelComoJugar().getBotonAnterior() && modelo.getNumeroRegla() > 0) {
			System.out.println("sfasdfasdfa "+ modelo.getNumeroRegla());
			modelo.setNumeroRegla(modelo.getNumeroRegla()-1);
			modelo.getPanelComoJugar().changeReglas(modelo.getNumeroRegla());
		}
		if(e.getSource() == modelo.getPanelComoJugar().getBotonVolverMenu()) {
			System.out.println("chao");
			modelo.getPanelComoJugar().setVisible(false);
			modelo.getPanelMenu().setVisible(true);
		}
	}
}