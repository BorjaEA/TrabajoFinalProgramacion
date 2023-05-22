package objetos;

import java.util.Random;

public class Objeto {
	private Random ran = new Random();
	protected float valor = ran.nextInt(1,10);
	protected String nombre;
	
	
	public Objeto(short piso, String nombre) {
		this.valor = (float) (valor + Math.pow(1.2, piso));
		this.nombre = nombre;
	}

	public Objeto() {
		
	}
	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Objeto [valor=" + valor + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
