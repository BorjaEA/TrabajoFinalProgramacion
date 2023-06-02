package personaje;

public class EntidadConAtributos {
	protected float vidaTotal;
	protected float vidaActual;
	protected float ataque;
	protected float defensa;
	protected int posicionX;
	protected int posicionY;
	
	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public float getVidaTotal() {
		return vidaTotal;
	}

	public void setVidaTotal(float vidaTotal) {
		this.vidaTotal = vidaTotal;
	}

	public float getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(float vidaActual) {
		this.vidaActual = vidaActual;
	}

	public float getAtaque() {
		return ataque;
	}

	public void setAtaque(float ataque) {
		this.ataque = ataque;
	}

	public float getDefensa() {
		return defensa;
	}

	public void setDefensa(float defensa) {
		this.defensa = defensa;
	}

	public EntidadConAtributos(int posicionX, int posicionY) {
		this.vidaTotal = 100;
		this.vidaActual = this.vidaTotal;
		this.ataque = 20;
		this.defensa= 5;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	public EntidadConAtributos() {
		
	}
	
	
}
