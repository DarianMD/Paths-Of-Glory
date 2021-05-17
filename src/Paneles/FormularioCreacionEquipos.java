package Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import JuegoPaises.*;



//Es la clase de la ventana donde se crean los equipos
public class FormularioCreacionEquipos extends JFrame implements ActionListener, KeyListener{

	private String[] listaPaises = {"España","Alemania","URSS","USA","Portugal","Noruega","Francia","Italia","Rumania","Marruecos"};

	private String[] descripcionesPaises = {
			"España tiene un poderoso ejercito y un enorme potencial militar.\n "
					+ "Su lider Franco es temido en todo el globo.",

			"Alemania, el tercer reich se alza comandado por Hitler. Cuenta con un gran ejercito"
									+"muy disciplinado.",
			"La URSS. Potencia comunista del globo, su poder reside en el número de soldados. Son fuertes y rusos la mayoria,"
				+"con eso se dice todo",

			"Estados Unidos de America. Abraham Lincoln lo govierna con lealtad, disciplina y determinacion."+
			"Un pais muy temible",
			
			"Portugal, tambien conocidos como los diablos de Portua, temibles soldados armados hasta los dientes y liderados por Salazar.",
			"Noruega el mayor exportador de salmón del mundo, es también el mayor importador de armas del mundo."+
				"Con una economia sumamente rica y un poder militar imbatible son considerados una gran amenaza por el mundo entero.",
			
			"Francia o tambien llamada la potencia Baguette. Poderosos y temibles,"
				+ "comandados por su poderoso lider Franchuten.",
			"Italia, el país de la pasta, y no precisamente la de comer (que también). Su lider Mussolini"
			+ "es un hombre severo y temible, ademas de calvo.",
		    "Rumania y su lider Vlad son temidos por el mundo entero. Vlad el empalador, tambien llamado el conde Dracúla impone"
					+ "el terror solo con su presencia.",
			"Marruecos, liderado por Sadam Husein, lider politico brillante, tiene un ejercito de tierra, mar y aire sumamente"
		    + "poderoso. Ademas de comer unos kebabs que estan de lujo.",
		
		

	};
	
	
	private String[] vida_jugador = {"250", "190", "130", "250", "200+", "250", "220", "200", "500","230"};
	
	private String[] daño_jugador = {"0.6", "1.2", "1.4", "1.1", "0.5", "0.7", "0.9", "1", "0.2", "1.25"};


	Font  fuente1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 25);
	Font  fuente2  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ROMAN_BASELINE, 17);
	Font  fuente3  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ROMAN_BASELINE, 35);



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
	
	
	
	

	private JLabel etiquetaNombres = new JLabel("Añade el nombre de tu equipo");
	private JLabel descripcionPais = new JLabel("Hola");
	private JLabel fotoDictador = new JLabel("");
	private JLabel vida_dictador = new JLabel("");
	private JLabel daño_dictador = new JLabel("");
	private JLabel vida = new JLabel("Vida : ");
	private JLabel daño = new JLabel("Daño : ");



	private JTextField campoNombreEquipo = new JTextField();
	private JComboBox cajaEquipos = new JComboBox(listaPaises);
	private JButton botonAdd = new JButton("Añadir");
	
	private JLabel marco_label = new JLabel();
	private ImageIcon marco_foto = new ImageIcon("./assets/Fondos/marco_formulario_equipos.png");

	
	private JLabel fondo_label = new JLabel();
	private ImageIcon fondo_foto = new ImageIcon("./assets/Fondos/fondo_formulario_equipos.jpg");
	
	private JLabel marco_personaje_label = new JLabel();
	private ImageIcon marco_personaje_foto = new ImageIcon("./assets/Fondos/marco_personaje.png");



	public FormularioCreacionEquipos() {
		setSize(715,735);
		setLayout(null);
		setResizable(false);
		setTitle("Crear equipo");
		inicializarComponentes();
		setVisible(true);
		double vida_ = new PaisEspania("pais").getVida();
	}

	//Inicializa todos los componentes del panel
	public void inicializarComponentes() {
		
		etiquetaNombres.setFont(fuente1);
		descripcionPais.setFont(fuente2);
		daño_dictador.setFont(fuente3);
		vida_dictador.setFont(fuente3);
		daño.setFont(fuente3);
		vida.setFont(fuente3);



		marco_personaje_label.setBounds(490,40,170,230);
		marco_personaje_label.setIcon(marco_personaje_foto);
		this.add(marco_personaje_label);

		marco_label.setBounds(0,0,700,700);
		marco_label.setIcon(marco_foto);
		this.add(marco_label);
		
		
		etiquetaNombres.setBounds(40, 0,500,100);
		add(etiquetaNombres);

		campoNombreEquipo.setBounds(40, 85, 400, 25);
		campoNombreEquipo.addKeyListener(this);
		add(campoNombreEquipo);

		descripcionPais.setBounds(40, 55, 300, 300);
		descripcionPais.setText("<html>"+this.descripcionesPaises[0]+"</html>");
		add(descripcionPais);
		
		vida_dictador.setBounds(550, 200, 300, 300);
		vida_dictador.setText("<html>"+this.vida_jugador[0]+"</html>");
		add(vida_dictador);
		
		daño_dictador.setBounds(550, 250, 300, 300);
		daño_dictador.setText("<html>"+this.daño_jugador[0]+"</html>");
		add(daño_dictador);

		
		daño.setBounds(450, 250, 300, 300);
		daño.setText("Daño");
		add(daño);
		
		vida.setBounds(450, 200, 300, 300);
		vida.setText("Vida");
		add(vida);
		
		fotoDictador.setBounds(500, 50, 150, 200);
		fotoDictador.setIcon(image[0]);
		add(fotoDictador);


		cajaEquipos.setBounds(475, 275, 200, 25);
		cajaEquipos.addActionListener(this);
		add(cajaEquipos);

		botonAdd.setBounds(40, 500, 130,180);
		add(botonAdd);
		
		fondo_label.setBounds(0,0,700,700);
		fondo_label.setIcon(fondo_foto);
		this.add(fondo_label);
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
				vida_dictador.setText("<html>"+this.vida_jugador[0]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[0]+"</html>");

				break;
			case "Alemania":
				this.descripcionPais.setText("<html>"+descripcionesPaises[1]+"</html>");
				this.fotoDictador.setIcon(image[1]);
				vida_dictador.setText("<html>"+this.vida_jugador[1]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[1]+"</html>");
				break;
			case "URSS":
				this.descripcionPais.setText("<html>"+descripcionesPaises[2]+"</html>");
				this.fotoDictador.setIcon(image[2]);
				vida_dictador.setText("<html>"+this.vida_jugador[2]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[2]+"</html>");
				break;
			case "USA":
				this.descripcionPais.setText("<html>"+descripcionesPaises[3]+"</html>");
				this.fotoDictador.setIcon(image[3]);
				vida_dictador.setText("<html>"+this.vida_jugador[3]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[3]+"</html>");
				break;
			case "Portugal":
				this.descripcionPais.setText("<html>"+descripcionesPaises[4]+"</html>");
				this.fotoDictador.setIcon(image[4]);
				vida_dictador.setText("<html>"+this.vida_jugador[4]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[4]+"</html>");
				break;
			case "Noruega":
				this.descripcionPais.setText("<html>"+descripcionesPaises[5]+"</html>");
				this.fotoDictador.setIcon(image[5]);
				vida_dictador.setText("<html>"+this.vida_jugador[5]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[5]+"</html>");
				break;
			case "Francia":
				this.descripcionPais.setText("<html>"+descripcionesPaises[6]+"</html>");
				this.fotoDictador.setIcon(image[6]);
				vida_dictador.setText("<html>"+this.vida_jugador[6]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[6]+"</html>");
				break;
			case "Italia":
				this.descripcionPais.setText("<html>"+descripcionesPaises[7]+"</html>");
				this.fotoDictador.setIcon(image[7]);
				vida_dictador.setText("<html>"+this.vida_jugador[7]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[7]+"</html>");

				break;
			case "Rumania":
				this.descripcionPais.setText("<html>"+descripcionesPaises[8]+"</html>");
				this.fotoDictador.setIcon(image[8]);
				vida_dictador.setText("<html>"+this.vida_jugador[8]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[8]+"</html>");

				break;
			case "Marruecos":
				this.descripcionPais.setText("<html>"+descripcionesPaises[9]+"</html>");
				this.fotoDictador.setIcon(image[9]);
				vida_dictador.setText("<html>"+this.vida_jugador[9]+"</html>");
				daño_dictador.setText("<html>"+this.daño_jugador[9]+"</html>");
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
}