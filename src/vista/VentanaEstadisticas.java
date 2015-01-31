package vista;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
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
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import controlador.Controlador;

import java.awt.Label;

public class VentanaEstadisticas extends JFrame {

	private JPanel contentPane;
	
	private Controlador miCoordinador;


	public VentanaEstadisticas() {

		setResizable(false);
		setTitle("Lluvia de letras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);



		// ******************************** TITULO ********************************

		JLabel lbTitulo = new JLabel("L L U V I A   D E   L E T R A S");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(new Font("Verdana", Font.BOLD, 36));
		lbTitulo.setBounds(10, 20, 724, 36);
		contentPane.add(lbTitulo);

		// *********************** ESTADISTICAS ************************************
		JLabel lblLblmejor = new JLabel("MEJOR PARTIDA:");
		lblLblmejor.setForeground(Color.WHITE);
		lblLblmejor.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLblmejor.setBounds(46, 110, 314, 14);
		contentPane.add(lblLblmejor);

		JLabel lblPeor = new JLabel("PEOR PARTIDA:");
		lblPeor.setForeground(Color.WHITE);
		lblPeor.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPeor.setBounds(46, 242, 314, 14);
		contentPane.add(lblPeor);

		JLabel lblmPuntuacion = new JLabel("Puntuaci\u00F3n:");
		lblmPuntuacion.setForeground(Color.WHITE);
		lblmPuntuacion.setFont(new Font("Verdana", Font.BOLD, 12));
		lblmPuntuacion.setBounds(63, 150, 119, 14);
		contentPane.add(lblmPuntuacion);

		JLabel lblmPorcentaje = new JLabel("% palabras:");
		lblmPorcentaje.setForeground(Color.WHITE);
		lblmPorcentaje.setFont(new Font("Verdana", Font.BOLD, 12));
		lblmPorcentaje.setBounds(63, 194, 197, 14);
		contentPane.add(lblmPorcentaje);

		JLabel lblpPuntuacion = new JLabel("Puntuación:");
		lblpPuntuacion.setForeground(Color.WHITE);
		lblpPuntuacion.setFont(new Font("Verdana", Font.BOLD, 12));
		lblpPuntuacion.setBounds(63, 289, 197, 14);
		contentPane.add(lblpPuntuacion);

		JLabel lblpPorcentaje = new JLabel("% Palabras:");
		lblpPorcentaje.setForeground(Color.WHITE);
		lblpPorcentaje.setFont(new Font("Verdana", Font.BOLD, 12));
		lblpPorcentaje.setBounds(61, 334, 212, 14);
		contentPane.add(lblpPorcentaje);

		JLabel mPuntuacion = new JLabel("600");
		mPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		mPuntuacion.setForeground(Color.WHITE);
		mPuntuacion.setFont(new Font("Verdana", Font.BOLD, 12));
		mPuntuacion.setBounds(279, 150, 70, 14);
		contentPane.add(mPuntuacion);

		JLabel mPorcentaje = new JLabel("80");
		mPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		mPorcentaje.setForeground(Color.WHITE);
		mPorcentaje.setFont(new Font("Verdana", Font.BOLD, 12));
		mPorcentaje.setBounds(279, 194, 70, 14);
		contentPane.add(mPorcentaje);

		JLabel pPuntuacion = new JLabel("150");
		pPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		pPuntuacion.setForeground(Color.WHITE);
		pPuntuacion.setFont(new Font("Verdana", Font.BOLD, 12));
		pPuntuacion.setBounds(279, 289, 70, 14);
		contentPane.add(pPuntuacion);

		JLabel pPorcentaje = new JLabel("15");
		pPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		pPorcentaje.setForeground(Color.WHITE);
		pPorcentaje.setFont(new Font("Verdana", Font.BOLD, 12));
		pPorcentaje.setBounds(279, 334, 70, 14);
		contentPane.add(pPorcentaje);
		
		int punts = 325;
		JLabel lblPuntMedia = new JLabel("Puntuación media : "+ punts);
		lblPuntMedia.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntMedia.setBounds(378, 323, 336, 50);
		lblPuntMedia.setForeground(Color.WHITE);
		lblPuntMedia.setFont(new Font("Verdana", Font.BOLD, 12));
		contentPane.add(lblPuntMedia);

		// ************************ GRAFICA ******************************************************

		JPanel panelLinea = new JPanel();
		panelLinea.setBounds(377, 95, 336, 225);
		panelLinea.setOpaque(false);

		contentPane.add(panelLinea);

		JLabel lblLinea = new JLabel("");
		lblLinea.setBounds(377, 95, 336, 225);
		lblLinea.setOpaque(false);
		panelLinea.add(lblLinea);
		
		XYSeries series = null;
		XYDataset datos;
		JFreeChart linea = null;
		int x = 1;

		series = new XYSeries("");

		series.add(x, 85);
		x++;
		series.add(x, 20);
		x++;
		series.add(x, 550);
		x++;
		series.add(x, 150);
		x++;
		series.add(x, 150);
		x++;
		series.add(x, 85);
		x++;
		series.add(x, 20);
		x++;
		series.add(x, 550);
		x++;
		series.add(x, 150);
		x++;
		series.add(x, 1150);
		x++;
		
		datos = new XYSeriesCollection(series);

		
		linea = ChartFactory.createXYLineChart("", "", "", datos,
				PlotOrientation.VERTICAL, false, true, true);
		
		
	

		// personalización del grafico
		XYPlot xyplot = (XYPlot) linea.getPlot();
		xyplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		

		Color fondo = new Color (159, 197, 232);
		
		xyplot.setBackgroundPaint(fondo);
		xyplot.setDomainGridlinePaint(Color.BLACK);
		xyplot.setRangeGridlinePaint(Color.BLACK);
		xyplot.setNoDataMessage("No has jugado todavia, y no hay datos para mostrar!!");
		xyplot.getRendererForDataset(xyplot.getDataset(0)).setSeriesPaint(0,
				Color.white);
		// -> Pinta Shapes en los puntos dados por el XYDataset
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot
				.getRenderer();
		xylineandshaperenderer.setBaseShapesVisible(true);
		// --> muestra los valores de cada punto XY
		// XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
		// xylineandshaperenderer.setBaseItemLabelGenerator( xy );
		// xylineandshaperenderer.setBaseItemLabelsVisible(true);
		xylineandshaperenderer.setBaseLinesVisible(true);
		xylineandshaperenderer.setBaseItemLabelsVisible(true);
		// fin de personalización

		BufferedImage graficoLinea = linea.createBufferedImage(
				panelLinea.getWidth(), panelLinea.getHeight());
		
		

		lblLinea.setSize(panelLinea.getSize());
		lblLinea.setIcon(new ImageIcon(graficoLinea));

		panelLinea.updateUI();
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
		btnMenu.setIconTextGap(15);
		try {
			Image imgIdent = ImageIO.read(getClass().getResource(
					"/img/Menu2.png"));
			btnMenu.setIcon(new ImageIcon(imgIdent));
		} catch (IOException ex) {
		}

		btnMenu.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMenu.setBounds(484, 406, 228, 70);
		contentPane.add(btnMenu);

		// ******************************** BOTÓ MENÚ RANKING ********************************
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			miCoordinador.mostrarVentanaRanking();
			dispose();
			}
		});
		btnRanking.setForeground(Color.WHITE);
		btnRanking.setOpaque(false);
		btnRanking.setContentAreaFilled(false);
		btnRanking.setBorderPainted(false);
		btnRanking.setIconTextGap(15);
		try {
			Image imgIdent = ImageIO.read(getClass().getResource(
					"/img/Ranking2.png"));
			btnRanking.setIcon(new ImageIcon(imgIdent));
		} catch (IOException ex) {
		}
		btnRanking.setFont(new Font("Verdana", Font.BOLD, 14));
		btnRanking.setBounds(259, 406, 228, 70);
		contentPane.add(btnRanking);

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
		btnNueva.setBounds(10, 406, 221, 70);
		contentPane.add(btnNueva);

		// ******************************** FONDO ********************************

		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, -10, 750, 500);
		try {
			// Image img =
			// ImageIO.read(getClass().getResource("/img/Menu.png"));
			Image img = ImageIO.read(getClass().getResource("/img/fondo4.png"));
			lblFondo.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

		contentPane.add(lblFondo);

	}
	
	public void setCoordinador(Controlador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
}
