package mapa;

import java.util.Random;

import objetos.Arma;
import objetos.Armadura;
import objetos.Equipamiento;

public class Herrero {

	public short usos;

	public Herrero() {
		Random ran = new Random();
		this.usos = (short) ran.nextInt(1,3);
	}
	
	public void mejorarEquipamiento(Equipamiento equipamiento) {
		
		if(equipamiento instanceof Arma) {
			((Arma) equipamiento).setDaño((float)(((Arma) equipamiento).getDaño()*1.2));
		}else {
			((Armadura) equipamiento).setDefensa((int)(((Armadura) equipamiento).getDefensa()*1.2));
		}

	}
	
	public Herrero(String datos) {
        if (datos.equals("herrero=null,")) {
            // Si el string indica que el herrero es null, se puede dejar los atributos con sus valores por defecto.
            return;
        }

        String[] atributos = datos.substring(datos.indexOf("[") + 1, datos.indexOf("]")).split(", ");

        for (String atributo : atributos) {
            String[] partes = atributo.split("=");

            String nombre = partes[0].trim();
            String valorStr = partes[1].trim();

            switch (nombre) {
                case "usos":
                    this.usos = (short) Integer.parseInt(valorStr);
                    break;
                default:
                    // Ignorar atributos desconocidos
                    break;
            }
        }
    }
	@Override
	public String toString() {
		return "Herrero [usos=" + usos + "]";
	}
}
