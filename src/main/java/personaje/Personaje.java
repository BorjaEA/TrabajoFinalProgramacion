package personaje;

public class Personaje extends EntidadConAtributos{

	private int fuerza, inteligencia, destreza;
	private int manaTotal;
	private int manaActual;
	private int regeneracionVida, regeneracionMana;
	private int nivel;
	private int exp;
	
	public Personaje(int posicionX, int posicionY) {
		super(posicionX, posicionY);
		this.fuerza = this.inteligencia = this.destreza = 1;
		this.manaTotal = 100;
		this.manaActual = manaTotal;
		this.nivel = 1;
		this.regeneracionMana = nivel;
		this.regeneracionVida = nivel;
		this.exp = 0;
	}
	
	
	public Personaje(int posicionX, int posicionY, int fuerza, int inteligencia, int destreza, int manaTotal,
			int manaActual, int regeneracionVida, int regeneracionMana, int nivel, int exp) {
		super(posicionX, posicionY);
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.destreza = destreza;
		this.manaTotal = manaTotal;
		this.manaActual = manaActual;
		this.regeneracionVida = regeneracionVida;
		this.regeneracionMana = regeneracionMana;
		this.nivel = nivel;
		this.exp = exp;
	}

	public Personaje(String datos) {
		super();
        if (datos.equals("jugador=null,")) {
            // Si el string indica que el jugador es null, se puede dejar los atributos con sus valores por defecto.
            return;
        }

        String[] atributos = datos.substring(datos.indexOf("[") + 1, datos.indexOf("]")).split(", ");

        for (String atributo : atributos) {
            String[] partes = atributo.split("=");

            String nombre = partes[0].trim();
            String valorStr = partes[1].trim();

            switch (nombre) {
                case "fuerza":
                    this.fuerza = Integer.parseInt(valorStr);
                    break;
                case "inteligencia":
                    this.inteligencia = Integer.parseInt(valorStr);
                    break;
                case "destreza":
                    this.destreza = Integer.parseInt(valorStr);
                    break;
                case "manaTotal":
                    this.manaTotal = Integer.parseInt(valorStr);
                    break;
                case "manaActual":
                    this.manaActual = Integer.parseInt(valorStr);
                    break;
                case "regeneracionVida":
                    this.regeneracionVida = Integer.parseInt(valorStr);
                    break;
                case "regeneracionMana":
                    this.regeneracionMana = Integer.parseInt(valorStr);
                    break;
                case "nivel":
                    this.nivel = Integer.parseInt(valorStr);
                    break;
                case "exp":
                    this.exp = Integer.parseInt(valorStr);
                    break;
                case "vidaTotal":
                    this.vidaTotal = Float.parseFloat(valorStr);
                    break;
                case "vidaActual":
                    this.vidaActual = Float.parseFloat(valorStr);
                    break;
                case "ataque":
                    this.ataque = Float.parseFloat(valorStr);
                    break;
                case "defensa":
                    this.defensa = Float.parseFloat(valorStr);
                    break;
                case "posicionX":
                    this.posicionX = Integer.parseInt(valorStr);
                    break;
                case "posicionY":
                    this.posicionY = Integer.parseInt(valorStr);
                    break;
                default:
                    // Ignorar atributos desconocidos
                    break;
            }
        }
        
    }

	public void subirDeNivel() {
		this.exp = 0;
		this.nivel++;
	}
	
	public void regenerarVida() {
		
		if(this.vidaActual + regeneracionVida > this.vidaTotal ) {
			this.vidaActual = this.vidaTotal;
		}else if(this.vidaActual < this.vidaTotal){
			this.vidaActual += regeneracionVida;
		}
		
	}
	public void regenerarMana() {
		if(this.manaActual + regeneracionMana > this.manaTotal ) {
			this.manaActual = this.manaTotal;
		}else if(this.manaActual < this.manaTotal){
			this.manaActual += regeneracionMana;
		}
	}
	public String toString2LaSecuela() {
		return "Personaje \n [fuerza=" + fuerza + ",\n inteligencia=" + inteligencia + ",\n destreza=" + destreza
				+ ",\n manaTotal=" + manaTotal + ",\n manaActual=" + manaActual + ",\n regeneracionVida=" + regeneracionVida
				+ ",\n regeneracionMana=" + regeneracionMana + ",\n nivel=" + nivel + ",\n exp=" + exp + ",\n vidaTotal="
				+ vidaTotal + ", vidaActual=" + vidaActual + ", ataque=" + ataque + ", defensa=" + defensa
				+ ",\n posicionX=" + posicionX + ",\n posicionY=" + posicionY + "]";
	}

	@Override
	public String toString() {
		return "Personaje [fuerza=" + fuerza + ", inteligencia=" + inteligencia + ", destreza=" + destreza
				+ ", manaTotal=" + manaTotal + ", manaActual=" + manaActual + ", regeneracionVida=" + regeneracionVida
				+ ", regeneracionMana=" + regeneracionMana + ", nivel=" + nivel + ", exp=" + exp + ", vidaTotal="
				+ vidaTotal + ", vidaActual=" + vidaActual + ", ataque=" + ataque + ", defensa=" + defensa
				+ ", posicionX=" + posicionX + ", posicionY=" + posicionY + "]";
	}


	

}
