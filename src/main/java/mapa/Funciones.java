package mapa;


import java.util.Arrays;
import java.util.Random;


public class Funciones {
	
	/**
	 * Crea un nivel aleatorio con el número de salas especificado y el tamaño de array especificado.
	 *
	 * @param numSalas el número de salas que se crearán en el nivel.
	 * @param tamanoArray el tamaño del array que se usará para crear el nivel.
	 * @return el nivel generado.
	 */
	public static char[][] crearNivel(int numSalas, int tamanoArray) {
	  char[][] mapa = generarMapa(numSalas, tamanoArray);
	  //char[][] mapaConCuadrados = generarMapaConCuadrados(mapa);
	  //return quitarCaracterUnionSalas(unirSalas(mapaConCuadrados));
	  return unirSalas(generarMapaConCuadrados(mapa));
	  
	}


	
	
	
	
	
	/**
	 * Genera un mapa representado por un array 2D de caracteres.
	 * El mapa contiene un número aleatorio de salas representadas por el caracter '.',
	 * y está rodeado por el caracter 'P'.
	 * 
	 * @param numSalas el número de salas a generar
	 * @param tamano el tamaño del mapa (tanto el ancho como el alto)
	 * @return un array 2D de caracteres que representa el mapa
	 */
	public static char[][] generarMapa(int numSalas, int tamano) {
	    char[][] mapa = new char[tamano][tamano];

	    // Inicializar el mapa con 'P'
	    for (int i = 0; i < tamano; i++) {
	        for (int j = 0; j < tamano; j++) {
	            mapa[i][j] = 'P';
	        }
	    }

	    Random rand = new Random();

	    // Generar las salas
	    int numSalasGeneradas = 0;
	    while (numSalasGeneradas < numSalas) {
	        int x = rand.nextInt(tamano);
	        int y = rand.nextInt(tamano);

	        // Verificar que no se genera en los bordes
	        if (x != 0 && y != 0 && x != tamano - 1 && y != tamano - 1 && mapa[x][y] == 'P') {
	            mapa[x][y] = '·';
	            numSalasGeneradas++;
	        }
	    }

	    return mapa;
	}

	
	/**
	 * Genera un nuevo mapa a partir del mapa generado por la función "generarMapa", agregando cuadrados
	 * de caracteres en las posiciones correspondientes a los caracteres "·" en el mapa original.
	 *
	 * @param mapa el mapa generado por la función "generarMapa".
	 * @return un nuevo mapa con los cuadrados generados alrededor de los caracteres "·".
	 */
	public static char[][] generarMapaConCuadrados(char[][] mapa) {
	    int filas = mapa.length;
	    int columnas = mapa[0].length;

	    for (int i = 1; i < filas - 1; i++) {
	        for (int j = 1; j < columnas - 1; j++) {
	            if (mapa[i][j] == '·') {
	                int tamano = (int) (Math.random() * 4) + 3; // entre 3 y 6
	                int esquinaIzquierda = i - tamano / 2;
	                int esquinaSuperior = j - tamano / 2;

	                for (int x = esquinaIzquierda; x < esquinaIzquierda + tamano; x++) {
	                    for (int y = esquinaSuperior; y < esquinaSuperior + tamano; y++) {
	                        if (x > 0 && x < filas - 1 && y > 0 && y < columnas - 1) {
	                            if (x == i && y == j || mapa[x][y] == '·' || mapa[x][y] == 'O') {
	                                mapa[x][y] = 'O';
	                            } else {
	                                mapa[x][y] = ' ';
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }

	    return mapa;
	}

	
	/**
	 * Une los cuadrados generados en el mapa mediante un camino vertical u horizontal,
	 * desde el centro del borde de un cuadrado al centro del cuadrado más cercano.
	 * Solo hay una unión por cada cara del cuadrado y se utiliza el carácter "|" para
	 * generar el camino entre los cuadrados.
	 *
	 * @param mapa El array de salida de "generarMapaConCuadrados()" que contiene los cuadrados generados.
	 */
	public static char[][] unirSalas(char[][] array) {
		
		int
		
		
		
		
		
		
		return null;
	}







}
