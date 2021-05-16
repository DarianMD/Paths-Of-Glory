package JuegoUtils;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import JuegoPaises.*;
import JuegoPaneles.*;
import JuegoUtils.*;
import Paneles.VentanaJuego;
import conexionBaseDeDatos.ConexionBaseDatos;

public class ControladorPartida implements ActionListener, ChangeListener {


	VentanaPartida ventana = new VentanaPartida();
	ModeloPartida modeloDatos = new ModeloPartida();


	private ArrayList<String[]> ataquesTurnos = new ArrayList<String[]>();
	private ArrayList<String[]> defensaTurnos = new ArrayList<String[]>();

	private String accionesTurnos = "";



	public void abrirComponentesAEventos() {
		JSlider slider = modeloDatos.getPanelPartida().getSliderCantidadAtaque();
		slider.addChangeListener(this);

		JButton botonPasarTurno = modeloDatos.getPanelPartida().getBotonPasarTurno();
		botonPasarTurno.addActionListener(this);

		JComboBox cajaEquipos = modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos();
		cajaEquipos.addActionListener(this);

		JButton botonAtacar = modeloDatos.getPanelPartida().getBotonAtacar();
		botonAtacar.addActionListener(this);

		JButton botonDefender = modeloDatos.getPanelPartida().getBotonDefender();
		botonDefender.addActionListener(this);
		
		modeloDatos.getPanelGanador().getBotonVolverMenu().addActionListener(this);
		
		modeloDatos.getPanelPartida().getBotonGuardar().addActionListener(this);
	}

	public void iniciarPartida(ArrayList<Pais> equipos) {

		modeloDatos.setEquiposCreados(equipos);

		this.abrirComponentesAEventos();
		this.modeloDatos.setPaisJugandoTurno(modeloDatos.getEquiposCreados().get(0));
		this.modeloDatos.setPaisSeleccionado(modeloDatos.getEquiposCreados().get(0));
		this.añadirPanelAVentana();	
		this.añadirNombresEquiposEnemigosComboBox();
		this.añadirEnPantallaVidasRestantesEquipos();
		this.añadirEnPantallaNombreEquipoJugando();
	}



	public void pasarTurno() {
		//Final de la ronda de turnos
		if(modeloDatos.getTurnosJugados() % modeloDatos.getEquiposCreados().size() == 0 && modeloDatos.getTurnosJugados() > 0) {
			realizarAccionesTurnosEquipos();
		}
		
		if(modeloDatos.getEquiposCreados().size() <=1) {
			this.modeloDatos.getPanelPartida().setVisible(false);
			this.modeloDatos.getPanelGanador().setVisible(true);
			this.ventana.remove(this.modeloDatos.getPanelPartida());
			this.modeloDatos.getPanelGanador().añadirNombreGanadorPanel(modeloDatos.getEquiposCreados().get(0));
			this.modeloDatos.getPanelGanador().getAreaTextoEventosPartida().setText(modeloDatos.getPanelPartida().getAreaMensajesPartida().getText());
		}

		//Este if esta solo para evitar un error que se da al quedar solamente el equipo ganador, no tiene otra funcionalidad a parte de esa
		if(this.modeloDatos.getPanelPartida().isVisible()) {
			
			int energiaRestanteEquipo = this.modeloDatos.getPaisJugandoTurno().getEnergia();
			this.modeloDatos.getPanelPartida().getEtiquetaEnergiaEquipo().setText(String.valueOf("Energia 50"));
			this.modeloDatos.getPanelPartida().getSliderCantidadAtaque().setValue(0);
			this.modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos().setVisible(false);
			this.modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos().removeAllItems();
			this.modeloDatos.pasarSiguienteEquipoJugandoTurno();
			this.añadirNombresEquiposEnemigosComboBox();
			añadirEnPantallaNombreEquipoJugando();
			añadirEnPantallaVidasRestantesEquipos();
			this.modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos().setVisible(true);
			this.modeloDatos.setPaisSeleccionado(this.comprobarEquipoSeleccionadoCaja());
		}
	}



	public Pais comprobarEquipoSeleccionadoCaja() {
		Pais equipoSeleccionado = null;

		for(int i=0;i<modeloDatos.getEquiposCreados().size();i++) {
			if(this.modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos().getSelectedItem().toString() == this.modeloDatos.getEquiposCreados().get(i).getNombre()) {
				equipoSeleccionado = this.modeloDatos.getEquiposCreados().get(i);
			}
		}
		return equipoSeleccionado;
	}


	//Al acabar la ronda de turnos se ejecuta la siguiente funcion
	public void realizarAccionesTurnosEquipos() {

		//Se aplican los escudos seleccionados por los equipos
		for(int i=0;i<modeloDatos.getEquiposCreados().size();i++) {
			Pais equipo = modeloDatos.getEquiposCreados().get(i);

			for(int j=0;j<defensaTurnos.size();j++) {
				if(defensaTurnos.get(j)[0] == equipo.getNombre()) {
						equipo.setEscudo(equipo.getEscudo()+Integer.parseInt(defensaTurnos.get(j)[1]));
						equipo.setEscudo(equipo.getEscudo()/2);
						accionesTurnos+= "Equipo "+equipo.getNombre()+" se ha defendido con "+ defensaTurnos.get(j)[1]+" de energia"+"\r\n";
				}
			}
		}

		//Se aplican los ataques seleccionados por los equipos
		for(int i=0;i<modeloDatos.getEquiposCreados().size();i++) {
			Pais equipo = modeloDatos.getEquiposCreados().get(i);

			for(int j=0;j<ataquesTurnos.size();j++) {
				if(ataquesTurnos.get(j)[0] == equipo.getNombre()) {
					equipo.setEscudo(equipo.getEscudo() - Double.parseDouble(ataquesTurnos.get(j)[1]));
					if(equipo.getEscudo() < 0) {
						equipo.setVida((int)Math.round(equipo.getVida() - Math.abs(equipo.getEscudo())));
					}
					equipo.setEscudo(0);
					accionesTurnos += "Equipo "+equipo.getNombre()+" es atacado con "+Math.round(Double.parseDouble(ataquesTurnos.get(j)[1]))+" de energia por el equipo "+ataquesTurnos.get(j)[2]+"\r\n";
					if(equipo.getVida() <=0 && this.modeloDatos.getEquiposCreados().contains(equipo)) {
						this.modeloDatos.getEquiposCreados().remove(equipo);
						accionesTurnos += "Equipo "+equipo.getNombre()+" ha sido eliminado por el equipo "+ataquesTurnos.get(j)[2]+"\r\n";
					}
				}
			}
		}

		for(int i=0;i<modeloDatos.getEquiposCreados().size();i++) {
			modeloDatos.getEquiposCreados().get(i).setEnergia(50);
		}

		if(accionesTurnos.length() > 1) {
			modeloDatos.getPanelPartida().getAreaMensajesPartida().setText(modeloDatos.getPanelPartida().getAreaMensajesPartida().getText()+"\r\n"+accionesTurnos);
		}
		accionesTurnos = "";
		ataquesTurnos = new ArrayList<String[]>();
		defensaTurnos = new ArrayList<String[]>();
	}



	public void atacar() {

		Pais equipoAtacante = modeloDatos.getPaisJugandoTurno();
		Pais equipoAtacado = modeloDatos.getPaisSeleccionado();

		int cantidadAtaque = modeloDatos.getPanelPartida().getSliderCantidadAtaque().getValue();

		if(equipoAtacante.getEnergia() - cantidadAtaque >= 0 && equipoAtacante != equipoAtacado && cantidadAtaque > 0 && modeloDatos.getPaisSeleccionado() != null) {
			String[] turnoAtaque = {equipoAtacado.getNombre(), String.valueOf((int)cantidadAtaque*equipoAtacante.getDanyoAtaque()), equipoAtacante.getNombre()};
			ataquesTurnos.add(turnoAtaque);
			equipoAtacante.setEnergia(equipoAtacante.getEnergia() - cantidadAtaque);
			int energiaRestanteEquipo = this.modeloDatos.getPaisJugandoTurno().getEnergia();
			this.modeloDatos.getPanelPartida().getEtiquetaEnergiaEquipo().setText(String.valueOf("Energia "+energiaRestanteEquipo));
			equipoAtacante.setPuntuacion(equipoAtacante.getPuntuacion() +(int)  Math.round(cantidadAtaque * 1.75));
		}
	}


	public void defender() {
		Pais equipoDefendido = modeloDatos.getPaisJugandoTurno();
		int cantidadDefensa = modeloDatos.getPanelPartida().getSliderCantidadAtaque().getValue();

		if(equipoDefendido.getEnergia() >= cantidadDefensa && cantidadDefensa > 0 ) {
			String[] turnoDefensa = {equipoDefendido.getNombre(), String.valueOf(cantidadDefensa)};
			defensaTurnos.add(turnoDefensa);
			equipoDefendido.setEnergia(equipoDefendido.getEnergia() - cantidadDefensa);
			int energiaRestanteEquipo = this.modeloDatos.getPaisJugandoTurno().getEnergia();
			this.modeloDatos.getPanelPartida().getEtiquetaEnergiaEquipo().setText(String.valueOf("Energia "+energiaRestanteEquipo));
		}
	}


	//Añade el panel que contiene los componentes a la ventana de juego
	public void añadirPanelAVentana() {
		ventana.add(modeloDatos.getPanelPartida());
		ventana.add(modeloDatos.getPanelGanador());
		modeloDatos.getPanelGanador().setVisible(false);
	}


	
	public void añadirNombresEquiposEnemigosComboBox() {
		Pais equipoJugandoTurno = modeloDatos.getPaisJugandoTurno();
		ArrayList<String> nombresEnemigos = new ArrayList<String>();
		String[] a = {"a","b"};
		for(int i=0;i<modeloDatos.getEquiposCreados().size();i++) {
			if(equipoJugandoTurno.getNombre() != modeloDatos.getEquiposCreados().get(i).getNombre()) {
				nombresEnemigos.add(modeloDatos.getEquiposCreados().get(i).getNombre());
			}
		}
		for(int i=0;i<nombresEnemigos.size();i++) {
			modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos().addItem(nombresEnemigos.get(i));
		}
	}


	
	public void añadirEnPantallaVidasRestantesEquipos() {
		String vidasEquipos = "<html> ";

		for(int i=0;i<this.modeloDatos.getEquiposCreados().size();i++) {
			Pais equipo = modeloDatos.getEquiposCreados().get(i);
			vidasEquipos += "<p>"+equipo.getNombre()+": "+equipo.getVida()+" vida"+"</br>";
		}
		this.modeloDatos.getPanelPartida().getEtiquetaVidasRestantesEquipos().setText(vidasEquipos);
	}


	
	public void añadirEnPantallaNombreEquipoJugando() {
		String nombre = modeloDatos.getPaisJugandoTurno().getNombre();
		modeloDatos.getPanelPartida().getEtiquetaNombreEquipoJugandoTurno().setText("Turno de :  "+nombre);
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos() && this.modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos().isVisible()) {

			for(int i=0;i<modeloDatos.getEquiposCreados().size();i++) {
				if(modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos().getSelectedItem().toString() == modeloDatos.getEquiposCreados().get(i).getNombre() && modeloDatos.getPanelPartida().getCajaNombresEquiposEnemigos().getSelectedItem() != null) {
					this.modeloDatos.setPaisSeleccionado(modeloDatos.getEquiposCreados().get(i));
				}
			}
			this.modeloDatos.getPanelPartida().getBotonAtacar().setEnabled(true);
		}

		if(e.getSource() == modeloDatos.getPanelPartida().getBotonPasarTurno()) {
			this.pasarTurno();
		}

		if(e.getSource() == modeloDatos.getPanelPartida().getBotonAtacar()) {
			this.atacar();
		}

		if(e.getSource() == modeloDatos.getPanelPartida().getBotonDefender()) {
			this.defender();
		}
		
		if(e.getSource() == modeloDatos.getPanelGanador().getBotonVolverMenu()) {
			JFrame ventana =(JFrame) SwingUtilities.getWindowAncestor(modeloDatos.getPanelGanador());
			ventana.dispose();
			
			VentanaJuego ventanaJuego = new VentanaJuego();
		}
		
		if(e.getSource() == modeloDatos.getPanelPartida().getBotonGuardar()) {
			
			ConexionBaseDatos conexion = new ConexionBaseDatos();
			conexion.setPaisesBaseDatos(this.modeloDatos.getEquiposCreados());
			JFrame ventana =(JFrame) SwingUtilities.getWindowAncestor(modeloDatos.getPanelGanador());
			ventana.dispose();
			
			VentanaJuego ventanaJuego = new VentanaJuego();
		
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider slider =(JSlider) e.getSource();
		String num = String.valueOf(slider.getValue());
		modeloDatos.getPanelPartida().getEtiquetaCantidadAtaque().setText(num);
	}

}
