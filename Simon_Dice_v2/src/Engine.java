import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Engine. Contiene el motor del juego Simon Dice.
 * @author crisuroll
 */
public class Engine {

	// Escaneres
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);

	/**
	 * Tipo enum tColores. Guarda los colores disponibles para la secuencia de Simon Dice.
	 */
	public enum tColores {
		ROJO, VERDE, AZUL, DORADO, BLANCO, MARRON, NARANJA
	}
	
	public enum tModo {
		FACIL, DIFICIL
	}

	// Atributos
	final private int MAX_COLORES_FACIL = 5;
	final private int MAX_COLORES_DIFICIL = 15;
	private tColores[] secuenciaColores;
	private tColores[] numColoresEnum = tColores.values();
	final private int NUM_COLORES_ENUM = numColoresEnum.length;

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
			default:
				System.out.println("Numero introducido no valido.");
		}
		return color;
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
			default:
				System.out.println("Color introducido no valido.");
		}
		return color;
	}

	/**
	 * Metodo generarSecuencia. Genera una secuencia de colores de forma aleatoria dentro del intervalo 
	 * [0, _numColores], la cual se almacenara en el array secuenciaColores.
	 * @param _numColores representa el numero de colores que tiene el tipo enumerado tColores.
	 */
	public void generarSecuencia(int _numColores) {
		// Llenar el array con valores aleatorios del enum
		for (int i = 0; i < this.secuenciaColores.length; i++) {
			// Asignar el valor del enum correspondiente al índice aleatorio
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
		// Imprimir el array resultante
		System.out.print("Secuencia " + secAct + ": ");
		for (int i = 0; i < _numero; i++) {
			System.out.print(mostrarColor(this.secuenciaColores[i]) + " - ");
		}
		System.out.println("\nCuando memorices la secuencia, pulsa ENTER...");
		if (sc2.hasNextLine()) {
			String s = sc2.nextLine();
		}
		// Bucle for utilizado para "limpiar" la consola
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	/**
	 * 	Metodo play. Encargado de controlar la secuencia en la que se encuentra el juego, asi como de leer de teclado
	 *  los colores que teclee el usuario y sacar por pantalla los correspondientes mensajes.
	 */
	public void play(tModo _modo) {
		// Declaramos e inicializamos las variables.
		int op = 1;
		int index = 0;
		int numColores = 3;
		char ch = 'a';
		boolean fallo = false;
		boolean color = false;

		menu();
		op = sc.nextInt();

		try {
			switch (op) {
				case 0:
					System.out.println("Saliendo del juego. Hasta la proxima...");
				break;
				// CASE 1 MODO FACIL
				case 1:
					secuenciaColores = new tColores[MAX_COLORES_FACIL];
					do {
						numColores = 3;
						System.out.println("Comenzando el juego.");
						generarSecuencia(this.NUM_COLORES_ENUM);
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
								} else {
									ch = sc.next().charAt(0);
									fallo = comprobarColor(index, charToColor(ch));
									if (fallo == true) {
										System.out.println("Has fallado...");
										color = true;
									} else {
										System.out.println("¡Correcto!");
										index++;
										if (index == numColores) {
											System.out.println("Secuencia adivinada.");
											color = true;
											numColores++;
											if (index == this.MAX_COLORES_FACIL) {
												System.out.println("¡Has ganado!");
												index++;
											}
										}
									}
								}
							}
						}
						fallo = false;
						// Llamamos al metodo menu() para poder volver a elegir una opcion
						menu();
						op = sc.nextInt();
					} while (op != 0);
				break;
				// CASE 2 MODO DIFICIL
				case 2:
					////////////////////////////////////////////////////////////////
				break;
				default:
					System.out.println("Opcion introducida no valida.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un numero.");
			}
		System.out.println("Fin del programa.");
	}

	/**
	 * Metodo menu. Muestra un menu con las opciones disponibles.
	 */
	public void menu() {
		System.out.println(" 0. Salir\n 1. Jugar en modo facil\n 2. Jugar en modo dificil\n Elige una opcion: ");
	}

	/**
	 * Metodo start. Encargado de comenzar el juego y dar la bienvenida al jugador.
	 */
	public void start() {
		System.out.println("¡Te doy la bienvenida a Simon Dice! \n¿Cual es tu nombre? ");
		String nombre = sc.nextLine();
		// Creacion del objeto j1 de la clase Jugador
		Jugador j1 = new Jugador(nombre);
		System.out.println("Hola " + j1.getNombre() + ", pulsa ENTER para comenzar.");
		// Condicion if que se asegura de que la partida comience solo al pulsar ENTER
		if (sc.hasNextLine()) {
			String s = sc.nextLine();
		}
		play();
	}
}
