package Paneles;

import utils.*;
import javax.swing.*;

//Ventana principal del juego
public class VentanaJuego extends JFrame {
	
	//Modelo donde se guardan las vistas
	ModeloDatos paneles = new ModeloDatos();
	
	//Controlador que controla los eventos de cada panel
	ControladorEventos controlador = new ControladorEventos(paneles);
	
	public VentanaJuego() {
		//Configuracion inicial de la ventana
		setSize(1600,900);
		setTitle("Path of glory");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		añadirPanelesIniciales();
		setVisible(true);
	}
	
	//Inicializa los paneles dentro de la ventana
	public void añadirPanelesIniciales() {
		this.add(paneles.getPanelMenu());
		paneles.getPanelMenu().setVisible(true);
		this.add(paneles.getPanelComoJugar());
		paneles.getPanelComoJugar().setVisible(false);
		this.add(paneles.getPanelCreadores());
		paneles.getPanelCreadores().setVisible(false);
		
		
		this.add(paneles.getPanelCreacionEquipos());
		paneles.getPanelCreacionEquipos().setVisible(false);
		paneles.getPanelCreadores().IniciarFotos();
		paneles.getPanelComoJugar().IniciarFondo();
		
		paneles.getPanelDisplayEquipos().setBounds(400, 0, 1200, 710);
		paneles.getPanelCreacionEquipos().add(paneles.getPanelDisplayEquipos());
		paneles.getPanelCreacionEquipos().addFondoPantalla();
		paneles.getPanelDisplayEquipos().addFondo();
		
		paneles.getFormulario().setLocationRelativeTo(paneles.getPanelCreacionEquipos());
		paneles.getFormulario().setVisible(false);
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