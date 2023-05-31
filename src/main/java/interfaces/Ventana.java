package interfaces;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	static Font fuente;
	static BufferedImage img = null;
	public static BufferedImage fondo;
	
	public Ventana() {
		
		if(Ventana.fondo == null) {
			try {
				Ventana.fondo = ImageIO.read(new File("./src/main/java/imagenes/desktop-1920x1080.jpg"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try{
	        // load a custom font in your project folder
			fuente = Font.createFont(Font.TRUETYPE_FONT, new File("./light-pixel-7.regular.ttf")).deriveFont(45f);		
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./light-pixel-7.regular.ttf")));			
		}catch(IOException | FontFormatException e){
			e.printStackTrace();
		}
		
		
		if(img == null) {
			try {
				URL url = PantallaInicio.class.getResource("/imagenes/Depths of Despair centrado y grande.png");
			    img = ImageIO.read(url);
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
		
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1400,800);
		this.setResizable(true);
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
		}else if(destino.equals(PantallaNuevaPartida.class)) {
			this.setContentPane(new PantallaNuevaPartida(this));
		}else if(destino.equals(PantallaElegirLoginORegistrarse.class)) {
			this.setContentPane(new PantallaElegirLoginORegistrarse(this));
		}
		
		
		
		
		
		this.getContentPane().setVisible(true);
	}

}
