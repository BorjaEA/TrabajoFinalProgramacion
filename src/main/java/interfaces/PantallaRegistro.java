package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import config.BaseDeDatos;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPasswordField;

public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	private JTextField campoNombrePersona;
	private JTextField campoEdad;
	private JTextField campoNombre;
	private JPasswordField campoContraseña;
	
	public PantallaRegistro(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Informacion Personal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel nombreDeUsuario = new JLabel("Nombre de usuario");
		GridBagConstraints gbc_nombreDeUsuario = new GridBagConstraints();
		gbc_nombreDeUsuario.anchor = GridBagConstraints.EAST;
		gbc_nombreDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_nombreDeUsuario.gridx = 1;
		gbc_nombreDeUsuario.gridy = 2;
		add(nombreDeUsuario, gbc_nombreDeUsuario);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel contraseñaDelUsuario = new JLabel("Contraseña");
		GridBagConstraints gbc_contraseñaDelUsuario = new GridBagConstraints();
		gbc_contraseñaDelUsuario.anchor = GridBagConstraints.EAST;
		gbc_contraseñaDelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_contraseñaDelUsuario.gridx = 1;
		gbc_contraseñaDelUsuario.gridy = 3;
		add(contraseñaDelUsuario, gbc_contraseñaDelUsuario);
		
		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.gridx = 2;
		gbc_campoContraseña.gridy = 3;
		add(campoContraseña, gbc_campoContraseña);
		campoContraseña.setColumns(10);
		
		JLabel nombreAGuardar = new JLabel("Nombre");
		GridBagConstraints gbc_nombreAGuardar = new GridBagConstraints();
		gbc_nombreAGuardar.anchor = GridBagConstraints.EAST;
		gbc_nombreAGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_nombreAGuardar.gridx = 1;
		gbc_nombreAGuardar.gridy = 4;
		add(nombreAGuardar, gbc_nombreAGuardar);
		
		campoNombrePersona = new JTextField();
		GridBagConstraints gbc_campoNombrePersona = new GridBagConstraints();
		gbc_campoNombrePersona.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombrePersona.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombrePersona.gridx = 2;
		gbc_campoNombrePersona.gridy = 4;
		add(campoNombrePersona, gbc_campoNombrePersona);
		campoNombrePersona.setColumns(10);
		
		JLabel edadAGuardar = new JLabel("Edad");
		GridBagConstraints gbc_edadAGuardar = new GridBagConstraints();
		gbc_edadAGuardar.anchor = GridBagConstraints.EAST;
		gbc_edadAGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_edadAGuardar.gridx = 1;
		gbc_edadAGuardar.gridy = 5;
		add(edadAGuardar, gbc_edadAGuardar);
		
		campoEdad = new JTextField();
		GridBagConstraints gbc_campoEdad = new GridBagConstraints();
		gbc_campoEdad.insets = new Insets(0, 0, 5, 5);
		gbc_campoEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEdad.gridx = 2;
		gbc_campoEdad.gridy = 5;
		add(campoEdad, gbc_campoEdad);
		campoEdad.setColumns(10);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> datosAIntroducir = new ArrayList<String>();
						
				datosAIntroducir.add(campoNombre.getText().toString());
				datosAIntroducir.add(campoContraseña.getText().toString());
				datosAIntroducir.add(campoNombrePersona.getText().toString());
				datosAIntroducir.add(campoEdad.getText().toString());
				
				
				BaseDeDatos.insertar("usuario", datosAIntroducir);
			}
		});
		GridBagConstraints gbc_botonGuardar = new GridBagConstraints();
		gbc_botonGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_botonGuardar.gridx = 2;
		gbc_botonGuardar.gridy = 6;
		add(botonGuardar, gbc_botonGuardar);
		
		JButton volverALogin = new JButton("Volver a pagina de login");
		volverALogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		GridBagConstraints gbc_volverALogin = new GridBagConstraints();
		gbc_volverALogin.insets = new Insets(0, 0, 5, 5);
		gbc_volverALogin.gridx = 2;
		gbc_volverALogin.gridy = 7;
		add(volverALogin, gbc_volverALogin);
	}

	
}
