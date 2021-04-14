import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
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
	 */
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Paths of Glory");
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		ImageIcon marco = new 	ImageIcon("./src/assets/marco_final.png");
		JLabel marco_label = new JLabel(marco);
		marco_label.setBounds(0, 0, 844, 621);
		contentPane.add(marco_label);
		
		ImageIcon ic1 = new 	ImageIcon("./src/assets/titulo.png");
		JLabel lblNewLabel_2 = new JLabel(ic1);
		lblNewLabel_2.setBounds(0, -180, 844, 621);
		contentPane.add(lblNewLabel_2);
		
		
		ImageIcon jugar = new ImageIcon("./src/assets/jugar.png");
		JLabel titulo = new JLabel(jugar);
		titulo.setBounds(0, -60, 844, 621);
		contentPane.add(titulo);
		
		
		ImageIcon opciones = new ImageIcon("./src/assets/opciones.png");
		JLabel opci = new JLabel(opciones);
		opci.setBounds(0, 0, 844, 621);
		contentPane.add(opci);
		
		ImageIcon reglas = new ImageIcon("./src/assets/reglas.png");
		JLabel regl = new JLabel(reglas);
		regl.setBounds(0, 60, 844, 621);
		contentPane.add(regl);
		
		ImageIcon creadores = new ImageIcon("./src/assets/creadores.png");
		JLabel crear = new JLabel(creadores);
		crear.setBounds(0, 120, 844, 621);
		contentPane.add(crear);
		
		
		
		
		
		ImageIcon ic = new 	ImageIcon("./src/assets/video_f1.gif");
		
		JLabel lblNewLabel_1 = new JLabel(ic);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(0, 0, 844, 621);
		contentPane.add(lblNewLabel_1);



		
	
	}
}