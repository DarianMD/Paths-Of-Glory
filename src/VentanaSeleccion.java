import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class VentanaSeleccion extends JFrame {

	private JFrame frame;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSeleccion frame = new VentanaSeleccion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaSeleccion() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Ventana Seleccion");
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		ImageIcon titulo = new 	ImageIcon("./src/Assets/Otros/Titulo_seleccion.png");
		JLabel title = new JLabel(titulo);
		title.setBounds(0, -180, 844, 621);
		contentPane.add(title);
		
		ImageIcon marco = new 	ImageIcon("./src/Assets/Otros/marco_final.png");
		JLabel marco_label = new JLabel(marco);
		marco_label.setBounds(0, 0, 844, 621);
		contentPane.add(marco_label);
		
		ImageIcon fondo = new 	ImageIcon("./src/Assets/Fondos/fondo_seleccion.png");
		JLabel fond = new JLabel(fondo);
		fond.setBounds(0, 0, 844, 621);
		contentPane.add(fond);
		
	}
}
