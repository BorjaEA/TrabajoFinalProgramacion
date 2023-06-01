package interfaces;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import partida.Partida;
import personaje.Enemigo;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaPelea extends JPanel{
	
	private Ventana ventana;
	private Partida partida;
	
	public PantallaPelea(Ventana ventana, Partida partida, Enemigo enemigo) {
		this.ventana = ventana;
		this.partida = partida;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextArea jugador = new JTextArea();
		jugador.setText(partida.personaje.toString2LaSecuela());
		GridBagConstraints gbc_jugador = new GridBagConstraints();
		gbc_jugador.insets = new Insets(0, 0, 5, 5);
		gbc_jugador.gridx = 1;
		gbc_jugador.gridy = 1;
		add(jugador, gbc_jugador);
		
		JTextArea textoEmigo = new JTextArea();
		//textoEmigo.setText(enemigo.toString());
		GridBagConstraints gbc_textoEmigo = new GridBagConstraints();
		gbc_textoEmigo.insets = new Insets(0, 0, 5, 5);
		gbc_textoEmigo.gridx = 4;
		gbc_textoEmigo.gridy = 1;
		add(textoEmigo, gbc_textoEmigo);
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);
	}

}
