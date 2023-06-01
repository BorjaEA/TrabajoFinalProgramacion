package interfaces;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import partida.Partida;

public class PantallaPelea extends JPanel{
	
	private Ventana ventana;
	private Partida partida;
	
	public PantallaPelea(Ventana ventana, Partida partida) {
		this.ventana = ventana;
		this.partida = partida;
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(Ventana.fondo, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);
	}

}
