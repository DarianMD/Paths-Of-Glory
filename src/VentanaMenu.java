import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public VentanaMenu() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Paths of Glory");
		setLocationRelativeTo(null);
		setResizable(false);
		
	
		JButton jugar = new JButton("");
		jugar.setIcon(new ImageIcon(VentanaMenu.class.getResource("/Assets/Botones/jugar.png")));
		jugar.setBounds(290, 230, 252, 54);
		contentPane.add(jugar);
		
		JButton opciones = new JButton("");
		opciones.setIcon(new ImageIcon(VentanaMenu.class.getResource("/Assets/Botones/opciones.png")));
		opciones.setBounds(290, 280, 252, 54);
		contentPane.add(opciones);
		
		JButton reglas = new JButton("");
		reglas.setIcon(new ImageIcon(VentanaMenu.class.getResource("/Assets/Botones/reglas.png")));
		reglas.setBounds(290, 330, 252, 54);
		contentPane.add(reglas);
		
		JButton creadores = new JButton("");
		creadores.setIcon(new ImageIcon(VentanaMenu.class.getResource("/Assets/Botones/creadores.png")));
		creadores.setBounds(290, 380, 252, 54);
		contentPane.add(creadores);
		
		JButton salir = new JButton("");
		salir.setIcon(new ImageIcon(VentanaMenu.class.getResource("/Assets/Botones/salir.png")));
		salir.setBounds(290, 430, 252, 54);
		contentPane.add(salir);
		
		
	
		ImageIcon marco = new 	ImageIcon("./src/Assets/Otros/marco_final.png");
		JLabel marco_label = new JLabel(marco);
		marco_label.setBounds(0, 0, 844, 621);
		contentPane.add(marco_label);
	
		ImageIcon ic1 = new 	ImageIcon("./src/Assets/Otros/titulo.png");
		JLabel lblNewLabel_2 = new JLabel(ic1);
		lblNewLabel_2.setBounds(0, -180, 844, 621);
		contentPane.add(lblNewLabel_2);
		
		
	
		
		ImageIcon ic = new 	ImageIcon("./src/Assets/Fondos/video_f1.gif");
		
		JLabel lblNewLabel_1 = new JLabel(ic);
		lblNewLabel_1.setBounds(0, 0, 844, 621);
		contentPane.add(lblNewLabel_1);
		




		
	
	}
}