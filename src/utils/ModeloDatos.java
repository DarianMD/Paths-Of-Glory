package utils;
import java.util.ArrayList;



import Paneles.FormularioCreacionEquipos;
import Paneles.PanelCreacionEquipos;
import Paneles.PanelCreadores;
import Paneles.PanelDisplayEquipos;
import Paneles.PanelEquipoCreado;
import Paneles.PanelMenu;


public class ModeloDatos {
	
	    //Panel del menu principal
		private PanelMenu panelMenu = new PanelMenu();
		//Panel donde se crean y enseñan los equipos
		private PanelCreacionEquipos panelCreacionEquipos = new PanelCreacionEquipos();
		//Panel donde se muestran los equipos creados
		private PanelDisplayEquipos panelDisplayEquipos = new PanelDisplayEquipos();
		
		//Panel donde se muestra la informacion de los creadores
		private PanelCreadores panelCreadores = new PanelCreadores();
		
		//Ventana para crear equipos
		private FormularioCreacionEquipos formulario = new FormularioCreacionEquipos();

		//Array list donde se van guardando los paneles de cada equipo creado equipos creados
		private ArrayList<PanelEquipoCreado> equiposCreados = new ArrayList<PanelEquipoCreado>();
		
		//Array list donde se guarda el nombre y datos de cada equipo creado
		private ArrayList<String[]> estadoEquipos = new ArrayList<String[]>();
		private ArrayList<String> nombresEquipos = new ArrayList<String>();
		
		private int numEquipos = 0;
		private int numeroCreador  = 1;
		
		
		
		public PanelMenu getPanelMenu() {
			return panelMenu;
		}

		public PanelCreacionEquipos getPanelCreacionEquipos() {
			return panelCreacionEquipos;
		}

		public PanelDisplayEquipos getPanelDisplayEquipos() {
			return panelDisplayEquipos;
		}

		public PanelCreadores getPanelCreadores() {
			return panelCreadores;
		}

		public FormularioCreacionEquipos getFormulario() {
			return formulario;
		}

		public ArrayList<PanelEquipoCreado> getEquiposCreados() {
			return equiposCreados;
		}

		public ArrayList<String[]> getEstadoEquipos() {
			return estadoEquipos;
		}
		
		public int getNumEquipos() {
			return this.numEquipos;
		}
		
		public void setNumEquipos(int num) {
			this.numEquipos = num;
		}

		public int getNumeroCreador() {
			return numeroCreador;
		}

		public void setNumeroCreador(int numeroCreador) {
			this.numeroCreador = numeroCreador;
		}
		
		
		public ArrayList<String> getNombresEquipos() {
			return nombresEquipos;
		}

		public void setNombresEquipos(ArrayList<String> nombresEquipos) {
			this.nombresEquipos = nombresEquipos;
		}

		public void setPanelMenu(PanelMenu panelMenu) {
			this.panelMenu = panelMenu;
		}

		public void setPanelCreacionEquipos(PanelCreacionEquipos panelCreacionEquipos) {
			this.panelCreacionEquipos = panelCreacionEquipos;
		}

		public void setPanelDisplayEquipos(PanelDisplayEquipos panelDisplayEquipos) {
			this.panelDisplayEquipos = panelDisplayEquipos;
		}

		public void setPanelCreadores(PanelCreadores panelCreadores) {
			this.panelCreadores = panelCreadores;
		}

		public void setFormulario(FormularioCreacionEquipos formulario) {
			this.formulario = formulario;
		}

		public void setEquiposCreados(ArrayList<PanelEquipoCreado> equiposCreados) {
			this.equiposCreados = equiposCreados;
		}

		public void setEstadoEquipos(ArrayList<String[]> estadoEquipos) {
			this.estadoEquipos = estadoEquipos;
		}
		
}
