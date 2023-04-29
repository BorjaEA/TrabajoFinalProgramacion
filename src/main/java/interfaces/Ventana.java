package interfaces;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	public Ventana() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200,700);
		this.setResizable(false);
		this.setContentPane(new PantallaInicio(this));

		this.setTitle("Work In Progress");
		this.setVisible(true);
	}
	
	public void cambiarAPantalla(Class<?> destino) {
		this.getContentPane().setVisible(false);
		
		if(destino.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}else if(destino.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}else if(destino.equals(PantallaInicio.class)) {
			this.setContentPane(new PantallaInicio(this));
		}
		
		
		
		
		
		this.getContentPane().setVisible(true);
	}

}
