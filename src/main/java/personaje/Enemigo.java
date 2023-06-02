package personaje;

public class Enemigo extends EntidadConAtributos{

    public Enemigo(String datos) {
        if (datos.equals("enemigo=null,")) {
            // Si el string indica que el enemigo es null, se puede dejar los atributos con sus valores por defecto.
            return;
        }

        String[] atributos = datos.substring(datos.indexOf("[") + 1, datos.indexOf("]")).split(", ");

        for (String atributo : atributos) {
            String[] partes = atributo.split("=");

            String nombre = partes[0].trim();
            String valorStr = partes[1].trim();

            switch (nombre) {
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
	public Enemigo(int posicionX, int posicionY,short piso) {
		super(posicionX, posicionY);
		this.ataque = 20 * piso;
		this.defensa = 5 * piso;
		this.vidaTotal = 100 * piso;
		this.vidaActual = this.vidaTotal;
	}

	public String toString2LaSecuela() {
		
		return "Enemigo \nvidaTotal=" + vidaTotal + " \nvidaActual=" + vidaActual + "\nataque=" + ataque + "\ndefensa="
				+ defensa + "\nposicionX=" + posicionX + "\nposicionY=" + posicionY + "";
		
	}
	
	
	
	@Override
	public String toString() {
		return "Enemigo [vidaTotal=" + vidaTotal + ", vidaActual=" + vidaActual + ", ataque=" + ataque + ", defensa="
				+ defensa + ", posicionX=" + posicionX + ", posicionY=" + posicionY + "]";
	}
	
}
