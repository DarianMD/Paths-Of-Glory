package utils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Paneles.PanelEquipoCreado;
import Paneles.VentanaJuego;

public class ControladorEventos implements ActionListener {

	//Modelo donde se guarda por refrencia el modelo de datos usado por la ventana
	ModeloDatos modelo;
	
	VentanaJuego ventana;
	
	public ControladorEventos(ModeloDatos modelo) {
		this.modelo = modelo;
		ventana =(VentanaJuego) SwingUtilities.getWindowAncestor(modelo.getPanelMenu());
		this.abrirBotonesAEventos();
	}
	
	
	//Abre los botones de todos los paneles a recibir eventos
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
		
		//Eventos de creadores
		modelo.getPanelCreadores().getBotonSiguiente().addActionListener(this);
		modelo.getPanelCreadores().getBotonAnterior().addActionListener(this);
		modelo.getPanelCreadores().getBotonVolverMenu().addActionListener(this);
		
		modelo.getPanelDisplayEquipos().setLayout(null);
		
		
		
		//Eventos del formulario de creacion de equipos
		modelo.getFormulario().getBotonCrear().addActionListener(this);
	}
	
	
	
	
	
	//Limpia toda la informacion de los paneles (reinicia el juego)
		public void limpiarEquipos() {
			modelo.getPanelDisplayEquipos().removeAll();
			modelo.getEquiposCreados().clear();
			modelo.setNumEquipos(0);
			
			//Añadimos los fondos de nuevo para que no se borren
			modelo.getPanelDisplayEquipos().addFondo();
		}


		@Override
		public void actionPerformed(ActionEvent e) {

			//Eventos menu inicial
			if(e.getSource() == modelo.getPanelMenu().getBotonJugar()) {
				modelo.getPanelMenu().setVisible(false);
				modelo.getPanelCreacionEquipos().setVisible(true);
				
				
			}
			
			if(e.getSource() == modelo.getPanelMenu().getBotonComoJugar()) {
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
					System.out.println("IN PROGRESS.....");
			}
			if(e.getSource() == modelo.getPanelCreacionEquipos().getBotonCrearEquipo() && modelo.getEquiposCreados().size()<4) {
				modelo.getFormulario().setVisible(true);
			}
			if(e.getSource() == modelo.getPanelCreacionEquipos().getBotonVolverMenu()) {
				modelo.getPanelCreacionEquipos().limpiarPanelCreacionEquipos();
				modelo.getPanelCreacionEquipos().setVisible(false);
				this.limpiarEquipos();
				modelo.getPanelMenu().setVisible(true);
			}
			
			
			
			
			
			//Eventos formulario creacion equipos
			if(e.getSource() == modelo.getFormulario().getBotonCrear()) {
				String[] infoEquipo = modelo.getFormulario().devolverArrayNuevoEquipo();
				
				if(infoEquipo[0].length() > 0 && modelo.getEquiposCreados().size() < 4) {
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
		}
}
