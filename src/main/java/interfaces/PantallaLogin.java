package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import config.BaseDeDatos;

import javax.swing.UIManager;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField campoContraseña;
	private JTextField campoNombre;
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 73, 156, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 49, 30, 30, 34, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("Datos Personales");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		campoContraseña = new JTextField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.gridx = 3;
		gbc_campoContraseña.gridy = 3;
		add(campoContraseña, gbc_campoContraseña);
		campoContraseña.setColumns(10);
		
		JButton botonIniciarSesion = new JButton("Iniciar Sesion");
		botonIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (BaseDeDatos.comprobarUsuario(campoNombre.getText().toString()) && BaseDeDatos.comprobarContraseña(campoNombre.getText().toString(), campoContraseña.getText().toString())) {
					JOptionPane.showMessageDialog(null, "Se ha iniciado sesion con exito", "DepthsOfDespair", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaJuego.class);
				}else {
					JOptionPane.showMessageDialog(null, "Hubo un problema al iniciar sesion \nNombre de usuario o contraseña incorrecta", "DepthsOfDespair", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		GridBagConstraints gbc_botonIniciarSesion = new GridBagConstraints();
		gbc_botonIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_botonIniciarSesion.gridx = 3;
		gbc_botonIniciarSesion.gridy = 4;
		add(botonIniciarSesion, gbc_botonIniciarSesion);
		
		JButton botonIrARegistro = new JButton("Ir a pagina de registro");
		botonIrARegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		GridBagConstraints gbc_botonIrARegistro = new GridBagConstraints();
		gbc_botonIrARegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonIrARegistro.gridx = 3;
		gbc_botonIrARegistro.gridy = 5;
		add(botonIrARegistro, gbc_botonIrARegistro);
		
		JButton pruebaBoton = new JButton("Atras");
		pruebaBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaElegirLoginORegistrarse.class);
			}
		});
		GridBagConstraints gbc_pruebaBoton = new GridBagConstraints();
		gbc_pruebaBoton.insets = new Insets(0, 0, 5, 5);
		gbc_pruebaBoton.gridx = 3;
		gbc_pruebaBoton.gridy = 6;
		add(pruebaBoton, gbc_pruebaBoton);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(),this.getHeight(), new Color(0,0,0),null);
	}

}
