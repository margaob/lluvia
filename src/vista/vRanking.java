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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class vRanking extends JFrame {

	private JPanel contentPane;
	private JTable rank;
	private DefaultTableModel dtmR;
	private JScrollPane scrollPaneR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vRanking frame = new vRanking();
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
	public vRanking() {
		
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
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(new Font("Verdana", Font.BOLD, 36));
		lbTitulo.setBounds(10, 20, 724, 36);
		contentPane.add(lbTitulo);
		

//******************************** TABLA ********************************		
		
		dtmR = new DefaultTableModel();

		dtmR.addColumn("Usuario");
		dtmR.addColumn("Puntuaci�n");

		scrollPaneR = new JScrollPane();
		scrollPaneR.setBounds(246, 82, 251, 300);
		contentPane.add(scrollPaneR);

		rank = new JTable(dtmR);
	
        
		scrollPaneR.setViewportView(rank);
		rank.setPreferredScrollableViewportSize(new Dimension(100, 70));
		
//******************************** BOT� MEN� PRINCIPAL ********************************
		
		JButton btnMenu = new JButton("Men� principal");
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
				
//******************************** BOT� MEN� ESTADISTICAS ********************************
		JButton btnEstats = new JButton("Estadisticas");
		btnEstats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vEstadisticas ve = new vEstadisticas();
				ve.setVisible(true);
				dispose();

			}
		});
		btnEstats.setForeground(Color.WHITE);
		btnEstats.setOpaque(false);
		btnEstats.setContentAreaFilled(false);
		btnEstats.setBorderPainted(false);
		btnEstats.setIconTextGap(15);
		try {
			Image imgIdent = ImageIO.read(getClass().getResource("/img/Estats2.png"));
			btnEstats.setIcon(new ImageIcon(imgIdent));
		} catch (IOException ex) {
		}
		btnEstats.setFont(new Font("Verdana", Font.BOLD, 14));
		btnEstats.setBounds(259, 406, 228, 70);
		contentPane.add(btnEstats);
		
//******************************** BOT� NUEVA ********************************
		
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

	/**
	 * omplim la taula del ranking
	 * 
	 * @param top
	 */
  public void omplirRanking (Object [] top){
	

	  dtmR.addRow(top);

  }
	
  /**
   * borram la taula i la tornam a omplir xq no e sposim dades damunt i es dupliqui informacio
   * 
   */
  
  void ferNet(){
      int a =dtmR.getRowCount()-1;  
      
      for(int i=a;i>=0;i--){  

    	  dtmR.removeRow(i);
      }
  }
}
