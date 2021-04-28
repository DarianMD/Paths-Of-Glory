package Paneles;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Paises.*;


//Es la clase de la ventana donde se crean los equipos
public class FormularioCreacionEquipos extends JFrame implements ActionListener{

	private String[] listaPaises = {"España","Alemania","URSS","USA","Portugal","Noruega","Francia","Italia","Rumania","Marruecos"};

	private String[] descripcionesPaises = {
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

	};



	ImageIcon[] image = {
			new ImageIcon("./assets/Personajes/Equipo_1/1.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_1/2.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_1/3.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_1/4.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_2/1.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_2/2.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_2/3.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_2/4.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_3/1.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_3/2.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_3/3.PNG"),
			new ImageIcon("./assets/Personajes/Equipo_3/3.PNG"),
	};
	
	
	
	Paises.Pais españa = new PaisEspania();
	

	private JLabel etiquetaNombres = new JLabel("Añade el nombre de tu equipo");
	private JLabel etiquetaPaises = new JLabel("Elige el pais que quieres controlar");
	private JLabel descripcionPais = new JLabel("Hola");
	private JLabel fotoDictador = new JLabel("");


	private JTextField campoNombreEquipo = new JTextField();
	private JComboBox cajaEquipos = new JComboBox(listaPaises);
	private JButton botonAdd = new JButton("Añadir");

	public FormularioCreacionEquipos() {
		setSize(700,700);
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

		descripcionPais.setBounds(5, 120, 180, 10);
		descripcionPais.setText("<html>"+this.descripcionesPaises[0]+"</html>");
		add(descripcionPais);

		fotoDictador.setBounds(400, 400, 150, 200);
		fotoDictador.setIcon(image[0]);
		add(fotoDictador);





		cajaEquipos.setBounds(5, 125, 200, 25);
		cajaEquipos.addActionListener(this);
		add(cajaEquipos);

		botonAdd.setBounds(5, 300, 130,180);
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
				this.fotoDictador.setIcon(image[0]);
				break;
			case "Alemania":
				this.descripcionPais.setText("<html>"+descripcionesPaises[1]+"</html>");
				this.fotoDictador.setIcon(image[1]);
				break;
			case "URSS":
				this.descripcionPais.setText("<html>"+descripcionesPaises[2]+"</html>");
				this.fotoDictador.setIcon(image[2]);
				break;
			case "USA":
				this.descripcionPais.setText("<html>"+descripcionesPaises[3]+"</html>");
				this.fotoDictador.setIcon(image[3]);

				break;
			case "Portugal":
				this.descripcionPais.setText("<html>"+descripcionesPaises[4]+"</html>");
				this.fotoDictador.setIcon(image[4]);

				break;
			case "Noruega":
				this.descripcionPais.setText("<html>"+descripcionesPaises[5]+"</html>");
				this.fotoDictador.setIcon(image[5]);

				break;
			case "Francia":
				this.descripcionPais.setText("<html>"+descripcionesPaises[6]+"</html>");
				this.fotoDictador.setIcon(image[6]);

				break;
			case "Italia":
				this.descripcionPais.setText("<html>"+descripcionesPaises[7]+"</html>");
				this.fotoDictador.setIcon(image[7]);

				break;
			case "Rumania":
				this.descripcionPais.setText("<html>"+descripcionesPaises[8]+"</html>");
				this.fotoDictador.setIcon(image[8]);

				break;
			case "Marruecos":
				this.descripcionPais.setText("<html>"+descripcionesPaises[9]+"</html>");
				this.fotoDictador.setIcon(image[9]);

				break;
			}	
		}	
	}
}
