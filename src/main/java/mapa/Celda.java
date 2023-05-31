package mapa;

import java.util.ArrayList;

import objetos.Arma;
import objetos.Armadura;
import objetos.Objeto;
import personaje.Enemigo;
import personaje.Personaje;

public class Celda {
	
	public ArrayList<Objeto> objetosSuelo = new ArrayList<>();
	private char letra;
	private Tienda tienda;
	private Herrero herrero;
	private Enemigo enemigo;
	private Personaje jugador;
	
	public Personaje getJugador() {
		return jugador;
	}


	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}
	public Celda() {
		
	}

	public Celda(ArrayList<Objeto> objetosSuelo, char letra, Tienda tienda, Herrero herrero, Enemigo enemigo) {
		super();
		this.objetosSuelo = objetosSuelo;
		this.letra = letra;
		this.tienda = tienda;
		this.herrero = herrero;
		this.enemigo = enemigo;
		this.jugador = null;
	}
	public Celda(ArrayList<Objeto> objetosSuelo, char letra, Tienda tienda, Herrero herrero, Enemigo enemigo, Personaje jugador) {
		super();
		this.objetosSuelo = objetosSuelo;
		this.letra = letra;
		this.tienda = tienda;
		this.herrero = herrero;
		this.enemigo = enemigo;
		this.jugador = jugador;
	}

	public ArrayList<Objeto> getObjetosSuelo() {
		return objetosSuelo;
	}


	public void setObjetosSuelo(ArrayList<Objeto> objetosSuelo) {
		this.objetosSuelo = objetosSuelo;
	}


	public Tienda getTienda() {
		return tienda;
	}
	

    public Celda(String celdaString) {
    	String [] stringSeparada = separarString(celdaString);
        introducirAObjetosSuelo(stringSeparada[1]);
        letra = stringSeparada[2].charAt(6);
        tienda = new Tienda(stringSeparada[3]);
        herrero = new Herrero(stringSeparada[4]);
        enemigo = new Enemigo(stringSeparada[5]);
        jugador = new Personaje(stringSeparada[6]);
    }
    public static String[] separarString(String entrada) {
        return entrada.split("\\R");
    }

	public void introducirAObjetosSuelo(String input) {
		
        // Verificar si es nulo
        if (input.equals("objetosSuelo=null,")) {
            return;
        }
        this.objetosSuelo = new ArrayList<>();
        
        String objetosAVenderStr = input.substring(input.indexOf("[") + 1, input.lastIndexOf("]"));
        String[] objetosArray = objetosAVenderStr.split("], ");



        for (int i = 0; i < objetosArray.length; i++) {
            objetosArray[i] = objetosArray[i] + "]";
            String tipoObjeto = objetosArray[i].substring(0, objetosArray[i].indexOf(" ["));
            String objetoStr = objetosArray[i];
            

            
            switch (tipoObjeto) {
                case "Arma":
                    this.objetosSuelo.add(new Arma(objetoStr));
                    break;
                case "Armadura":
                    this.objetosSuelo.add(new Armadura(objetoStr));
                    break;
                default:
                    // Ignorar objetos desconocidos
                    break;
            }
        }
    }


	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


	public Herrero getHerrero() {
		return herrero;
	}


	public void setHerrero(Herrero herrero) {
		this.herrero = herrero;
	}


	public Enemigo getEnemigo() {
		return enemigo;
	}


	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}


	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public void setLetra() {
		if(this.jugador != null) {
			this.letra = 'J';
		}else if(this.enemigo != null) {
			this.letra = 'E';
		}else if(this.tienda != null) {
			this.letra = 'T';
		}else if(this.herrero != null) {
			this.letra = 'H';
		}	
		
	}
	@Override
	public String toString() {
		return "Celda ["+ "\n" +"objetosSuelo=" + objetosSuelo + ",\n"+ "letra=" + letra + ",\n"+ "tienda=" + tienda + ",\n"+ "herrero="
				+ herrero + ",\n" + "enemigo="  + enemigo+",\n" + "jugador=" + jugador +",\n"+ "]";
	}
	
}
