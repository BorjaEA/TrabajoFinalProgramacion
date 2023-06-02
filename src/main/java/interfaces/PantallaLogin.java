package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import config.BaseDeDatos;
import config.Usuario;
import excepciones.NoExisteUsuarioException;
import excepciones.NoSeEncuentraSave;
import mapa.Mapa;
import partida.Partida;

import javax.swing.UIManager;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JTextField campoContraseña;
	private JTextField campoNombre;

	public PantallaLogin(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 73, 156, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 49, 30, 30, 34, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		JButton botonIniciarSesion = new JButton(
				"Iniciar Sesion y cargar partida si esta guardada en la base de datos");
		botonIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// if (BaseDeDatos.comprobarUsuario(campoNombre.getText().toString()) &&
				// BaseDeDatos.comprobarContraseña(campoNombre.getText().toString(),
				// campoContraseña.getText().toString())) {
				try {
					if (BaseDeDatos.existeUsuario(campoNombre.getText().toString(),
							campoContraseña.getText().toString())) {
						JOptionPane.showMessageDialog(null, "Se ha iniciado sesion con exito", "DepthsOfDespair",
								JOptionPane.INFORMATION_MESSAGE);
						Usuario u = new Usuario(campoNombre.getText().toString(), campoNombre.getText().toString());
						Partida p = cargarPartidaOnlineOLocar(u);
						u.insertarPartida(p);
						ventana.cambiarAPantallaconUsuario(PantallaJuego.class, p, u);
					} else {
						JOptionPane.showMessageDialog(null,
								"Hubo un problema al iniciar sesion \nNombre de usuario o contraseña incorrecta",
								"DepthsOfDespair", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (HeadlessException e1) {

					e1.printStackTrace();
				} catch (NoExisteUsuarioException e1) {

					JOptionPane.showMessageDialog(null, e1, "DepthsOfDespair", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		GridBagConstraints gbc_botonIniciarSesion = new GridBagConstraints();
		gbc_botonIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_botonIniciarSesion.gridx = 3;
		gbc_botonIniciarSesion.gridy = 4;
		add(botonIniciarSesion, gbc_botonIniciarSesion);

		JButton pruebaBoton = new JButton("Atras");
		pruebaBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaElegirLoginORegistrarse.class);
			}
		});

		JButton botonIrARegistro = new JButton("Ir a pagina de registro");
		botonIrARegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});

		JButton iniciarSesion2 = new JButton("Iniciar sesion y crear nueva partida");
		iniciarSesion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (BaseDeDatos.existeUsuario(campoNombre.getText().toString(),
							campoContraseña.getText().toString())) {
						JOptionPane.showMessageDialog(null, "Se ha iniciado sesion con exito", "DepthsOfDespair",
								JOptionPane.INFORMATION_MESSAGE);
						ventana.cambiarAPantalla(PantallaJuego.class);
					} else {
						JOptionPane.showMessageDialog(null,
								"Hubo un problema al iniciar sesion \nNombre de usuario o contraseña incorrecta",
								"DepthsOfDespair", JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (HeadlessException e1) {

					e1.printStackTrace();
				} catch (NoExisteUsuarioException e1) {
					JOptionPane.showMessageDialog(null, e1, "DepthsOfDespair", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		GridBagConstraints gbc_iniciarSesion2 = new GridBagConstraints();
		gbc_iniciarSesion2.insets = new Insets(0, 0, 5, 5);
		gbc_iniciarSesion2.gridx = 3;
		gbc_iniciarSesion2.gridy = 5;
		add(iniciarSesion2, gbc_iniciarSesion2);
		GridBagConstraints gbc_botonIrARegistro = new GridBagConstraints();
		gbc_botonIrARegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonIrARegistro.gridx = 3;
		gbc_botonIrARegistro.gridy = 6;
		add(botonIrARegistro, gbc_botonIrARegistro);
		GridBagConstraints gbc_pruebaBoton = new GridBagConstraints();
		gbc_pruebaBoton.insets = new Insets(0, 0, 5, 5);
		gbc_pruebaBoton.gridx = 3;
		gbc_pruebaBoton.gridy = 7;
		add(pruebaBoton, gbc_pruebaBoton);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);
	}

	private Partida cargarPartidaOnlineOLocar(Usuario u) {
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
