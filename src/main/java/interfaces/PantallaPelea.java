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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPelea extends JPanel{
	
	private Ventana ventana;
	private Partida partida;
	
	public PantallaPelea(Ventana v, Partida partida, Enemigo e) {
		this.ventana = v;
		this.partida = partida;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextArea jugador = new JTextArea();
		jugador.setText(partida.personaje.toString2LaSecuela());
		GridBagConstraints gbc_jugador = new GridBagConstraints();
		gbc_jugador.fill = GridBagConstraints.HORIZONTAL;
		gbc_jugador.insets = new Insets(0, 0, 5, 5);
		gbc_jugador.gridx = 1;
		gbc_jugador.gridy = 1;
		add(jugador, gbc_jugador);
		
		JTextArea textoEmigo = new JTextArea();
		textoEmigo.setText(e.toString2LaSecuela());
		GridBagConstraints gbc_textoEmigo = new GridBagConstraints();
		gbc_textoEmigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoEmigo.insets = new Insets(0, 0, 5, 5);
		gbc_textoEmigo.gridx = 5;
		gbc_textoEmigo.gridy = 1;
		add(textoEmigo, gbc_textoEmigo);
		
		JButton Atacar = new JButton("Atacar");
		
		Atacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pelear();
				jugador.setText(partida.personaje.toString2LaSecuela());
				textoEmigo.setText(partida.mapa.mapa[partida.personaje.getPosicionX()][partida.personaje.getPosicionY()].getEnemigo().toString2LaSecuela());
			}
		});
		GridBagConstraints gbc_Atacar = new GridBagConstraints();
		gbc_Atacar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Atacar.insets = new Insets(0, 0, 5, 5);
		gbc_Atacar.gridx = 1;
		gbc_Atacar.gridy = 2;
		add(Atacar, gbc_Atacar);
		
		JButton Huir = new JButton("Huir");
		Huir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaJuego.class, partida, null);
			}
		});
		GridBagConstraints gbc_Huir = new GridBagConstraints();
		gbc_Huir.fill = GridBagConstraints.HORIZONTAL;
		gbc_Huir.insets = new Insets(0, 0, 5, 5);
		gbc_Huir.gridx = 5;
		gbc_Huir.gridy = 2;
		add(Huir, gbc_Huir);
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);
	}
	
	private void pelear() {
		Enemigo tmp = partida.mapa.mapa[partida.personaje.getPosicionX()][partida.personaje.getPosicionY()].getEnemigo();
		partida.mapa.mapa[partida.personaje.getPosicionX()][partida.personaje.getPosicionY()].getEnemigo().setVidaActual(tmp.getVidaActual()-partida.personaje.getAtaque());
		partida.personaje.setVidaActual(partida.personaje.getVidaActual() - tmp.getAtaque());
	}
}
