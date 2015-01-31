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

public class vAyuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vAyuda frame = new vAyuda();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vAyuda() {
		setResizable(false);
		setTitle("Lluvia de letras");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
				//***************TEXTO
				
				JTextPane textAyuda = new JTextPane();
				textAyuda.setText(" COMO JUGAR"
						+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
						+ "Integer interdum ex in velit interdum, congue egestas diam laoreet. "
						+ "Curabitur eget euismod erat, placerat malesuada ex. "
						+ "Phasellus ultrices lacus vitae nibh pulvinar aliquet. "
						+ "Etiam velit tortor, luctus scelerisque elit at, dictum rhoncus massa. "
						+ "In suscipit pellentesque ipsum, condimentum accumsan nunc finibus at. "
						+ "Cras gravida est eget justo consectetur ultricies ac eu nisi. "
						+ "Proin pellentesque urna in volutpat scelerisque. "
						+ "Cras convallis elit sit amet elit tempor posuere. "
						+ "Nunc non ultricies quam. Maecenas dictum iaculis erat ut consequat.");
				
				
						textAyuda.setBounds(20, 91, 700, 288);
						contentPane.add(textAyuda);
		
		//******************************** TITULO ********************************
		
				JLabel lbTitulo = new JLabel("L L U V I A   D E   L E T R A S");
				lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lbTitulo.setForeground(Color.WHITE);
				lbTitulo.setFont(new Font("Verdana", Font.BOLD, 36));
				lbTitulo.setBounds(10, 20, 724, 36);
				contentPane.add(lbTitulo);

		// ******************************** BOTÓ MENÚ PRINCIPAL
		// ********************************

		JButton btnMenu = new JButton("Menú principal");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vMenu vm = new vMenu();
				vm.setVisible(true);
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

		// ******************************** BOTÓ NUEVA
		// ********************************

		JButton btnNueva = new JButton("Nueva Partida");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vJoc vj = new vJoc();
				vj.setVisible(true);
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
		
		

		// ******************************** FONDO
		// ********************************

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
}
