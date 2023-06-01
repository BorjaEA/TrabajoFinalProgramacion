package interfaces;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.border.LineBorder;

import config.BaseDeDatos;
import excepciones.NoSeEncuentraSave;
import partida.Partida;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class PantallaInicio extends JPanel{
	private Ventana ventana;
	

	


	
	public PantallaInicio(Ventana v) {
		this.ventana=v;
		
		

		
		setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{950, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setBackground ( SystemColor.window );

		
		
		GridBagConstraints gbc_logo = new GridBagConstraints();
		gbc_logo.insets = new Insets(0, 0, 5, 5);
		gbc_logo.gridx = 1;
		gbc_logo.gridy = 2;
		
		JLabel lblNewLabel = new JLabel("");

		
		Image dimg = ventana.img.getScaledInstance(450 + this.ventana.getWidth()/10, 300 + this.ventana.getWidth()/10,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblNewLabel.setIcon(imageIcon);

		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton NuevaPartida = new JButton("<html><center><u><br>Nueva<u/><br>Partida</center></html>");
		NuevaPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaNuevaPartida.class);
			}
		});
	
		NuevaPartida.setFont(ventana.fuente);
		NuevaPartida.setForeground(new Color(139,0,0));
		GridBagConstraints gbc_NuevaPartida = new GridBagConstraints();
		gbc_NuevaPartida.insets = new Insets(0, 0, 5, 0);
		gbc_NuevaPartida.gridx = 0;
		gbc_NuevaPartida.gridy = 2;
		add(NuevaPartida, gbc_NuevaPartida);
		
		NuevaPartida.setOpaque(false);
		NuevaPartida.setContentAreaFilled(false);
		NuevaPartida.setBorderPainted(false);
		NuevaPartida.setFocusPainted(false);
		
		JButton ContinuarPartida = new JButton("<html><center><u><br>Continuar<u/><br>Partida</center></html>");
		ContinuarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					BaseDeDatos.comprobarSiExisteSave();

					Partida p = new Partida();
					
					ventana.cambiarAPantalla(PantallaJuego.class, p);

				} catch (NoSeEncuentraSave e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "DepthsOfDespair", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				
			}
		});
		ContinuarPartida.setFont(Ventana.fuente);
		ContinuarPartida.setForeground(new Color(139,0,0));
		GridBagConstraints gbc_ContinuarPartida = new GridBagConstraints();
		gbc_ContinuarPartida.insets = new Insets(0, 0, 5, 0);
		gbc_ContinuarPartida.gridx = 0;
		gbc_ContinuarPartida.gridy = 3;
		add(ContinuarPartida, gbc_ContinuarPartida);
		
		ContinuarPartida.setOpaque(false);
		ContinuarPartida.setContentAreaFilled(false);
		ContinuarPartida.setBorderPainted(false);
		ContinuarPartida.setFocusPainted(false);
		

		
		JButton Salir = new JButton("<html><u><br>Salir<u/><html/>");
		Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		Salir.setFont(Ventana.fuente);
		Salir.setForeground(new Color(139,0,0));
		GridBagConstraints gbc_Salir = new GridBagConstraints();
		gbc_Salir.insets = new Insets(0, 0, 5, 0);
		gbc_Salir.gridx = 0;
		gbc_Salir.gridy = 4;
		add(Salir, gbc_Salir);
		
		Salir.setOpaque(false);
		Salir.setContentAreaFilled(false);
		Salir.setBorderPainted(false);
		Salir.setFocusPainted(false);
		
		
		
		
		

		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(),this.getHeight(), new Color(0,0,0),null);
	}
	
}
