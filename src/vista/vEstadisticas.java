package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Label;

public class vEstadisticas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vEstadisticas frame = new vEstadisticas();
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
	public vEstadisticas() {
		
		setResizable(false);
		setTitle("Lluvia de letras");
	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
				JPanel panelGraficoTorta = new JPanel();
				panelGraficoTorta.setBounds(370, 80, 350, 300);
				contentPane.add(panelGraficoTorta);
				
				JLabel lblTorta = new JLabel("");
				panelGraficoTorta.add(lblTorta);
				
				
		
		//******************************** TITULO ********************************
		
				JLabel lbTitulo = new JLabel("L L U V I A   D E   L E T R A S");
				lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lbTitulo.setForeground(Color.WHITE);
				lbTitulo.setFont(new Font("Verdana", Font.BOLD, 36));
				lbTitulo.setBounds(10, 20, 724, 36);
				contentPane.add(lbTitulo);
				
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
				
				
//************************ESTADISTICA ******************************************************
			
				// hola hola hola
				 	XYSeries series = null;
			        XYDataset datos;
			        JFreeChart linea = null;
			        int x=0;

			        series= new XYSeries("Popularidad de Blog");
			    
			        series.add(85,x);
			        x++;
			        series.add(20,x);
			        x++;
			        series.add(550,x);
			        x++;
			        series.add(150,x);
			        x++;
			        series.add(150,x);
			        x++;

		     
			        series.add(150,x);
			        x++;
			       
			        datos = new XYSeriesCollection(series);
			        linea = ChartFactory.createXYLineChart("","","",datos,PlotOrientation.HORIZONTAL,true,true,true);
			       
			        BufferedImage graficoLinea=linea.createBufferedImage(panelGraficoTorta.getWidth(), panelGraficoTorta.getHeight());
			       
			        lblTorta.setSize(panelGraficoTorta.getSize());
			        lblTorta.setIcon(new ImageIcon(graficoLinea));
			      
			        panelGraficoTorta.updateUI();
						
		//******************************** BOTÓ MENÚ RANKING ********************************
				JButton btnRanking = new JButton("Ranking");
				btnRanking.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vRanking vr = new vRanking();
						vr.setVisible(true);
						dispose();

					}
				});
				btnRanking.setForeground(Color.WHITE);
				btnRanking.setOpaque(false);
				btnRanking.setContentAreaFilled(false);
				btnRanking.setBorderPainted(false);
				btnRanking.setIconTextGap(15);
				try {
					Image imgIdent = ImageIO.read(getClass().getResource("/img/Ranking2.png"));
					btnRanking.setIcon(new ImageIcon(imgIdent));
				} catch (IOException ex) {
				}
				btnRanking.setFont(new Font("Verdana", Font.BOLD, 14));
				btnRanking.setBounds(259, 406, 228, 70);
				contentPane.add(btnRanking);
				
		//******************************** BOTÓ NUEVA ********************************
				
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
}
