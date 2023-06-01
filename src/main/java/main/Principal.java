package main;


import interfaces.PantallaInicio;
import interfaces.Ventana;
import mapa.Mapa;
import partida.Partida;


public class Principal {
	
	

	public static void main(String[] args) {


		
		PantallaInicio i = new PantallaInicio(new Ventana());


		
	}


	public static String[] separarString(String entrada) {
        return entrada.split("\\R");
    }
    


}

