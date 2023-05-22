package mapa;

import java.util.ArrayList;
import java.util.Random;

import objetos.Anillo;
import objetos.Arma;
import objetos.Armadura;
import objetos.Objeto;

public class Tienda {
	static private Random ran = new Random();
	public ArrayList<Objeto> objetosAVender = new ArrayList<>();

	public Tienda(short numeroPiso) {
		if(objetosAVender != null) {
			objetosAVender.clear();
		}
		int numeroObjetosAVender = ran.nextInt(2,5);
		for (int i = 0; i < numeroObjetosAVender; i++) {
			int eleccion = ran.nextInt(2);
			
			switch (eleccion) {
			case 0 -> objetosAVender.add(new Arma(numeroPiso));
			case 1 -> objetosAVender.add(new Armadura(numeroPiso));
			case 2 -> objetosAVender.add(new Anillo(numeroPiso));
			}
			
		}
		
		
	}
	   public Tienda(String cadena) {
	        if (cadena.equals("tienda=null,")) {
	            
	            return;
	        }


	        String objetosAVenderStr = cadena.substring(cadena.indexOf("[") + 1, cadena.lastIndexOf("]"));
	        String[] objetosArray = objetosAVenderStr.split("], ");


	        objetosArray[0] = objetosArray[0].replace("objetosAVender=[", "");

	        for (int i = 0; i < objetosArray.length; i++) {
	            objetosArray[i] = objetosArray[i] + "]";
	            String tipoObjeto = objetosArray[i].substring(0, objetosArray[i].indexOf(" ["));
	            String objetoStr = objetosArray[i];
	            

	            
	            switch (tipoObjeto) {
	                case "Arma":
	                    this.objetosAVender.add(new Arma(objetoStr));
	                    break;
	                case "Armadura":
	                    this.objetosAVender.add(new Armadura(objetoStr));
	                    break;
	                default:
	                    // Ignorar objetos desconocidos
	                    break;
	            }
	        }
	    }

	@Override
	public String toString() {
		return "Tienda [objetosAVender=" + objetosAVender + "]";
	}
	
}
