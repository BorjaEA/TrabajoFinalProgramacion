package mapa;


import java.util.ArrayList;
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
	  char[][] mapaConSalaUnidas = unirSalas(generarMapaConCuadrados(mapa));
	  

	  return añadirTiendaEnemigosEscaleraHerrero(mapaConSalaUnidas);
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
	            mapa[i][j] = '░';
	        }
	    }

	    Random rand = new Random();

	    // Generar las salas
	    int numSalasGeneradas = 0;
	    while (numSalasGeneradas < numSalas) {
	        int x = rand.nextInt(tamano);
	        int y = rand.nextInt(tamano);

	        // Verificar que no se genera en los bordes
	        if (x != 0 && y != 0 && x != tamano - 1 && y != tamano - 1 && mapa[x][y] == '░') {
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
	    Random ran = new Random();
	    
	    for (int i = 1; i < filas - 1; i++) {
	        for (int j = 1; j < columnas - 1; j++) {
	            if (mapa[i][j] == '·') {
	                int tamano = ran.nextInt(5,15); // entre 5 y 15
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
	public static char[][] unirSalas(char[][] mapa) {

		char[][] mapaResultado = new char[mapa.length][mapa.length];
		ArrayList<Integer> centros = new ArrayList<Integer>();
		
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				mapaResultado [i][j] = mapa[i][j];
			}
		}
		
		centros = buscarCentrosEnMapa(mapaResultado);
		
		

		
		
		int [] centro1 = {centros.get(centros.size()/2-1),centros.get(centros.size()/2)};
		
		for (int i = 0; i < centros.size(); i +=2) {
			int [] centro2 = {centros.get(i),centros.get(i+1)};
			mapaResultado = unir2Posiciones(mapaResultado, centro1 , centro2);

		}
		
		
	
		return mapaResultado;
	}

	private static char[][] unir2Posiciones(char[][] mapa, int[] posicion1, int[] posicion2) {
        int fila1 = posicion1[0];
        int columna1 = posicion1[1];
        int fila2 = posicion2[0];
        int columna2 = posicion2[1];

        mapa[fila1][columna1] = ' '; 

        if (fila2 > fila1) {
            for (int i = fila1 + 1; i <= fila2; i++) {
                mapa[i][columna1] = ' '; 
            }
        } else if (fila2 < fila1) {
            for (int i = fila1 - 1; i >= fila2; i--) {
                mapa[i][columna1] = ' '; 
            }
        }

        if (columna2 > columna1) {
            for (int j = columna1 + 1; j <= columna2; j++) {
                mapa[fila2][j] = ' '; 
            }
        } else if (columna2 < columna1) {
            for (int j = columna1 - 1; j >= columna2; j--) {
                mapa[fila2][j] = ' '; 
            }
        }

        return mapa;
    }

	
	
	private static ArrayList<Integer> buscarCentrosEnMapa (char[][] mapa){
		
		ArrayList<Integer> centros = new ArrayList<Integer>();
		
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				if(mapa[i][j] == 'O') {
					centros.add(i);
					centros.add(j);
				}

			}
		}
		
		
		return centros;
	}

    /**
     * Añade los elementos "S", "E", "T" y "H" al mapa en las posiciones adecuadas.
     *
     * @param mapa el mapa actual
     * @return el mapa actualizado
     */
    private static char[][] añadirTiendaEnemigosEscaleraHerrero(char[][] mapa) {
        int filas = mapa.length;
        int columnas = mapa[0].length;
        
        Random ran = new Random();

        // Añadir 'S' en una posición si hay un espacio vacío
        int cont = 0;
        while(cont != 1) {
        	int posX = ran.nextInt(mapa.length);
        	int posY = ran.nextInt(mapa.length);
        	
            if (mapa[posX][posY] == ' ') {
            	mapa[posX][posY] = 'S';
            	cont++;
            }
        }

            
        

        // Añadir 'E' en 7 posiciones si hay espacios vacíos
        cont = 0;
        while(cont != 7) {
        	int posX = ran.nextInt(mapa.length);
        	int posY = ran.nextInt(mapa.length);
        	
            if (mapa[posX][posY] == ' ') {
            	mapa[posX][posY] = 'E';
            	cont++;
            }
        }

        
        cont = 0;
        while(cont != 1) {
        	int posX = ran.nextInt(mapa.length);
        	int posY = ran.nextInt(mapa.length);
        	
            if (mapa[posX][posY] == ' ') {
            	mapa[posX][posY] = 'T';
            	cont++;
            }
        }

        
        cont = 0;
        while(cont != 1) {
        	int posX = ran.nextInt(mapa.length);
        	int posY = ran.nextInt(mapa.length);
        	
            if (mapa[posX][posY] == ' ') {
            	mapa[posX][posY] = 'H';
            	cont++;
            }
        }

        return mapa;
    }




}
