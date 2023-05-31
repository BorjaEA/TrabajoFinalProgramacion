package interfaces;

import javax.swing.JPanel;

import partida.Partida;
import personaje.Personaje;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

import mapa.Mapa;

public class PantallaJuego extends JPanel {
	private Ventana ventana;
	private Partida partida;

	public PantallaJuego(Ventana ventana) {
		this.ventana = ventana;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		char[][] a = mapa.Funciones.crearNivel(20, 50);
		Mapa mapa = new Mapa(a);

		Personaje p = new Personaje(0, 0);

		partida = new Partida(p, mapa);

		partida.guardarAArchivo();

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 1;
		add(textPane, gbc_textPane);

		JButton Atras = new JButton("Atras");
		Atras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaInicio.class);
			}
		});

		JButton Cargar = new JButton("Cargar partida");

		GridBagConstraints gbc_Cargar = new GridBagConstraints();
		gbc_Cargar.insets = new Insets(0, 0, 5, 5);
		gbc_Cargar.gridx = 2;
		gbc_Cargar.gridy = 1;
		add(Cargar, gbc_Cargar);

		Cargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textPane.setText(partida.devolverMapa());
			}
		});
		GridBagConstraints gbc_Atras = new GridBagConstraints();
		gbc_Atras.insets = new Insets(0, 0, 5, 5);
		gbc_Atras.gridx = 2;
		gbc_Atras.gridy = 3;
		add(Atras, gbc_Atras);

	}
}
