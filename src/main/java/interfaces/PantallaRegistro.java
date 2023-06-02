package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import config.BaseDeDatos;
import config.Usuario;
import excepciones.NoSeEncuentraSave;
import mapa.Mapa;
import partida.Partida;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	private JTextField campoNombre;
	private JPasswordField campoContraseña;
	
	public PantallaRegistro(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Informacion Personal");
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel nombreDeUsuario = new JLabel("Nombre de usuario");
		nombreDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreDeUsuario.setForeground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_nombreDeUsuario = new GridBagConstraints();
		gbc_nombreDeUsuario.anchor = GridBagConstraints.EAST;
		gbc_nombreDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_nombreDeUsuario.gridx = 2;
		gbc_nombreDeUsuario.gridy = 2;
		add(nombreDeUsuario, gbc_nombreDeUsuario);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel contraseñaDelUsuario = new JLabel("Contraseña");
		contraseñaDelUsuario.setForeground(UIManager.getColor("Button.background"));
		contraseñaDelUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_contraseñaDelUsuario = new GridBagConstraints();
		gbc_contraseñaDelUsuario.anchor = GridBagConstraints.EAST;
		gbc_contraseñaDelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_contraseñaDelUsuario.gridx = 2;
		gbc_contraseñaDelUsuario.gridy = 3;
		add(contraseñaDelUsuario, gbc_contraseñaDelUsuario);
		
		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.gridx = 3;
		gbc_campoContraseña.gridy = 3;
		add(campoContraseña, gbc_campoContraseña);
		campoContraseña.setColumns(10);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> datosAIntroducir = new ArrayList<String>();
				
				
				if (!BaseDeDatos.comprobarUsuario(campoNombre.getText().toString())) {
					Usuario u = null;
					JOptionPane.showMessageDialog(null, "Se ha Creado usuario con exito", "DepthsOfDespair",JOptionPane.INFORMATION_MESSAGE);
					Partida p = cargarPartidaOnlineOLocar(u, false);
					p.guardarAArchivo();
					u = new Usuario(campoNombre.getText().toString(), campoContraseña.getText().toString());
					u.insertarPartida(p);
					ventana.cambiarAPantallaconUsuario(PantallaJuego.class, p, u);

					
					ventana.cambiarAPantalla(PantallaJuego.class);
					
				}else {
					JOptionPane.showMessageDialog(null, "Hubo un problema al crear el usuario \nEl usuario ya existe", "DepthsOfDespair", JOptionPane.INFORMATION_MESSAGE);
				}

				
				
				
			}
		});
		GridBagConstraints gbc_botonGuardar = new GridBagConstraints();
		gbc_botonGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_botonGuardar.gridx = 3;
		gbc_botonGuardar.gridy = 4;
		add(botonGuardar, gbc_botonGuardar);
		
		JButton volverALogin = new JButton("Atras");
		volverALogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaElegirLoginORegistrarse.class);
			}
		});
		GridBagConstraints gbc_volverALogin = new GridBagConstraints();
		gbc_volverALogin.insets = new Insets(0, 0, 5, 5);
		gbc_volverALogin.gridx = 3;
		gbc_volverALogin.gridy = 5;
		add(volverALogin, gbc_volverALogin);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(),this.getHeight(), new Color(0,0,0),null);
	}
	private Partida cargarPartidaOnlineOLocar(Usuario u, boolean opcion) {
		if (!opcion) {
			char[][] a = mapa.Funciones.crearNivel(20, 50);
			Mapa mapa = new Mapa(a);
			Partida p = new Partida(mapa);

			return p;
		}
		String query = "select partidaguardada.partida from partidaguardada inner join usuario_partidaguardada where id_usuario = '";
		query += u.getNombre();
		query += "' and partidaguardada.id = id_partidaGuardada;";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(BaseDeDatos.cadenaConexion, BaseDeDatos.usuarioBD, BaseDeDatos.passBD);

			ResultSet rs = BaseDeDatos.consultar(conn, query);
			if (rs.next()) {
				String primerElemento = rs.getString(1);
				Partida.guardarAArchivo("./Partidas guardadas/tmp.txt", primerElemento);
				Partida p = new Partida("./Partidas guardadas/tmp.txt");
				conn.close(); // Cerrar la conexión antes de devolver el resultado
				return p;
			} else {
				try {
					BaseDeDatos.comprobarSiExisteSave();
					Partida p = new Partida();
					conn.close(); // Cerrar la conexión antes de devolver el resultado
					return p;
				} catch (NoSeEncuentraSave e) {
					char[][] a = mapa.Funciones.crearNivel(20, 50);
					Mapa mapa = new Mapa(a);
					Partida p = new Partida(mapa);
					conn.close(); // Cerrar la conexión antes de devolver el resultado
					return p;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close(); // Cerrar la conexión en caso de excepción
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
}
