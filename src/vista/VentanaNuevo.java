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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;



public class VentanaNuevo extends JFrame {

	private Controlador miCoordinador;
	
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblConstrasenya, lblConstrasenya2;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenya, txtContrasenya2;
	private JButton btnNuevo;

	/**
	 * Create the frame.
	 */
	public VentanaNuevo() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ******************************** USUARIO ********************************
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 14));
		lblUsuario.setBounds(20, 68, 146, 30);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(183, 70, 226, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		// ******************************** CONTRASEÑA ********************************
		lblConstrasenya = new JLabel("Contrase\u00F1a:");
		lblConstrasenya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConstrasenya.setForeground(Color.WHITE);
		lblConstrasenya.setFont(new Font("Verdana", Font.BOLD, 14));
		lblConstrasenya.setBounds(20, 104, 146, 30);
		contentPane.add(lblConstrasenya);

		txtContrasenya = new JPasswordField();
		txtContrasenya.setBounds(183, 105, 226, 30);
		contentPane.add(txtContrasenya);
		txtContrasenya.setColumns(10);
		
		lblConstrasenya2 = new JLabel("Repetir Contrase\u00F1a:");
		lblConstrasenya2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConstrasenya2.setForeground(Color.WHITE);
		lblConstrasenya2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblConstrasenya2.setBounds(0, 134, 166, 42);
		contentPane.add(lblConstrasenya2);

		txtContrasenya2 = new JPasswordField();
		txtContrasenya2.setBounds(183, 142, 226, 30);
		contentPane.add(txtContrasenya2);
		txtContrasenya2.setColumns(10);

		// ******************************** BOTON NUEVO
		// ********************************
		btnNuevo = new JButton("Aceptar");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtContrasenya.getText().length()==0){
					JOptionPane.showMessageDialog(contentPane, "No has escrito ninguna contraseña");
				}else{
					
					if (txtContrasenya.getText().equals(txtContrasenya2.getText())){
						char[] pass = txtContrasenya.getPassword();
						miCoordinador.nuevoUsuario(txtUsuario.getText(),txtContrasenya.getText());
						miCoordinador.mostrarVentanaIdentificarse();
						dispose();
					}else{
						JOptionPane.showMessageDialog(contentPane, "Las contraseñas no coinciden");
					}
				}
				
				
			}
		});
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setOpaque(false);
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setBorderPainted(false);
		btnNuevo.setIconTextGap(10);
		try {
			Image imgNuevo = ImageIO.read(getClass().getResource(
					"/img/Nuevo2.png"));
			btnNuevo.setIcon(new ImageIcon(imgNuevo));
		} catch (IOException ex) {
		}
		btnNuevo.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNuevo.setBounds(183, 165, 226, 50);
		contentPane.add(btnNuevo);
		
		
		// ******************************** BOTÓ MENÚ PRINCIPAL ********************************
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
		btnMenu.setIconTextGap(30);
		try {
			Image imgIdent = ImageIO.read(getClass().getResource(
					"/img/Menu2.png"));
			btnMenu.setIcon(new ImageIcon(imgIdent));
		} catch (IOException ex) {
		}
		btnMenu.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMenu.setBounds(-3, 221, 447, 50);
		contentPane.add(btnMenu);

		// ******************************** FONDO ********************************

		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, -20, 450, 300);
		try {

			Image img = ImageIO
					.read(getClass().getResource("/img/fondo21.png"));
			lblFondo.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		contentPane.add(lblFondo);

	}
	
	public void setCoordinador(Controlador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
