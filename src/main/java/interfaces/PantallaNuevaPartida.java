package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaNuevaPartida extends JPanel {
	private Ventana ventana;
	
	public PantallaNuevaPartida(Ventana v) {
		setBackground(new Color ( 50, 0, 20, 128 ) );
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton PartidaLocal = new JButton("<html><center><u><br>Empezar partida <br>guardando en local</center></html> ");
		PartidaLocal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GridBagConstraints gbc_PartidaLocal = new GridBagConstraints();
		gbc_PartidaLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_PartidaLocal.insets = new Insets(0, 0, 5, 5);
		gbc_PartidaLocal.gridx = 1;
		gbc_PartidaLocal.gridy = 3;
		add(PartidaLocal, gbc_PartidaLocal);
		PartidaLocal.setFont(ventana.fuente);
		PartidaLocal.setForeground(new Color(139,0,0));
		
		PartidaLocal.setOpaque(false);
		PartidaLocal.setContentAreaFilled(false);
		PartidaLocal.setBorderPainted(false);
		PartidaLocal.setFocusPainted(false);
		
		
		
		JButton PartidaOnline = new JButton("<html><center><u><br>Empezar partida <br>guardando en la nube</center></html> ");
		PartidaOnline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaElegirLoginORegistrarse.class);
			}
		});
		GridBagConstraints gbc_PartidaOnline = new GridBagConstraints();
		gbc_PartidaOnline.insets = new Insets(0, 0, 5, 5);
		gbc_PartidaOnline.gridx = 1;
		gbc_PartidaOnline.gridy = 4;
		add(PartidaOnline, gbc_PartidaOnline);
		PartidaOnline.setFont(ventana.fuente);
		PartidaOnline.setForeground(new Color(139,0,0));
		
		PartidaOnline.setOpaque(false);
		PartidaOnline.setContentAreaFilled(false);
		PartidaOnline.setBorderPainted(false);
		PartidaOnline.setFocusPainted(false);
		
		
		JButton Volver = new JButton("<html><center><u><br>Atras</center></html>");
		Volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaInicio.class);
			}
		});
		Volver.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_Volver = new GridBagConstraints();
		gbc_Volver.insets = new Insets(0, 0, 5, 5);
		gbc_Volver.gridx = 1;
		gbc_Volver.gridy = 5;
		add(Volver, gbc_Volver);
		Volver.setFont(ventana.fuente);
		Volver.setForeground(new Color(139,0,0));
		
		Volver.setOpaque(false);
		Volver.setContentAreaFilled(false);
		Volver.setBorderPainted(false);
		Volver.setFocusPainted(false);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(),this.getHeight(), new Color(0,0,0),null);
	}
}
