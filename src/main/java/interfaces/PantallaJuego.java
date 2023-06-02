package interfaces;

import javax.swing.JPanel;

import partida.Partida;
import personaje.Enemigo;
import personaje.Personaje;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

import config.BaseDeDatos;
import excepciones.NoSeEncuentraSave;
import mapa.Mapa;

public class PantallaJuego extends JPanel {
	private Ventana ventana;
	private Partida partida;
	public static int aux = 0;

	public PantallaJuego(Ventana ventana) {
		this.ventana = ventana;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		char[][] a = mapa.Funciones.crearNivel(20, 50);
		Mapa mapa = new Mapa(a);

		partida = new Partida(mapa);

		partida.guardarAArchivo();

		JTextPane textPane = new JTextPane();
		textPane.setForeground(Color.DARK_GRAY);
		// textPane.setFont( new Font("monospaced", Font.PLAIN, 11) );
		textPane.setText(partida.devolverMapa());
		textPane.setEditable(false);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.gridx = 2;
		gbc_textPane.gridy = 1;
		add(textPane, gbc_textPane);

		JButton botonArriba = new JButton("⬆");
		botonArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aux = 0;
				partida = Partida.moverJugador(0, partida);
				textPane.setText(partida.devolverMapa());
				cambiarVentanaSegunCaracter(aux);
			}
		});
		GridBagConstraints gbc_botonArriba = new GridBagConstraints();
		gbc_botonArriba.insets = new Insets(0, 0, 5, 5);
		gbc_botonArriba.gridx = 4;
		gbc_botonArriba.gridy = 2;
		add(botonArriba, gbc_botonArriba);

		JButton Atras = new JButton("Atras");
		Atras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaInicio.class);
			}
		});

		GridBagConstraints gbc_Atras = new GridBagConstraints();
		gbc_Atras.fill = GridBagConstraints.HORIZONTAL;
		gbc_Atras.insets = new Insets(0, 0, 5, 5);
		gbc_Atras.gridx = 2;
		gbc_Atras.gridy = 3;
		add(Atras, gbc_Atras);

		JButton botonIzquierda = new JButton("⬅");
		botonIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aux = 0;
				partida = Partida.moverJugador(3, partida);
				textPane.setText(partida.devolverMapa());
				cambiarVentanaSegunCaracter(aux);
			}
		});
		GridBagConstraints gbc_botonIzquierda = new GridBagConstraints();
		gbc_botonIzquierda.insets = new Insets(0, 0, 5, 5);
		gbc_botonIzquierda.gridx = 3;
		gbc_botonIzquierda.gridy = 3;
		add(botonIzquierda, gbc_botonIzquierda);

		JButton botonAbajo = new JButton("⬇");
		botonAbajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aux = 0;
				partida = Partida.moverJugador(2, partida);
				textPane.setText(partida.devolverMapa());
				cambiarVentanaSegunCaracter(aux);
			}
		});
		GridBagConstraints gbc_botonAbajo = new GridBagConstraints();
		gbc_botonAbajo.insets = new Insets(0, 0, 5, 5);
		gbc_botonAbajo.gridx = 4;
		gbc_botonAbajo.gridy = 3;
		add(botonAbajo, gbc_botonAbajo);

		JButton botonDerecha = new JButton("➡");
		botonDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aux = 0;
				partida = Partida.moverJugador(1, partida);
				textPane.setText(partida.devolverMapa());
				cambiarVentanaSegunCaracter(aux);
			}
		});
		GridBagConstraints gbc_botonDerecha = new GridBagConstraints();
		gbc_botonDerecha.insets = new Insets(0, 0, 5, 5);
		gbc_botonDerecha.gridx = 5;
		gbc_botonDerecha.gridy = 3;
		add(botonDerecha, gbc_botonDerecha);

	}

	/**
	 * @wbp.parser.constructor
	 */
	public PantallaJuego(Ventana ventana, Partida p) {
		this.ventana = ventana;
		this.partida = p;
		

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);



		JTextPane textPane = new JTextPane();
		textPane.setForeground(Color.DARK_GRAY);
		// textPane.setFont( new Font("monospaced", Font.PLAIN, 11) );
		textPane.setText(partida.devolverMapa());
		textPane.setEditable(false);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.gridx = 2;
		gbc_textPane.gridy = 1;
		add(textPane, gbc_textPane);

		JButton botonArriba = new JButton("⬆");
		botonArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aux = 0;
				partida = Partida.moverJugador(0, partida);
				textPane.setText(partida.devolverMapa());
				cambiarVentanaSegunCaracter(aux);
			}
		});

		JButton guardarPartida = new JButton("Guardar Partida");
		
		final Partida copia = partida;
		guardarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				copia.guardarAArchivo();
			}
		});
		GridBagConstraints gbc_guardarPartida = new GridBagConstraints();
		gbc_guardarPartida.insets = new Insets(0, 0, 5, 5);
		gbc_guardarPartida.gridx = 1;
		gbc_guardarPartida.gridy = 2;
		add(guardarPartida, gbc_guardarPartida);
		GridBagConstraints gbc_botonArriba = new GridBagConstraints();
		gbc_botonArriba.insets = new Insets(0, 0, 5, 5);
		gbc_botonArriba.gridx = 4;
		gbc_botonArriba.gridy = 2;
		add(botonArriba, gbc_botonArriba);

		JButton botonIzquierda = new JButton("⬅");
		botonIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aux = 0;
				partida = Partida.moverJugador(3, partida);
				textPane.setText(partida.devolverMapa());
				cambiarVentanaSegunCaracter(aux);
			}
		});

		JButton Atras = new JButton("Atras");
		Atras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaInicio.class);
			}
		});

		GridBagConstraints gbc_Atras = new GridBagConstraints();
		gbc_Atras.insets = new Insets(0, 0, 5, 5);
		gbc_Atras.gridx = 1;
		gbc_Atras.gridy = 3;
		add(Atras, gbc_Atras);
		GridBagConstraints gbc_botonIzquierda = new GridBagConstraints();
		gbc_botonIzquierda.insets = new Insets(0, 0, 5, 5);
		gbc_botonIzquierda.gridx = 3;
		gbc_botonIzquierda.gridy = 3;
		add(botonIzquierda, gbc_botonIzquierda);

		JButton botonAbajo = new JButton("⬇");
		botonAbajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aux = 0;
				partida = Partida.moverJugador(2, partida);
				textPane.setText(partida.devolverMapa());
				cambiarVentanaSegunCaracter(aux);

			}
		});
		GridBagConstraints gbc_botonAbajo = new GridBagConstraints();
		gbc_botonAbajo.insets = new Insets(0, 0, 5, 5);
		gbc_botonAbajo.gridx = 4;
		gbc_botonAbajo.gridy = 3;
		add(botonAbajo, gbc_botonAbajo);

		JButton botonDerecha = new JButton("➡");
		botonDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aux = 0;
				partida = Partida.moverJugador(1, partida);
				textPane.setText(partida.devolverMapa());
				cambiarVentanaSegunCaracter(aux);
			}
		});
		GridBagConstraints gbc_botonDerecha = new GridBagConstraints();
		gbc_botonDerecha.insets = new Insets(0, 0, 5, 5);
		gbc_botonDerecha.gridx = 5;
		gbc_botonDerecha.gridy = 3;
		add(botonDerecha, gbc_botonDerecha);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);
	}
	
	private void cambiarVentanaSegunCaracter(int aux) {
		if(aux == 1) {
			Enemigo e = partida.mapa.mapa[partida.personaje.getPosicionX()][partida.personaje.getPosicionY()].getEnemigo();

			ventana.cambiarAPantalla( PantallaPelea.class, partida, e);
		}
	}

}
