package interfaces;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.border.LineBorder;


import java.awt.Color;
import java.awt.Font;



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
		setBackground ( new Color ( 50, 0, 20, 128 ) );
//		UIManager.put("Button.background", Color.TRANSLUCENT);
		
		
		GridBagConstraints gbc_logo = new GridBagConstraints();
		gbc_logo.insets = new Insets(0, 0, 5, 5);
		gbc_logo.gridx = 1;
		gbc_logo.gridy = 2;
		
		JLabel lblNewLabel = new JLabel("");
		//
		BufferedImage img = null;
		try {
			URL url = PantallaInicio.class.getResource("/imagenes/Depths of Despair centrado y grande.png");
		    img = ImageIO.read(url);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(450, 300,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblNewLabel.setIcon(imageIcon);
//		PantallaInicio.class.getResource("/imagenes/Depths of Despair.png");
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton JugarLocal = new JButton("Jugar en Local");
		JugarLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JugarLocal.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		GridBagConstraints gbc_JugarLocal = new GridBagConstraints();
		gbc_JugarLocal.insets = new Insets(0, 0, 5, 0);
		gbc_JugarLocal.gridx = 0;
		gbc_JugarLocal.gridy = 2;
		add(JugarLocal, gbc_JugarLocal);
		
		JButton JugarOnline = new JButton("Jugar en Linea");
		JugarOnline.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		GridBagConstraints gbc_JugarOnline = new GridBagConstraints();
		gbc_JugarOnline.insets = new Insets(0, 0, 5, 0);
		gbc_JugarOnline.gridx = 0;
		gbc_JugarOnline.gridy = 3;
		add(JugarOnline, gbc_JugarOnline);
		
		
		

		
		
	}
}
