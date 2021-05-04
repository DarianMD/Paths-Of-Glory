package Paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


//Es la clase de la ventana donde se crean los equipos
public class FormularioCreacionEquipos extends JFrame implements ActionListener, KeyListener{

	private String[] listaPaises = {"España","Alemania","URSS","USA","Portugal","Noruega","Francia","Italia","Rumania","Marruecos"};

	private String[] descripcionesPaises = {
<<<<<<< HEAD
		"España tiene un poderoso ejercito y un enorme potencial militar.\n "
		+ "Su lider Franco es temido en todo el globo.",

		"Francia o tambien llamada la potencia Baguette. Poderosos y temibles,"
		+ "comandados por su poderoso lider Franchuten.",

		"Alemania, el tercer reich se alza comandado por Hitler. Cuenta con un gran ejercito"
		+"muy disciplinado.",

		"Estados Unidos de America. Abraham Lincoln lo govierna con lealtad, disciplina y determinacion."+
		"Un pais muy temible",
		"La URSS. Potencia comunista del globo, su poder reside en el número de soldados. Son fuertes y rusos la mayoria,"
		+"con eso se dice todo",
		"Italia, el país de la pasta, y no precisamente la de comer (que también). Su lider Mussolini"
		+ "es un hombre severo y temible, ademas de calvo.",
		"Marruecos, liderado por Sadam Husein, lider politico brillante, tiene un ejercito de tierra, mar y aire sumamente"
		+ "poderoso. Ademas de comer unos kebabs que estan de lujo.",
		"Rumania y su lider Vlad son temidos por el mundo entero. Vlad el empalador, tambien llamado el conde Dracúla impone"
		+ "el terror solo con su presencia.",
		"Noruega el mayor exportador de salmón del mundo, es también el mayor importador de armas del mundo."+
		"Con una economia sumamente rica y un poder militar imbatible son considerados una gran amenaza por el mundo entero.",
		"Portugal, tambien conocidos como los diablos de Portua, temibles soldados armados hasta los dientes y liderados por Salazar.",
=======
			"España tiene un poderoso ejercito y un enorme potencial militar.\n "
					+ "Su lider Franco es temido en todo el globo.",

					"Francia o tambien llamada la potencia Baguette. Poderosos y temibles,"
							+ "comandados por su poderoso lider Franchuten.",

							"Alemania, el tercer reich se alza comandado por Hitler. Cuenta con un gran ejercito"
									+"muy disciplinado.",

									"Estados Unidos de America. Abraham Lincoln lo govierna con lealtad, disciplina y determinacion."+
											"Un pais muy temible",
											"La URSS. Potencia comunista del globo, su poder reside en el número de soldados. Son fuertes y rusos la mayoria,"
													+"con eso se dice todo",
													"Italia, el país de la pasta, y no precisamente la de comer (que también). Su lider Mussolini"
															+ "es un hombre severo y temible, ademas de calvo.",
															"Marruecos, liderado por Sadam Husein, lider politico brillante, tiene un ejercito de tierra, mar y aire sumamente"
																	+ "poderoso. Ademas de comer unos kebabs que estan de lujo.",
																	"Rumania y su lider Vlad son temidos por el mundo entero. Vlad el empalador, tambien llamado el conde Dracúla impone"
																			+ "el terror solo con su presencia.",
																			"Noruega el mayor exportador de salmón del mundo, es también el mayor importador de armas del mundo."+
																					"Con una economia sumamente rica y un poder militar imbatible son considerados una gran amenaza por el mundo entero.",
																					"Portugal, tambien conocidos como los diablos de Portua, temibles soldados armados hasta los dientes y liderados por Salazar.",

>>>>>>> origin/main
	};


	private JLabel etiquetaNombres = new JLabel("Añade el nombre de tu equipo");
	private JLabel etiquetaPaises = new JLabel("Elige el pais que quieres controlar");
	private JLabel descripcionPais = new JLabel("Hola");

	private JTextField campoNombreEquipo = new JTextField();
	private JComboBox cajaEquipos = new JComboBox(listaPaises);
	private JButton botonAdd = new JButton("Añadir");

	public FormularioCreacionEquipos() {
		setSize(400,400);
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
		campoNombreEquipo.addKeyListener(this);
		add(campoNombreEquipo);

		etiquetaPaises.setBounds(5, 75, 300, 50);
		add(etiquetaPaises);

		descripcionPais.setBounds(5, 120, 250, 150);
		descripcionPais.setText("<html>"+this.descripcionesPaises[0]+"</html>");
		add(descripcionPais);

		cajaEquipos.setBounds(5, 125, 200, 25);
		cajaEquipos.addActionListener(this);
		add(cajaEquipos);

		botonAdd.setBounds(5, 300, 100,50);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.cajaEquipos) {
			JComboBox caja =(JComboBox) e.getSource();
			switch(caja.getSelectedItem().toString()) {
			case "España":
				this.descripcionPais.setText("<html>"+descripcionesPaises[0]+"</html>");
				break;
			case "Francia":
				this.descripcionPais.setText("<html>"+descripcionesPaises[1]+"</html>");
				break;
			case "Alemania":
				this.descripcionPais.setText("<html>"+descripcionesPaises[2]+"</html>");
				break;
			case "USA":
				this.descripcionPais.setText("<html>"+descripcionesPaises[3]+"</html>");
				break;
			case "URSS":
				this.descripcionPais.setText("<html>"+descripcionesPaises[4]+"</html>");
				break;
			case "Italia":
				this.descripcionPais.setText("<html>"+descripcionesPaises[5]+"</html>");
				break;
			case "Marruecos":
				this.descripcionPais.setText("<html>"+descripcionesPaises[6]+"</html>");
				break;
			case "Rumania":
				this.descripcionPais.setText("<html>"+descripcionesPaises[7]+"</html>");
				break;
			case "Noruega":
				this.descripcionPais.setText("<html>"+descripcionesPaises[8]+"</html>");
				break;
			case "Portugal":
				this.descripcionPais.setText("<html>"+descripcionesPaises[9]+"</html>");
				break;
			}	
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource() == this.campoNombreEquipo) {
			if(this.campoNombreEquipo.getText().length() > 15) {
				this.campoNombreEquipo.setText(this.campoNombreEquipo.getText().substring(0, this.campoNombreEquipo.getText().length()-1));
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
<<<<<<< HEAD
=======

	

>>>>>>> origin/main
}

