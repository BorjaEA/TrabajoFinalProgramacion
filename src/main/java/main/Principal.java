package main;



import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import config.BaseDeDatos;
import config.Usuario;
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

		partida.guardarAArchivo();
//
//		Partida partida2 = new Partida();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println(partida2.mapa.toString());
		

		

		
		


//		Partida partida = new Partida();
//
//
//		
//		Usuario aa = new Usuario("ABCD", "12345aa");
//		aa.insertarPartida(partida);
		

		

		
		
		PantallaInicio i = new PantallaInicio(new Ventana());

	}


	public static String[] separarString(String entrada) {
        return entrada.split("\\R");
    }
    


}

