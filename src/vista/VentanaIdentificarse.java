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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import controlador.Controlador;
import javax.swing.JPasswordField;

public class VentanaIdentificarse extends JFrame {

	private Controlador miCoordinador;
	
	private JPanel contentPane;
	private JPasswordField txtContrasenya;
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JLabel lblConstrasenya;
	private JButton btnNuevo, btnIniciarSesion;

	/**
	 * Create the frame.
	 */
	public VentanaIdentificarse() {
		setResizable(false);
		
		setTitle("Lluvia de letras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 500);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//******************************** TITULO ********************************
		
		JLabel lblTitulo = new JLabel("L L U V I A   D E   L E T R A S");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 36));
		lblTitulo.setBounds(0, 46, 724, 36);
		contentPane.add(lblTitulo);
		

		
//******************************** BOT� MEN� PRINCIPAL ********************************
		JButton btnMenu = new JButton("Men� principal");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaMenu();;
				dispose();
			}
		});
		
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setOpaque(false);
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorderPainted(false);
		btnMenu.setIconTextGap(30);
		try {
			   Image imgIdent = ImageIO.read(getClass().getResource("/img/Menu.png"));
			   btnMenu.setIcon(new ImageIcon(imgIdent));
			  } catch (IOException ex) {
			 }
		btnMenu.setFont(new Font("Verdana", Font.BOLD, 18));
		btnMenu.setBounds(0, 411, 734, 49);
		contentPane.add(btnMenu);

//******************************** USUARIO ********************************
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 18));
		lblUsuario.setBounds(98, 215, 146, 30);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(271, 215, 320, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
//******************************** CONTRASE�A ********************************		
		lblConstrasenya = new JLabel("Contrase\u00F1a:");
		lblConstrasenya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConstrasenya.setForeground(Color.WHITE);
		lblConstrasenya.setFont(new Font("Verdana", Font.BOLD, 18));
		lblConstrasenya.setBounds(98, 264, 146, 30);
		contentPane.add(lblConstrasenya);

		
		txtContrasenya = new JPasswordField();
		txtContrasenya.setBounds(271, 268, 320, 30);
		contentPane.add(txtContrasenya);
		txtContrasenya.setColumns(10);

//******************************** BOTON NUEVO ********************************			
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaNuevo();
				dispose();
			}
		});
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setOpaque(false);
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setBorderPainted(false);
		btnNuevo.setIconTextGap(10);
		try {
			   Image imgNuevo = ImageIO.read(getClass().getResource("/img/Nuevo.png"));
			   btnNuevo.setIcon(new ImageIcon(imgNuevo));
			  } catch (IOException ex) {
			 }
		btnNuevo.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNuevo.setBounds(240, 314, 200, 50);
		contentPane.add(btnNuevo);
		

//******************************** BOTON INICIAR SESION ********************************	
		btnIniciarSesion = new JButton("<html>Iniciar<br />Sesi�n</html>");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (miCoordinador.logearse(txtUsuario.getText(),txtContrasenya.getText()) == 0){
					JOptionPane.showMessageDialog(contentPane, txtUsuario.getText()+", sesi�n iniciada con exito.");
					miCoordinador.mostrarVentanaMenu();
					dispose();
				}
			}
		});
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setIconTextGap(10);
		try {
			   Image imgIniciarSesion = ImageIO.read(getClass().getResource("/img/IniciarSesion.png"));
			   btnIniciarSesion.setIcon(new ImageIcon(imgIniciarSesion));
			  } catch (IOException ex) {
			 }
		btnIniciarSesion.setFont(new Font("Verdana", Font.BOLD, 18));
		btnIniciarSesion.setBounds(408, 308, 200, 66);
		contentPane.add(btnIniciarSesion);
		
//******************************** FONDO ********************************		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 750, 500);
		try {
				
			Image img = ImageIO.read(getClass().getResource("/img/fondo2.png"));
			lblFondo.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		contentPane.add(lblFondo);
		


	}
	
	public void setCoordinador(Controlador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
