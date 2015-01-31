package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

public class vJoc extends JFrame {

	private JTable taulap3;
	private JTable taulap4;
	private JTable taulap5;
	private JTable taulap6;
	
	private DefaultTableModel dtm3;
	private DefaultTableModel dtm4;
	private DefaultTableModel dtm5;
	private DefaultTableModel dtm6;
	
	private JScrollPane scrollPane3;
	private JScrollPane scrollPane4;
	private JScrollPane scrollPane5;
	private JScrollPane scrollPane6;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField tLletra1;
	private JTextField tLletra2;
	private JTextField tLletra3;
	private JTextField tLletra4;
	private JTextField tLletra5;
	private JTextField tLletra6;
	private JTextField textField_1;
	private JLabel lblProgressBar;
	private JLabel lblPunts;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vJoc frame = new vJoc();
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
	public vJoc() {
		setResizable(false);
		setTitle("Lluvia de letras");
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//******************************** TITULO ********************************
		
		JLabel lbTitulo = new JLabel("L L U V I A   D E   L E T R A S");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setForeground(new Color(25, 25, 112));
		lbTitulo.setFont(new Font("Verdana", Font.BOLD, 36));
		lbTitulo.setBounds(10, 42, 724, 36);
		contentPane.add(lbTitulo);

//******************************** CLOCK ********************************
		
		final long THIRTY_MINUTES = 60000;
	    
	    final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("mm : ss");  
		
		JLabel clock = new JLabel(sdf.format(new Date(THIRTY_MINUTES)),JLabel.CENTER);
		clock.setForeground(Color.WHITE);
		clock.setFont(new Font("Verdana", Font.BOLD, 14));
		clock.setBounds(214, 153,129, 50);
		clock.setIconTextGap(-10);
		try {
			Image imgClock = ImageIO.read(getClass().getResource("/img/clock.png"));
			clock.setIcon(new ImageIcon(imgClock));
		} catch (IOException ex) {
		}
		contentPane.add(clock);
		
		
// ******************************** LLETRES ********************************
		
		tLletra1 = new JTextField("B");
		tLletra1.setHorizontalAlignment(SwingConstants.CENTER);
		tLletra1.setFont(new Font("Tahoma", Font.BOLD, 14));
		tLletra1.setForeground(new Color(25, 25, 112));
		tLletra1.setBounds(193, 169, 21, 20);
		tLletra1.setOpaque(false);
		tLletra1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(tLletra1);
		
		
		tLletra2 = new JTextField("B");
		tLletra2.setHorizontalAlignment(SwingConstants.CENTER);
		tLletra2.setFont(new Font("Tahoma", Font.BOLD, 14));
		tLletra2.setForeground(new Color(25, 25, 112));
		tLletra2.setBounds(259, 140, 21, 20);
		tLletra2.setOpaque(false);
		tLletra2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(tLletra2);
		
		
		tLletra3 = new JTextField("B");
		tLletra3.setHorizontalAlignment(SwingConstants.CENTER);
		tLletra3.setFont(new Font("Tahoma", Font.BOLD, 14));
		tLletra3.setForeground(new Color(25, 25, 112));
		tLletra3.setBounds(336, 151, 21, 20);
		tLletra3.setOpaque(false);
		tLletra3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(tLletra3);
		
		
		tLletra4 = new JTextField("B");
		tLletra4.setHorizontalAlignment(SwingConstants.CENTER);
		tLletra4.setFont(new Font("Tahoma", Font.BOLD, 14));
		tLletra4.setForeground(new Color(25, 25, 112));
		tLletra4.setBounds(412, 132, 21, 20);
		tLletra4.setOpaque(false);
		tLletra4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(tLletra4);
		
		tLletra5 = new JTextField("B");
		tLletra5.setHorizontalAlignment(SwingConstants.CENTER);
		tLletra5.setFont(new Font("Tahoma", Font.BOLD, 14));
		tLletra5.setForeground(new Color(25, 25, 112));
		tLletra5.setBounds(468, 169, 21, 20);
		tLletra5.setOpaque(false);
		tLletra5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(tLletra5);
		
		tLletra6 = new JTextField("B");
		tLletra6.setHorizontalAlignment(SwingConstants.CENTER);
		tLletra6.setFont(new Font("Tahoma", Font.BOLD, 14));
		tLletra6.setForeground(new Color(25, 25, 112));
		tLletra6.setBounds(535, 122, 21, 20);
		tLletra6.setOpaque(false);
		tLletra6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(tLletra6);

//******************************** PUNTUACIÓ ********************************		
		
		lblPunts = new JLabel("30");
		lblPunts.setHorizontalAlignment(SwingConstants.CENTER);
		lblPunts.setForeground(Color.WHITE);
		lblPunts.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPunts.setBounds(651, 165, 72, 30);
		contentPane.add(lblPunts);
		
		
		JLabel lblPuntuacio = new JLabel("");
		lblPuntuacio.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			Image imgPuntuacio = ImageIO.read(getClass().getResource("/img/puntuacio.png"));
			lblPuntuacio.setIcon(new ImageIcon(imgPuntuacio));
		} catch (IOException ex) {
		}
		lblPuntuacio.setBounds(641, 115, 93, 52);
		contentPane.add(lblPuntuacio);
		
		
//******************************** BOTÓ MENÚ COMPROBAR ********************************
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "He comprobado una palabra");
			}
		});
		btnComprobar.setForeground(Color.WHITE);
		btnComprobar.setOpaque(false);
		btnComprobar.setContentAreaFilled(false);
		btnComprobar.setBorderPainted(false);
		btnComprobar.setIconTextGap(-5);
		try {
			Image imgComprobar = ImageIO.read(getClass().getResource("/img/Check.png"));
			btnComprobar.setIcon(new ImageIcon(imgComprobar));
		} catch (IOException ex) {
		}
		btnComprobar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnComprobar.setBounds(582, 189, 168, 50);
		contentPane.add(btnComprobar);		
		
		
		
		
		//******************************** BOTÓ MENÚ PRINCIPAL ********************************
		
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
			Image imgIdent = ImageIO.read(getClass().getResource("/img/Menu2.png"));
			btnMenu.setIcon(new ImageIcon(imgIdent));
		} catch (IOException ex) {
		}
		btnMenu.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMenu.setBounds(484, 406, 228, 70);
		contentPane.add(btnMenu);		
		
//*******************TEXTFIELD***************************		
		
		textField = new JTextField();
		textField.setBounds(30, 200, 580, 30);
		contentPane.add(textField);
		textField.setColumns(10);		
	
//******************************** TABLA 3 LETRAS********************************		
		
		dtm3 = new DefaultTableModel();

		dtm3.addColumn("3 LETRAS");

		scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(30, 240, 140, 160);
		contentPane.add(scrollPane3);
		taulap3 = new JTable(dtm3);
		taulap3.setBounds(31, 246, 200, 50);
		scrollPane3.setViewportView(taulap3);
		taulap3.setPreferredScrollableViewportSize(new Dimension(100, 70));
		
//******************************** TABLA 4 LETRAS********************************		
		
		dtm4 = new DefaultTableModel();

		dtm4.addColumn("4 LETRAS");

		scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(177, 240, 140, 160);
		contentPane.add(scrollPane4);
		taulap4 = new JTable(dtm4);
		taulap4.setBounds(31, 246, 200, 50);
		scrollPane4.setViewportView(taulap4);
		taulap4.setPreferredScrollableViewportSize(new Dimension(100, 70));
		
//******************************** TABLA 5 LETRAS********************************		
		
		dtm5 = new DefaultTableModel();

		dtm5.addColumn("5 LETRAS");

		scrollPane5 = new JScrollPane();
		scrollPane5.setBounds(323, 240, 140, 160);
		contentPane.add(scrollPane5);
		taulap5 = new JTable(dtm5);
		taulap5.setBounds(31, 246, 200, 50);
		scrollPane5.setViewportView(taulap5);
		taulap5.setPreferredScrollableViewportSize(new Dimension(100, 70));
				
//******************************** TABLA 6 LETRAS********************************		
				
		dtm6 = new DefaultTableModel();
		dtm6.addColumn("6 LETRAS");

		scrollPane6 = new JScrollPane();
		scrollPane6.setBounds(470, 240, 140, 160);
		contentPane.add(scrollPane6);
		taulap6 = new JTable(dtm6);
		taulap6.setBounds(31, 246, 200, 50);
		scrollPane6.setViewportView(taulap6);
		taulap6.setPreferredScrollableViewportSize(new Dimension(100, 70));
				
		

		
//******************************** NUBES ********************************		
		
		JLabel lblNubes = new JLabel("");
		lblNubes.setBounds(20, 0,720, 200);
		try {
			Image img = ImageIO.read(getClass().getResource("/img/nubes2.png"));
			lblNubes.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		contentPane.add(lblNubes);
		
		
//******************************** PROGRESSBARR ********************************		
		/*
		lblProgressBar = new JLabel("40 %");
		lblProgressBar
		lblProgressBar.setFont(new Font("Verdana", Font.BOLD, 12));
		lblProgressBar.setForeground(Color.WHITE);
		lblProgressBar.setBounds(676, 299, 46, 14);
		contentPane.add(lblProgressBar);*/

		JProgressBar progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(28, 69, 135));
		progressBar.setValue(40);
		progressBar.setOpaque(false);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setBounds(656, 240, 78, 160);
		contentPane.add(progressBar);
		
//******************************** BOTÓ MENÚ RANKING ********************************
		JButton btnEstats = new JButton("Ranking");
		btnEstats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vRanking vk = new vRanking();
				vk.setVisible(true);
				dispose();
			}
		});
		btnEstats.setForeground(Color.WHITE);
		btnEstats.setOpaque(false);
		btnEstats.setContentAreaFilled(false);
		btnEstats.setBorderPainted(false);
		btnEstats.setIconTextGap(15);
		try {
			Image imgIdent = ImageIO.read(getClass().getResource("/img/Ranking2.png"));
			btnEstats.setIcon(new ImageIcon(imgIdent));
		} catch (IOException ex) {
		}
		btnEstats.setFont(new Font("Verdana", Font.BOLD, 14));
		btnEstats.setBounds(259, 406, 228, 70);
		contentPane.add(btnEstats);
		
//******************************** BOTÓ NUEVA ********************************
		
		JButton btnNueva = new JButton("Nueva Partida");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   if (JOptionPane.showConfirmDialog(rootPane,"¿Estas seguro de que deseas abandonar la partida?",
			               "Salir de Lluvia de Letras", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					   vJoc vj = new vJoc();
					   vj.setVisible(true);
					   dispose();	
				   }          		  
			}
		});
		btnNueva.setForeground(Color.WHITE);
		btnNueva.setOpaque(false);
		btnNueva.setContentAreaFilled(false);
		btnNueva.setBorderPainted(false);
		btnNueva.setIconTextGap(15);
		try {
			Image imgNueva = ImageIO.read(getClass().getResource("/img/Nueva2.png"));
			btnNueva.setIcon(new ImageIcon(imgNueva));
		} catch (IOException ex) {
			}
		btnNueva.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNueva.setBounds(10, 406, 221, 70);
		contentPane.add(btnNueva);
		
//******************************** FONDO ********************************		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 750, 471);
		try {
			//Image img = ImageIO.read(getClass().getResource("/img/Menu.png"));
			Image img = ImageIO.read(getClass().getResource("/img/fondo3.png"));
			 lblFondo.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		contentPane.add(lblFondo);

	}
	
	/**
	 * 
	 * POsam les lletres a les caselles perque les vegui el jugador
	 * @param l1
	 * @param l2
	 * @param l3
	 * @param l4
	 * @param l5
	 * @param l6
	 */
	public void posarLletres (char l1,char l2,char l3,char l4,char l5,char l6){
		

		tLletra1.setText(String.valueOf(l1).toUpperCase());
		tLletra2.setText(String.valueOf(l2).toUpperCase());
		tLletra3.setText(String.valueOf(l3).toUpperCase());
		tLletra4.setText(String.valueOf(l4).toUpperCase());
		tLletra5.setText(String.valueOf(l5).toUpperCase());
		tLletra6.setText(String.valueOf(l6).toUpperCase());

	}
	
}
