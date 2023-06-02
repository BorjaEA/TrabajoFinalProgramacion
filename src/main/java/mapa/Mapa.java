package mapa;
import java.util.Arrays;

import personaje.Enemigo;

public class Mapa {

	public Celda[][] mapa;
	
	private static short numeroPiso = 1;
	
	public Mapa(int tam) {
		this.mapa = new Celda[tam][tam];
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				this.mapa[i][j] = new Celda();
			}
		}
	}

	public Mapa(char[][]mapa) {
		this.mapa = new Celda[mapa.length][mapa[0].length];
		
		
		
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {

				switch (mapa[i][j]) {
				case 'T' -> this.mapa[i][j] = new Celda(null, mapa[i][j] ,new Tienda(numeroPiso), null, null);
				case 'H' -> this.mapa[i][j] = new Celda(null,mapa[i][j] ,null, new Herrero(), null);
				case 'E' -> this.mapa[i][j] = new Celda(null, mapa[i][j],null, null, new Enemigo(i,j,numeroPiso));
				
				default -> this.mapa[i][j] = new Celda(null,mapa[i][j] ,null, null, null);

				}

			}
		}

		numeroPiso++;

		
	}
	
	public String informacionMapaAString() {
		String salida = "";
		
		for (int i = 0; i < this.mapa.length; i++) {
			for (int j = 0; j < this.mapa[0].length; j++) {
				salida += this.mapa[i][j].toString() + "\n";

			}
		}
		
		return salida;
		
	}
	


	@Override
	public String toString() {
		
		String salida = "";
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				salida += mapa[i][j].getLetra() + " ";
			}
			salida += "\n";
		}
		return salida;
	}
	
	
	
}
