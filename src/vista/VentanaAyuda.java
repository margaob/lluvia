package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.DropMode;

import controlador.Controlador;


public class VentanaAyuda extends JFrame {

	private JPanel contentPane;
	private Controlador miCoordinador;

	/**
	 * Create the frame.
	 */
	public VentanaAyuda() {
		setResizable(false);
		setTitle("Lluvia de letras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
				//***************TEXTO
				
				JTextPane textAyuda = new JTextPane();
				
				StyledDocument doc = textAyuda.getStyledDocument();
				SimpleAttributeSet center = new SimpleAttributeSet();
				StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
				doc.setParagraphAttributes(0, doc.getLength(), center, false);
				
				
				textAyuda.setFont(new Font("Verdana", Font.PLAIN, 14));
				textAyuda.setEditable(false);
				textAyuda.setText("\n" +
						"COMO JUGAR \n" +
						"\n" +
						"Realiza combinaciones con las 6 letras al azar dadas al principio.\n" +
						"Mínimo combinaciones 3 letras.\n" +
						"Cuantas más letras tenga la palabra más puntos recibirás:\n" +
						"*Palabras de 3 letras : 10 puntos.\n" +
						"*Palabras de 4 letras : 30 puntos.\n" +
						"*Palabras de 5 letras : 40 puntos.\n" +
						"*Palabras de 6 letras : 75 puntos.\n" +
						"La partida finaliza cuando aciertas todas las palabras o cuando acaba el tiempo.\n" +
						"*Bonus por acertar todas las palabras : 200 puntos.\n" +
						"Realiza el máximo de palabras para entrar en el ranking.\n" +
						"Para ver como vas mejorando en el juego, identifícate y visita tus estadísticas");
				
				
						textAyuda.setBounds(45, 91, 641, 288);
						contentPane.add(textAyuda);
		
		//******************************** TITULO ********************************
		
				JLabel lbTitulo = new JLabel("L L U V I A   D E   L E T R A S");
				lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lbTitulo.setForeground(Color.WHITE);
				lbTitulo.setFont(new Font("Verdana", Font.BOLD, 36));
				lbTitulo.setBounds(10, 20, 724, 36);
				contentPane.add(lbTitulo);

		// ******************************** BOTÓ MENÚ PRINCIPAL  ********************************

		JButton btnMenu = new JButton("Menú principal");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaMenu();
				dispose();
			}
		});
		
		
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setOpaque(false);
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorderPainted(false);
		btnMenu.setIconTextGap(15);
		try {
			Image imgIdent = ImageIO.read(getClass().getResource(
					"/img/Menu2.png"));
			btnMenu.setIcon(new ImageIcon(imgIdent));
		} catch (IOException ex) {
		}
		btnMenu.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMenu.setBounds(384, 406, 228, 70);
		contentPane.add(btnMenu);

		// ******************************** BOTÓ NUEVA ********************************

		JButton btnNueva = new JButton("Nueva Partida");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaJuego();
				dispose();
			}
		});
		btnNueva.setForeground(Color.WHITE);
		btnNueva.setOpaque(false);
		btnNueva.setContentAreaFilled(false);
		btnNueva.setBorderPainted(false);
		btnNueva.setIconTextGap(15);
		try {
			Image imgNueva = ImageIO.read(getClass().getResource(
					"/img/Nueva2.png"));
			btnNueva.setIcon(new ImageIcon(imgNueva));
		} catch (IOException ex) {
		}
		btnNueva.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNueva.setBounds(110, 406, 221, 70);
		contentPane.add(btnNueva);
		
		

		// ******************************** FONDO ********************************

		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 750, 471);
		try {
			// Image img =
			// ImageIO.read(getClass().getResource("/img/Menu.png"));
			Image img = ImageIO.read(getClass().getResource("/img/fondo3.png"));
			lblFondo.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

		contentPane.add(lblFondo);

	}
	
	public void setCoordinador(Controlador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
