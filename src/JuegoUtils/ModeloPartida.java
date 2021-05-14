package JuegoUtils;

import java.util.ArrayList;


import JuegoPaneles.*;
import JuegoPaises.*;
import JuegoUtils.*;

public class ModeloPartida {

	private PanelPartida panelPartida = new PanelPartida();
	private PanelGanador panelGanador = new PanelGanador();
	private ArrayList<Pais> equiposCreados = new ArrayList<Pais>();


	private Pais paisJugandoTurno;
	private Pais paisSeleccionado;
	private int posicionEquipoJugandoTurno = 0;
	private int turnosJugados = 1;





	public void pasarSiguienteEquipoJugandoTurno() {
		posicionEquipoJugandoTurno += 1;
		if(posicionEquipoJugandoTurno>= equiposCreados.size()) {
			posicionEquipoJugandoTurno = 0;
		}
		this.paisJugandoTurno = this.equiposCreados.get(posicionEquipoJugandoTurno);
		this.turnosJugados += 1;
		System.out.println(this.turnosJugados);
	}


	public Pais getPaisJugandoTurno() {
		return paisJugandoTurno;
	}
	public void setPaisJugandoTurno(Pais paisJugandoTurno) {
		this.paisJugandoTurno = paisJugandoTurno;
	}
	public Pais getPaisSeleccionado() {
		return paisSeleccionado;
	}
	public void setPaisSeleccionado(Pais paisSeleccionado) {
		this.paisSeleccionado = paisSeleccionado;
	}
	public PanelPartida getPanelPartida() {
		return panelPartida;
	}
	public void setPanelPartida(PanelPartida panelPartida) {
		this.panelPartida = panelPartida;
	}
	public ArrayList<Pais> getEquiposCreados() {
		return equiposCreados;
	}
	public void setEquiposCreados(ArrayList<Pais> equiposCreados) {
		this.equiposCreados = equiposCreados;
	}
	public int getPosicionEquipoJugandoTurno() {
		return posicionEquipoJugandoTurno;
	}
	public void setPosicionEquipoJugandoTurno(int posicionEquipoJugandoTurno) {
		this.posicionEquipoJugandoTurno = posicionEquipoJugandoTurno;
	}
	public int getTurnosJugados() {
		return turnosJugados;
	}
	public void setTurnosJugados(int turnosJugados) {
		this.turnosJugados = turnosJugados;
	}
	public PanelGanador getPanelGanador() {
		return panelGanador;
	}


	public void setPanelGanador(PanelGanador panelGanador) {
		this.panelGanador = panelGanador;
	}
}
