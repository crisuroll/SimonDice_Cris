import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Engine. Contiene el motor del juego Simon Dice.
 * @author crisuroll
 */
public class Engine {

	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);

	/**
	 * Tipo enum tColores. Guarda los colores disponibles para la secuencia de Simon Dice.
	 */
	public enum tColores {
		ROJO, VERDE, AZUL, DORADO, BLANCO, MARRON, NARANJA
	}
	
	public enum tModo {
		SALIR, FACIL, DIFICIL
	}

	private int MAX_COLORES_SEQ = 0;
	final private int MAX_COLORES_FACIL = 4;
	final private int MAX_COLORES_DIFICIL = 7;
	private tColores[] secuenciaColores;

	/**
	 * Metodo charToColor. Recibe como parametro un char que representa el color introducido por el usuario 
	 * (primera letra) y devuelve su enumerado correspondiente.
	 * @param _color representa el caracter del color introducido por el usuario.
	 * @return color (tColores)
	 */
	public tColores charToColor(Character _color) {
		tColores color = null;
		switch (Character.toLowerCase(_color)) {
			case 'r':
				color = tColores.ROJO;
			break;
			case 'v':
				color = tColores.VERDE;
			break;
			case 'a':
				color = tColores.AZUL;
			break;
			case 'd':
				color = tColores.DORADO;
			break;
			case 'b':
				color = tColores.BLANCO;
			break;
			case 'm':
				color = tColores.MARRON;
			break;
			case 'n':
				color = tColores.NARANJA;
			break;
		}
		return color;
	}

	/**
	 * Metodo intToColor. Recibe como parametro un numero entero y devuelve un color.
	 * @param _numero representa el numero entero
	 * @return color (tColores)
	 */
	public tColores intToColor(int _numero) {
		tColores color = null;
		switch (_numero) {
			case 1:
				color = tColores.ROJO;
			break;
			case 2:
				color = tColores.VERDE;
			break;
			case 3:
				color = tColores.AZUL;
			break;
			case 4:
				color = tColores.DORADO;
			break;
			case 5:
				color = tColores.BLANCO;
			break;
			case 6:
				color = tColores.MARRON;
			break;
			case 7:
				color = tColores.NARANJA;
			break;
		}
		return color;
	}

	/**
	 * Metodo mostrarColor. Recibe un color de tipo tColores y devuelve su equivalente en String, mostrando asi el 
	 * color de forma mas amigable para el jugador.
	 * @param _color representa el color de tipo tColores que queremos mostrar como String
	 * @return color (String)
	 */
	public String mostrarColor(tColores _color) {
		String color = "";
		switch (_color) {
			case ROJO:
				color = "Rojo";
			break;
			case VERDE:
				color = "Verde";
			break;
			case AZUL:
				color = "Azul";
			break;
			case DORADO:
				color = "Dorado";
			break;
			case BLANCO:
				color = "Blanco";
			break;
			case MARRON:
				color = "Marron";
			break;
			case NARANJA:
				color = "Naranja";
			break;
		}
		return color;
	}

	/**
	 * Metodo generarSecuencia. Genera una secuencia de colores de forma aleatoria dentro del intervalo 
	 * [0, _numColores], la cual se almacenara en el array secuenciaColores.
	 * @param _numColores representa el numero de colores que tiene el tipo enumerado tColores.
	 */
	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < this.secuenciaColores.length; i++) {
			this.secuenciaColores[i] = intToColor((int) (Math.random() * _numColores + 1));
		}
	}

	/**
	 * Metodo comprobarColor (int _index, tColores _color). Comprueba si el color introducido por el usuario es 
	 * correcto o no, devolviendo un booleano que indica si ha habido fallo. Correcto - false ; Incorrecto - true.
	 * @param _index es el indice que el color ocupa dentro del array secuenciaColores.
	 * @param _color es el color introducido por el usuario.
	 * @return res (boolean)
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		boolean res = false;
		if (_color != this.secuenciaColores[_index]) {
			res = true;
		}
		return res;
	}

	/**
	 * Metodo mostrarSecuencia. Muestra la secuencia actual por pantalla para que el usuario la pueda memorizar. 
	 * Al pulsar una tecla, la secuencia debe borrarse para permitir que el usuario introduzca los colores.
	 * @param _numero es el numero de la secuencia actual.
	 */
	public void mostrarSecuencia(int _numero) {
		int secAct = _numero - 2;
		System.out.print("Secuencia " + secAct + ": ");
		for (int i = 0; i < _numero; i++) {
			System.out.print(mostrarColor(this.secuenciaColores[i]) + " - ");
		}
		System.out.println("\nCuando memorices la secuencia, pulsa ENTER...");
		if (sc2.hasNextLine()) {
			String s = sc2.nextLine();
		}
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	/**
	 * Metodo usarAyuda. Metodo que permite utiliza las ayudas disponibles. Si no quedan, debera mostrar un 
	 * mensaje informando sobre ello.
	 * @param _index indice del color i-esimo que desea comprobar.
	 * @return
	 */
	public boolean usarAyuda(int _index) {
        int ayuda = 3;
        if (ayuda <= 3) {
            ayuda--;
            return true;
        }else {
            return false;
        }
	}
	
	/**
	 * 	Metodo play. Encargado de controlar la secuencia en la que se encuentra el juego, asi como de leer de teclado
	 *  los colores que teclee el usuario y sacar por pantalla los correspondientes mensajes.
	 *  @param tModo representa el modo de juego.
	 */
	public int play(tModo _modo) {
		int index = 0;
		int numColores = 3;
		char ch = 'a';
		boolean fallo = false;
		boolean color = false;
		int ayudas = 3;
		int puntos = 0;
		
		if (_modo == tModo.FACIL) {
			this.MAX_COLORES_SEQ = 12;
			secuenciaColores = new tColores[MAX_COLORES_SEQ];
			generarSecuencia(this.MAX_COLORES_FACIL);
			System.out.println("Comenzando partida en modo " + tModo.FACIL + ".");
		} else { 
			this.MAX_COLORES_SEQ = 15;
			secuenciaColores = new tColores[MAX_COLORES_SEQ];
			generarSecuencia(this.MAX_COLORES_DIFICIL);
			System.out.println("Comenzando partida en modo " + tModo.DIFICIL + ".");
		}
			numColores = 3;
			while (fallo == false && index < numColores) {
				index = 0;
				fallo = false;
				mostrarSecuencia(numColores);
				color = false;
				
				while (color == false) {
					System.out.println("Introduce el color numero " + (index + 1) + ": ");
					if (sc.hasNext("[^A-Za-z]")) {
						System.out.println("Solo puedes introducir letras.");
						sc.next().charAt(0);
					} else if (sc.hasNext("[Xx]")) {
						ch = sc.next().charAt(0);
						if (usarAyuda(index) == true) {
							System.out.println("Tienes " + ayudas + " ayudas. Has utilizado una ayuda.");
							ayudas = ayudas - 1;
							if(_modo == tModo.FACIL) {
								puntos = puntos - 8;
							} else {
								puntos = puntos - 16;
							}
							System.out.println("El siguiente color es " + mostrarColor(secuenciaColores[index]));
							System.out.println("Ayudas restantes: " + ayudas);
							System.out.println("Puntuacion: " + puntos);
						} else {
							System.out.println("Ya no te quedan mas ayudas.");
						}
					} else {
						ch = sc.next().charAt(0);
							fallo = comprobarColor(index, charToColor(ch));
							if (fallo == true) {
								System.out.println("Has fallado...");
								System.out.println("Puntuacion: " + puntos);
								color = true;
							} else {
								System.out.println("¡Correcto!");
								if(_modo == tModo.FACIL) {
									puntos = puntos + 2;
								} else {
									puntos = puntos + 4;
								}
								index++;
								System.out.println("Puntuacion: " + puntos);
								if (index == numColores) {
									System.out.println("Secuencia adivinada.");
									if(_modo == tModo.FACIL) {
										puntos = puntos + 5;
									} else {
										puntos = puntos + 10;	
									}
									color = true;
									numColores++;
									System.out.println("Puntuacion: " + puntos);
									if (index == MAX_COLORES_SEQ) {
										System.out.println("¡Has ganado!");
										if(_modo == tModo.FACIL) {
											puntos = puntos + 40;
										} else {
											puntos = puntos + 80;
										}
										index++;
									}
								}
							}
					}								
				}
			}	
			if (puntos <= 0) {
				puntos = 0;
			}
			fallo = false;
			return puntos;
	}

	/**
	 * Metodo intToModo. Recibe como parametro un numero entero, correspondiente a la opcion del switch del menu,
	 * y devuelve un modo de juego.
	 * @param _numero
	 * @return
	 */
	public tModo intToModo(int _numero) {
		tModo modo = null;
		switch(_numero) {
			case 0:
				modo = tModo.SALIR;
			break;
			case 1:
				modo = tModo.FACIL;
			break;
			case 2:
				modo = tModo.DIFICIL;
			break;
		}
		return modo;	
	}

	/**
	 * Metodo menu. Muestra un menu con las opciones disponibles.
	 */
	public int menu() {
		System.out.println(" 0. Salir\n 1. Jugar en modo facil\n 2. Jugar en modo dificil\n Elige una opcion: ");
		int op = sc.nextInt();
		return op;
	}

	/**
	 * Metodo start. Encargado de comenzar el juego y dar la bienvenida al jugador.
	 */
	public void start() {
		tModo _modo;
		System.out.println("¡Te doy la bienvenida a Simon Dice! \n¿Cual es tu nombre? ");
		String nombre = sc.nextLine();
		Jugador player = new Jugador(nombre);
		System.out.println("Hola " + player.getNombre() + ", pulsa ENTER para comenzar.");
		if (sc.hasNextLine()) {
			String s = sc.nextLine();
		}
		try {
			try {
				do {
					_modo = intToModo(menu());
					switch (_modo) {
						case SALIR:
							System.out.println("Saliendo del juego. Hasta la proxima...");
						break;
						case FACIL:
							player.setPuntuacion(play(_modo));
							System.out.println("Puntuacion total: " + player.getPuntuacion());
						break;
						case DIFICIL:
							player.setPuntuacion(play(_modo));
							System.out.println("Puntuacion total: " + player.getPuntuacion());
						break;
						default:
							System.out.println("Opcion introducida no valida.");
						}
				} while (_modo != tModo.SALIR);
			} catch (InputMismatchException e) {
					System.out.println("Por favor, introduce un numero.");
			}
			System.out.println("Fin del programa.");
		} catch (InputMismatchException e) {
			System.out.println("Opcion introducida no valida. Saliendo del programa...");
			System.out.println("Fin del programa.");
		} catch (NullPointerException e) {
			System.out.println("Opcion introducida no valida. Saliendo del programa...");
			System.out.println("Fin del programa.");
		}
	}
}
