package partida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import mapa.Herrero;
import mapa.Mapa;
import mapa.Tienda;
import personaje.Enemigo;
import personaje.Personaje;

public class Partida {

	public Personaje personaje;
	public Mapa mapa;
	
	public Partida(Personaje personaje, Mapa mapa) {
		super();
		this.personaje = personaje;
		this.mapa = mapa;
		this.mapa.mapa[personaje.getPosicionX()][personaje.getPosicionY()].setJugador(personaje);
	}
	
	public Partida() {
		abrirPartidaGuardada();
	}
	
	public void guardarAArchivo() {
		
		try {
			File carpeta=new File("./Partidas guardadas");
	        carpeta.mkdir();
	        
	        BufferedWriter writer = new BufferedWriter(new FileWriter("./Partidas guardadas/save.txt"));
	        writer.write(mapa.mapa.length + "\n");
	        writer.write(this.mapa.informacionMapaAString());
	        writer.flush();
	        
	        writer.close();
		}catch(Exception e) {
			
		}
        

	}
	
	public void abrirPartidaGuardada() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./Partidas guardadas/save.txt"))) {
    		String linea = reader.readLine();
    		int tam = Integer.parseInt(linea);
    		this.mapa = new Mapa(tam);
        	for (int i = 0; i < tam; i++) {
        		for (int j = 0; j < tam; j++) {
        			linea = reader.readLine();//Lee Celda [
        			linea = reader.readLine();//Lee objetosSuelo
        			this.mapa.mapa[i][j].introducirAObjetosSuelo(linea);
        			linea = reader.readLine();//Lee letra
        			this.mapa.mapa[i][j].setLetra(linea.charAt(6));
        			linea = reader.readLine();//Lee tienda
        			this.mapa.mapa[i][j].setTienda(new Tienda(linea));
        			linea = reader.readLine();//Lee herrero
        			this.mapa.mapa[i][j].setHerrero(new Herrero(linea));
        			linea = reader.readLine();//Lee enemigo
        			this.mapa.mapa[i][j].setEnemigo(new Enemigo(linea));
        			linea = reader.readLine();//Lee jugador
        			if(!linea.equals("jugador=null,")) {
        				this.personaje = new Personaje(linea);
        			}
        			this.mapa.mapa[i][j].setJugador(new Personaje(linea));
        			linea = reader.readLine();//Lee ]
				}
			}
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
		
	}
	
	
}
