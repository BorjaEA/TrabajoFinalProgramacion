package objetos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Armadura extends Equipamiento{
	protected static Random ran = new Random();
	protected int defensa;
		
    static private List<String> nombreArmaduras = Arrays.asList(
            "Achilles' Armor",
            "Thor's Belt of Strength",
            "Hercules' Lion Skin",
            "Beowulf's Armor",
            "Odin's Robe",
            "Perseus' Shield",
            "Athena's Aegis",
            "Siegmund's Armor",
            "Cu Chulainn's Gae Bulg Shield",
            "Freyja's Brísingamen Necklace",
            "Siegfried's Tarnkappe",
            "Artemis' Moonlit Armor",
            "Heracles' Nemean Lion Pelt",
            "Sigurd's Gram Armor",
            "Prometheus' Flame-Forged Armor",
            "Durga's Divine Armor",
            "Gilgamesh's Enkidu Armor",
            "Ishtar's Starry Veil",
            "Valkyrie's Winged Armor",
            "Apollo's Solar Radiance",
            "Zeus' Thunderbolt Vestment",
            "Vishnu's Sudarshana Chakra Shield",
            "Mars' War God Plate",
            "Fenrir's Feral Fur",
            "Krishna's Syamantaka Gem Breastplate",
            "Loki's Illusionary Cloak"
    );
    
    public Armadura(String datos) {
        String[] atributos = datos.substring(datos.indexOf("[") + 1, datos.indexOf("]")).split(", ");

        for (String atributo : atributos) {
            String[] partes = atributo.split("=");

            String nombre = partes[0].trim();
            String valorStr = partes[1].trim();

            switch (nombre) {
                case "defensa":
                    this.defensa = Integer.parseInt(valorStr);
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
		
	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public Armadura(short piso) {
			
		super(piso, nombreArmaduras.get(ran.nextInt(nombreArmaduras.size())), 0, 0, 0);
		this.defensa = ran.nextInt(piso, piso* 3 + 1 ) + 2;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Armadura [defensa=" + defensa + ", fuerza=" + fuerza + ", inteligencia=" + inteligencia + ", destreza="
				+ destreza + ", valor=" + valor + ", nombre=" + nombre + "]";
	}
	
}
