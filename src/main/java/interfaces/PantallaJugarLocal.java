package interfaces;

import javax.swing.JPanel;
import java.awt.Color;

public class PantallaJugarLocal extends JPanel{
	private Ventana ventana;
	public PantallaJugarLocal(Ventana v) {
		setBackground(new Color ( 50, 0, 20, 128 ) );
		this.ventana=v;
		
	}
}
