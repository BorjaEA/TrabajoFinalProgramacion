package main;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.PantallaInicio;
import interfaces.Ventana;
import mapa.*;
import objetos.Arma;
import objetos.Objeto;
import partida.Partida;
import personaje.Enemigo;
import personaje.Personaje;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		char[][]a = mapa.Funciones.crearNivel(20, 50);
		Mapa mapa = new Mapa(a);

		Personaje p = new Personaje(0, 0);
		
		Partida partida = new Partida(p, mapa);
		System.out.println(partida.mapa.toString());
		partida.guardarAArchivo();

		Partida partida2 = new Partida();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(partida2.mapa.toString());


		
		//PantallaInicio i = new PantallaInicio(new Ventana());

	}

    public static String[] separarString(String entrada) {
        return entrada.split("\\R");
    }

}

