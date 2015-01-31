package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import controlador.Controlador;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenu extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Controlador miCoordinador;


	/**
	 * Create the frame.
	 */
	public VentanaMenu() {
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		setTitle("Lluvia de letras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 500);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrar();
            }
        });
		
		
		
//******************************** TITULO ********************************
		
		JLabel lblTitulo = new JLabel("L L U V I A   D E   L E T R A S");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 36));
		lblTitulo.setBounds(0, 20, 724, 36);
		contentPane.add(lblTitulo);

		
//******************************** BOTÓN IDENTIFICAR ********************************
		
		JButton btnIdent = new JButton("Identificarse");
		btnIdent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaIdentificarse();
				dispose();
			}
		});
		btnIdent.setHorizontalAlignment(SwingConstants.LEFT);
		btnIdent.setForeground(Color.WHITE);
		btnIdent.setOpaque(false);
		btnIdent.setContentAreaFilled(false);
		btnIdent.setBorderPainted(false);
		btnIdent.setIconTextGap(30);
		try {
			   Image imgIdent = ImageIO.read(getClass().getResource("/img/Identificarse.png"));
			   btnIdent.setIcon(new ImageIcon(imgIdent));
			  } catch (IOException ex) {
			 }
		btnIdent.setFont(new Font("Verdana", Font.BOLD, 18));
		btnIdent.setBounds(418, 82, 300, 60);
		contentPane.add(btnIdent);

//******************************** BOTÓN NUEVA PARTIDA ********************************
		
		JButton btnNueva = new JButton("Nueva Partida");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaJuego();
				dispose();
			}
		});
		
		btnNueva.setHorizontalAlignment(SwingConstants.LEFT);
		btnNueva.setForeground(Color.WHITE);
		btnNueva.setOpaque(false);
		btnNueva.setContentAreaFilled(false);
		btnNueva.setBorderPainted(false);
		btnNueva.setIconTextGap(30);
		try {
			   Image imgNueva = ImageIO.read(getClass().getResource("/img/Nueva.png"));
			   btnNueva.setIcon(new ImageIcon(imgNueva));
			  } catch (IOException ex) {
			 }
		btnNueva.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNueva.setBounds(424, 152, 300, 60);
		contentPane.add(btnNueva);
		
		
//******************************** BOTÓN RANKING ********************************		
		
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaRanking();
				dispose();
			}
		});
		btnRanking.setHorizontalAlignment(SwingConstants.LEFT);
		btnRanking.setForeground(Color.WHITE);
		btnRanking.setOpaque(false);
		btnRanking.setBorderPainted(false);
		btnRanking.setIconTextGap(55);
		try {
			   Image imgRanking = ImageIO.read(getClass().getResource("/img/Ranking.png"));
			   btnRanking.setIcon(new ImageIcon(imgRanking));
			  } catch (IOException ex) {
			 }
		btnRanking.setContentAreaFilled(false);
		btnRanking.setFont(new Font("Verdana", Font.BOLD, 18));
		btnRanking.setBounds(425, 220, 300, 71);
		contentPane.add(btnRanking);

//******************************** BOTÓN ESTADISTICAS ********************************
		
		JButton btnEstats = new JButton("Estadisticas");
		btnEstats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaEstadisticas();
				dispose();
			}
		});
		
		btnEstats.setHorizontalAlignment(SwingConstants.LEFT);
		btnEstats.setForeground(Color.WHITE);
		btnEstats.setOpaque(false);
		btnEstats.setBorderPainted(false);
		btnEstats.setIconTextGap(35);
		try {
			   Image imgEstats = ImageIO.read(getClass().getResource("/img/Estats.png"));
			   btnEstats.setIcon(new ImageIcon(imgEstats));
			  } catch (IOException ex) {
			 }
		btnEstats.setContentAreaFilled(false);
		btnEstats.setFont(new Font("Verdana", Font.BOLD, 18));
		btnEstats.setBounds(424, 297, 300, 72);
		contentPane.add(btnEstats);

//******************************** BOTÓN AYUDA ********************************
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaAyuda();
				dispose();
			}
		});
		
		
		btnAyuda.setHorizontalAlignment(SwingConstants.LEFT);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setOpaque(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setIconTextGap(65);
		try {
			   Image imgAyuda = ImageIO.read(getClass().getResource("/img/Ayuda.png"));
			   btnAyuda.setIcon(new ImageIcon(imgAyuda));
			  } catch (IOException ex) {
			 }
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAyuda.setBounds(425, 380, 300, 75);
		contentPane.add(btnAyuda);
		try {
			   Image imgParaguas = ImageIO.read(getClass().getResource("/img/Paraguas.png"));
			  } catch (IOException ex) {
			 }

//******************************** FONDO ********************************		
	
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 750, 500);
		try {
		   //Image img = ImageIO.read(getClass().getResource("/img/Menu.png"));
		   Image img = ImageIO.read(getClass().getResource("/img/fondo.png"));
		   lblFondo.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		 }
	
		contentPane.add(lblFondo);

	}
	
	private void cerrar(){
        if (JOptionPane.showConfirmDialog(rootPane,"¿Desea realmente salir del sistema?",
               "Salir de Lluvia de Letras", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
           System.exit(0);
		
		
		
    }
	
	public void setCoordinador(Controlador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
