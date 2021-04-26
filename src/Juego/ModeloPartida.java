package Juego;
import java.util.ArrayList;
import Juego.Paises.*;

public class ModeloPartida {
	
	//Array donde guardamos los equipos creados
	private ArrayList<Pais> equiposCreados = new ArrayList<Pais>();
	
	
	//Coge el estado de los equipos creados y devuelve una lista de paises dependiendo del tipo
	public void inicializarEquipos(ArrayList<String[]> estadoEquipos) {
		for(int i=0;i<estadoEquipos.size();i++) {
			equiposCreados.add(verificarTipoEquipo(estadoEquipos.get(i)));
		}
	}

	/*Info equipo contiene el nombre y el tipo de cada equipo creado
	 * infoEquipo[0] --> Nombre Equipo
	 * infoEquipo[1] --> Tipo de equipo
	*/
	public Pais verificarTipoEquipo(String[] infoEquipo) {
		switch(infoEquipo[1]) {
		case "España":
			return new PaisEspania(infoEquipo[0]);
		case "Alemania":
			return new PaisAlemania(infoEquipo[0]);
		case "Francia":
			return new PaisFrancia(infoEquipo[0]);
		case "Marruecos":
			return new PaisMarruecos(infoEquipo[0]);
		case "Noruega":
			return new PaisNoruega(infoEquipo[0]);
		case "Portugal":
			return new PaisPortugal(infoEquipo[0]);
		case "URSS":
			return new PaisURSS(infoEquipo[0]);
		case "USA":
			return new PaisUSA(infoEquipo[0]);
		case "Rumania":
			return new PaisRumania(infoEquipo[0]);
		case "Italia":
			return new PaisItalia(infoEquipo[0]);
		default:
			return null;
		}
	}
	
	
	public ArrayList getEquiposCreados() {
		return this.equiposCreados;
	}
}
