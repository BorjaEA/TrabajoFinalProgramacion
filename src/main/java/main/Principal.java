package main;

import java.util.Arrays;

import interfaces.Ventana;
import mapa.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			char a[][] = mapa.Funciones.crearNivel(8, 30);
			
			for (char fila[] : a) {
				System.out.println(Arrays.toString(fila));
			}
			

		}



}

