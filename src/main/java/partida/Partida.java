package partida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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

	public Partida(Mapa mapa) {
		this.mapa = mapa;
		generarJugador();

	}

	public Partida() {
		abrirPartidaGuardada();
	}

	public void guardarAArchivo() {

		try {
			File carpeta = new File("./Partidas guardadas");
			carpeta.mkdir();

			BufferedWriter writer = new BufferedWriter(new FileWriter("./Partidas guardadas/save.txt"));
			writer.write(mapa.mapa.length + "\n");
			writer.write(this.mapa.informacionMapaAString());
			writer.flush();

			writer.close();
		} catch (Exception e) {

		}

	}

	private void generarJugador() {
		Random ran = new Random();
		int posX;
		int posY;
		do {
			posX = ran.nextInt(this.mapa.mapa.length);
			posY = ran.nextInt(this.mapa.mapa.length);

		} while (mapa.mapa[posX][posY].getLetra() == '░' || mapa.mapa[posX][posY].getLetra() == 'H'
				|| mapa.mapa[posX][posY].getLetra() == 'S' || mapa.mapa[posX][posY].getLetra() == 'E'
				|| mapa.mapa[posX][posY].getLetra() == 'T');

		this.personaje = new Personaje(posX, posY);
		this.mapa.mapa[posX][posY].setJugador(personaje);
		this.mapa.mapa[posX][posY].setLetra('J');

	}

	public Partida moverJugador(int dirrecion, Partida p) {
		//0 -> arriba
		//1 -> derecha
		//2 -> abajo
		//3 -> izquierda
		Partida salida = p;
		
		switch (dirrecion) {
		case 0 -> {
			salida = moverJugadorAux(p, p.personaje.getPosicionX(), p.personaje.getPosicionY() - 1);
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()].setJugador(null);
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()- 1].setJugador(salida.personaje);
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()].setLetra();
			


		}
		case 1 -> {
			salida = moverJugadorAux(p, p.personaje.getPosicionX()+ 1, p.personaje.getPosicionY() );
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()].setJugador(null);
			salida.mapa.mapa[p.personaje.getPosicionX()+ 1][p.personaje.getPosicionY()].setJugador(salida.personaje);
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()].setLetra();
			

		}
		case 2 -> {
			salida = moverJugadorAux(p, p.personaje.getPosicionX() , p.personaje.getPosicionY() + 1);
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()].setJugador(null);
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()+ 1].setJugador(salida.personaje);
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()].setLetra();

		}
		case 3 -> {
			salida = moverJugadorAux(p, p.personaje.getPosicionX()-1, p.personaje.getPosicionY() );
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()].setJugador(null);
			salida.mapa.mapa[p.personaje.getPosicionX()- 1][p.personaje.getPosicionY()].setJugador(salida.personaje);
			salida.mapa.mapa[p.personaje.getPosicionX()][p.personaje.getPosicionY()].setLetra();
			
			
		}
		

		
		}
		return salida;
		
		
		
	}

	private Partida moverJugadorAux(Partida p, int x, int y) {
		Partida salida = p;
		
		if(p.mapa.mapa[x][y].getLetra() != '░') {
			salida.mapa.mapa[x][y].setLetra('J');
			salida.personaje = p.personaje;
			salida.personaje.setPosicionX(x);
			salida.personaje.setPosicionY(y);
		}
		
		return salida;
	}

	public void abrirPartidaGuardada() {
		try (BufferedReader reader = new BufferedReader(new FileReader("./Partidas guardadas/save.txt"))) {
			String linea = reader.readLine();
			int tam = Integer.parseInt(linea);
			this.mapa = new Mapa(tam);
			for (int i = 0; i < tam; i++) {
				for (int j = 0; j < tam; j++) {
					linea = reader.readLine();// Lee Celda [
					linea = reader.readLine();// Lee objetosSuelo
					this.mapa.mapa[i][j].introducirAObjetosSuelo(linea);
					linea = reader.readLine();// Lee letra
					this.mapa.mapa[i][j].setLetra(linea.charAt(6));
					linea = reader.readLine();// Lee tienda
					this.mapa.mapa[i][j].setTienda(new Tienda(linea));
					linea = reader.readLine();// Lee herrero
					this.mapa.mapa[i][j].setHerrero(new Herrero(linea));
					linea = reader.readLine();// Lee enemigo
					this.mapa.mapa[i][j].setEnemigo(new Enemigo(linea));
					linea = reader.readLine();// Lee jugador
					if (!linea.equals("jugador=null,")) {
						this.personaje = new Personaje(linea);
					}
					this.mapa.mapa[i][j].setJugador(new Personaje(linea));
					linea = reader.readLine();// Lee ]
				}
			}

		} catch (IOException e) {
			System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
		}

	}

	public String devolverMapa() {

		String salida = "";

		for (int i = 0; i < mapa.mapa.length; i++) {
			for (int j = 0; j < mapa.mapa[0].length; j++) {
				if (mapa.mapa[i][j].getLetra() == '░') {
					salida += mapa.mapa[i][j].getLetra() + " ";
				} else if (mapa.mapa[i][j].getLetra() == ' ') {
					salida += mapa.mapa[i][j].getLetra() + "    ";
				} else if (mapa.mapa[i][j].getLetra() == 'J') {
					salida += mapa.mapa[i][j].getLetra() + "   ";
				}else {
					salida += mapa.mapa[i][j].getLetra() + "  ";
				}

			}
			salida += "\n";
		}
		return salida;

	}

}
