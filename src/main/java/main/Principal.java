package main;

import java.util.Arrays;

import interfaces.Ventana;
import mapa.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		char[][]a = mapa.Funciones.crearNivel(20, 50);
			
//			for (char fila[] : a) {
//				System.out.println(Arrays.toString(fila));
//			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}

		}



}

