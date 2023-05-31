package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaElegirLoginORegistrarse extends JPanel{
	Ventana ventana;
	
	public PantallaElegirLoginORegistrarse(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton Login = new JButton("<html><center><u><br>Iniciar Sesion</center></html>");
		Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		GridBagConstraints gbc_Login = new GridBagConstraints();
		gbc_Login.insets = new Insets(0, 0, 5, 5);
		gbc_Login.gridx = 2;
		gbc_Login.gridy = 2;
		add(Login, gbc_Login);
		Login.setFont(ventana.fuente);
		Login.setForeground(new Color(139,0,0));
		
		Login.setOpaque(false);
		Login.setContentAreaFilled(false);
		Login.setBorderPainted(false);
		Login.setFocusPainted(false);
		
		JButton SignIn = new JButton("<html><center><u><br>Registrate</center></html>");
		SignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		GridBagConstraints gbc_SignIn = new GridBagConstraints();
		gbc_SignIn.insets = new Insets(0, 0, 5, 5);
		gbc_SignIn.gridx = 2;
		gbc_SignIn.gridy = 3;
		add(SignIn, gbc_SignIn);
		SignIn.setFont(ventana.fuente);
		SignIn.setForeground(new Color(139,0,0));
		
		SignIn.setOpaque(false);
		SignIn.setContentAreaFilled(false);
		SignIn.setBorderPainted(false);
		SignIn.setFocusPainted(false);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(),this.getHeight(), new Color(0,0,0),null);
	}

}
