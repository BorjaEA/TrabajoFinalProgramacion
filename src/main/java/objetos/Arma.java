package objetos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Arma extends Equipamiento{

	private float daño;
    static private List<String> nombreParaArmas = Arrays.asList(
            "Excalibur",
            "Mjölnir",
            "Gungnir",
            "Aegis",
            "Tyrfing",
            "Durandal",
            "Zulfiqar",
            "Trishula",
            "Kunlun",
            "Gáe Bolg",
            "Hofud",
            "Vajra",
            "Gram",
            "Dáinsleif",
            "Nandaka",
            "Kusanagi-no-Tsurugi",
            "Hrunting",
            "Claiomh Solais",
            "Caladbolg",
            "Harpē",
            "Spear of Destiny",
            "Bow of Artemis",
            "Sunflame",
            "Sword of Nuada",
            "Bow of Eurytus",
            "Blade of Chaos"
        );
    
    public Arma(String datos) {
    	
        String[] atributos = datos.substring(datos.indexOf("[") + 1, datos.indexOf("]")).split(", ");

        for (String atributo : atributos) {
            String[] partes = atributo.split("=");

            String nombre = partes[0].trim();
            String valorStr = partes[1].trim();

            switch (nombre) {
                case "daño":
                    this.daño = Float.parseFloat(valorStr);
                    break;
                case "fuerza":
                    this.fuerza = Integer.parseInt(valorStr);
                    break;
                case "inteligencia":
                    this.inteligencia = Integer.parseInt(valorStr);
                    break;
                case "destreza":
                    this.destreza = Integer.parseInt(valorStr);
                    break;
                case "valor":
                    this.valor = Float.parseFloat(valorStr);
                    break;
                case "nombre":
                    this.nombre = valorStr;
                    break;
                default:
                    // Ignorar atributos desconocidos
                    break;
            }
        }
    }
	
	public float getDaño() {
		return daño;
	}

	public void setDaño(float daño) {
		this.daño = daño;
	}

	public Arma(short piso, String nombre, int fuerza, int inteligencia, int destreza, float daño) {
		super(piso, nombre, fuerza, inteligencia, destreza);
		this.daño = daño;
	}
	
	public Arma(short piso) {
		super(piso,nombreParaArmas.get(ran.nextInt(nombreParaArmas.size())),ran.nextInt(piso+1),ran.nextInt(piso+1),ran.nextInt(piso+1));
		this.daño = ran.nextInt(piso, piso* 5 + 1) + 3;
	}

	@Override
	public String toString() {
		return "Arma [daño=" + daño + ", fuerza=" + fuerza + ", inteligencia=" + inteligencia + ", destreza=" + destreza
				+ ", valor=" + valor + ", nombre=" + nombre + "]";
	}
	
}
