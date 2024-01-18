import java.util.Scanner;

public class Engine {

	// Escaner
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);

	/**
	 * Tipo enum tColores. Guarda los colores disponibles para la secuencia de Simon
	 * Dice.
	 */
	public enum tColores {
		ROJO, VERDE, AZUL, DORADO
	}

	// Atributos
	final private int MAX_COLORES_SEQ = 12;
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	private tColores[] numColoresEnum = tColores.values();
	final private int NUM_COLORES_ENUM = numColoresEnum.length;

	/**
	 * Metodo charToColor. Recibe como parámetro un char que representa el color introducido por el usuario 
	 * (primera letra) y devuelve su enumeradocorrespondiente.
	 * 
	 * @param _color representa el caracter del color introducido por el usuario.
	 * @return
	 */
	public tColores charToColor(Character _color) {
		tColores color = null;
		switch (_color.toLowerCase(_color)) {
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
			
			default:
				System.out.println("Color introducido no valido.");
				
		}
		return color;
	}

	/**
	 * Metodo intToColor. Recibe como parámetro un número entero y devuelve un color.
	 * 
	 * @param _numero representa el numero entero
	 * @return
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

			default:
				System.out.println("Numero introducido no valido.");
		}
		return color;
	}

	/**
	 * Metodo mostrarColor. Recibe un color de tipo tColores y devuelve su equivalente en String, mostrando asi el 
	 * color de forma mas amigable para el jugador.
	 * 
	 * @param _color representa el color de tipo tColores que queremos mostrar como String
	 * @return
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

			default:
				System.out.println("Color introducido no valido.");
		}
		return color;
	}

	/**
	 * Metodo generarSecuencia. Genera una secuencia de colores de forma aleatoria dentro del intervalo 
	 * [0, _numColores], la cual se almacenará en el array secuenciaColores.
	 * 
	 * @param _numColores representa el número de colores que tiene el tipo enumerado tColores.
	 * @return
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
	 * 
	 * @param _index es el indice que el color ocupa dentro del array secuenciaColores.
	 * @param _color es el color introducido por el usuario.
	 * @return
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
	 * 
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
	 * 	Metodo play. Encargado de controlar la secuencia en la que se encuentra el juego, así como de leer de teclado
	 *  los colores que teclee el usuario y sacar por pantalla los correspondientes mensajes.
	 */
	public void play() {
		// Declaramos e inicializamos las variables.
		int op = 1; // Opcion del switch
		int vuelta = 0; // Repeticiones del primer bucle while
		int index = 0; // Indice correspondiente a su posicion en secuenciaColores[]
		int numColores = 3; // Numero de colores mostrados en la secuencia
		char ch = 'a'; // Color introducido por el usuario
		boolean fallo = false; // Comprueba si el usuario ha fallado (true) o ha acertado (false)
		boolean color = false;
		// Llamamos al metodo menu()
		menu();
		op = sc.nextInt();

		switch (op) {
			case 0:
				System.out.println("Saliendo del juego. Hasta la proxima...");
			break;
			case 1:
				// Inicio del bucle do-while
				do {
					// Volvemos a inicializar las variables al valor anterior para poder resetear el juego
					vuelta = 0;
					numColores = 3;
					System.out.println("Comenzando el juego.");
					generarSecuencia(this.NUM_COLORES_ENUM);
					
					// Inicio del bucle while
					while (vuelta < numColores) {
						// Se inicializan de nuevo las variables para poder revisar la siguiente secuencia correctamente
						index = 0;
						fallo = false;
						mostrarSecuencia(numColores);
						
						System.out.println("Introduce el color numero " + (index + 1) + ": ");
						
						while (color == false) {
							if (sc.hasNext("[^A-Za-z]")) {			
								System.out.println("Solo puedes introducir letras.");
								System.out.println("Introduce el color numero " + (index + 1) + ": ");
								ch = sc.next().charAt(0);
							} else {
								color = true;
							}
						}
						
						color = false;
						ch = sc.next().charAt(0);
						// Mientras fallo no sea falso y el índice del array sea menor que el número de colores mostrados...
						while (!fallo && index < numColores) {
							fallo = comprobarColor(index, charToColor(ch));
							if (fallo == true) {
								System.out.println("Has fallado...");
								// Forzamos que vuelta sea mayor que el numero de colores para finalizar el juego
								vuelta++;
								vuelta = vuelta + numColores;
							} else {
								System.out.println("Correcto!");
								index++;
								// Si el indice del array es igual que el numero de colores mostrados
								if (index == numColores) {
									System.out.println("Secuencia adivinada.");
									fallo = true;
									numColores++;
									// Si el indice del array es igual que el numero maximo de colores de la secuencia...
									if (index == this.MAX_COLORES_SEQ) {
										System.out.println("Has ganado!");
										// Forzamos que vuelta sea mayor que el numero de colores para finalizar el juego
										vuelta++;
										vuelta = vuelta + numColores;
									}
								} else {
									// Pedimos al usuario el siguiente color, uno a uno...
									System.out.println("Introduce el color numero " + (index + 1) + ": ");
									while (color == false) {
										if (sc.hasNext("[^A-Za-z]")) {			
											System.out.println("Solo puedes introducir letras.");
											System.out.println("Introduce el color numero " + (index + 1) + ": ");
											ch = sc.next().charAt(0);
										} else {
											color = true;
										}
									}
									ch = sc.next().charAt(0);
								}
							}
								
						}
					}
					// Llamamos al metodo menu() para poder volver a elegir una opcion
					menu();
					op = sc.nextInt();
				} while (op != 0);
			break;
			default:
				System.out.println("Opcion introducida no valida.");
			}
		System.out.println("Fin del programa.");
	}

	/**
	 * Metodo menu. Muestra un menu con las opciones disponibles.
	 */
	public void menu() {
		System.out.println(" 0. Salir\n 1. Jugar\n Elige una opcion: ");
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
