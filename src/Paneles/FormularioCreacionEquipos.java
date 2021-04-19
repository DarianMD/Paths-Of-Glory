package Paneles;

import java.awt.Color;

import javax.swing.*;


//Es la clase de la ventana donde se crean los equipos
public class FormularioCreacionEquipos extends JFrame{
	
	private String[] listaPaises = {"España","Alemania","URSS","USA","Portugal","Noruega","Francia","Italia","Rumania","Marruecos"};
	
	private JLabel etiquetaNombres = new JLabel("Añade el nombre de tu equipo");
	private JLabel etiquetaPaises = new JLabel("Elige el pais que quieres controlar");
	
	private JTextField campoNombreEquipo = new JTextField();
	private JComboBox cajaEquipos = new JComboBox(listaPaises);
	private JButton botonAdd = new JButton("Añadir");
	
	
	public FormularioCreacionEquipos() {
		setSize(400,600);
		setLayout(null);
		setResizable(false);
		setTitle("Crear equipo");
		inicializarComponentes();
		setVisible(true);	
	}
	
	
	//Inicializa todos los componentes del panel
	public void inicializarComponentes() {
		
		etiquetaNombres.setBounds(5, 0,300,50);
		add(etiquetaNombres);
		
		campoNombreEquipo.setBounds(0, 50, 350, 25);
		add(campoNombreEquipo);
		
		etiquetaPaises.setBounds(5, 75, 300, 50);
		add(etiquetaPaises);
		
		cajaEquipos.setBounds(5, 125, 200, 25);
		add(cajaEquipos);
		
		botonAdd.setBounds(5, 500, 100,50);
		add(botonAdd);
	}
	
	//Devuelve la informacion del equipo creado
	public String[] devolverArrayNuevoEquipo() {
		String[] nuevoEquipo = new String[2];
		
		nuevoEquipo[0] = campoNombreEquipo.getText();
		nuevoEquipo[1] =(String) cajaEquipos.getSelectedItem();
		
		return nuevoEquipo;
	}
	
	
	public JButton getBotonCrear() {
		return this.botonAdd;
	}
	
	
	public void limpiarFomulario() {
		campoNombreEquipo.setText("");
	}
}
