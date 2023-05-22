package objetos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Anillo extends Equipamiento{
	static private Random ran = new Random();
	private int regeneracionVida, regeneracionMana;
    static private List<String> nombreAnillos = Arrays.asList(
            "Andvaranaut",
            "Draupnir",
            "Nenya",
            "Narya",
            "Vilya",
            "The One Ring",
            "Brísingamen",
            "Tarnhelm",
            "Gleipnir",
            "Aetherius",
            "Ring of Gyges",
            "Ring of Silvianus",
            "Ring of Solomon",
            "Ring of Arcana",
            "Ring of Erreth-Akbe",
            "Ring of Elysium",
            "Ring of Avalon",
            "Ring of Anor",
            "Ring of Issek",
            "Ring of Alberich",
            "Ring of Oberon",
            "Ring of Morgoth",
            "Ring of Phorcys",
            "Ring of Proteus",
            "Ring of Poseidon",
            "Ring of Hades"
        );

	public Anillo(short piso, String nombre, int fuerza, int inteligencia, int destreza) {
		super(piso, nombre, fuerza, inteligencia, destreza);
		// TODO Auto-generated constructor stub
	}
	
	public Anillo(short piso) {
		super(piso, nombreAnillos.get(ran.nextInt(nombreAnillos.size())), ran.nextInt(piso), ran.nextInt(piso), ran.nextInt(piso));
		this.regeneracionMana = ran.nextInt(piso*5);
		this.regeneracionVida = ran.nextInt(piso*5);
	}

	@Override
	public String toString() {
		return "Anillo [regeneracionVida=" + regeneracionVida + ", regeneracionMana=" + regeneracionMana + ", fuerza="
				+ fuerza + ", inteligencia=" + inteligencia + ", destreza=" + destreza + ", valor=" + valor
				+ ", nombre=" + nombre + "]";
	}

	
	
}
