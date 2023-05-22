package objetos;

public class Equipamiento extends Objeto{
	protected int fuerza, inteligencia, destreza;
	

	public Equipamiento(short piso, String nombre, int fuerza, int inteligencia, int destreza) {
		super(piso, nombre);
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.destreza = destreza;
	}
	
	
	public Equipamiento() {
		
	}
	

	public int getFuerza() {
		return fuerza;
	}


	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}


	public int getInteligencia() {
		return inteligencia;
	}


	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}


	public int getDestreza() {
		return destreza;
	}


	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

}
