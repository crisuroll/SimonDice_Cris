import java.util.Scanner;

public class Engine {
	
	// Escaner
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Tipo enum tColores. Guarda los colores disponibles para la secuencia de Simon Dice.
	 */
	public enum tColores {ROJO, VERDE, AZUL, DORADO}
	
	// Atributos
	final private int MAX_COLORES_SEQ = 12;
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];


	/**
	 * Metodo charToColor. Recibe como parámetro un char que representa el color introducido por el usuario (primera letra) y devuelve su 
	 * enumerado correspondiente.
	 * @param _color representa el caracter del color introducido por el usuario.
	 * @return
	 */
	public tColores charToColor(char _color) {
		
		// Variable tipo tColores para guardar el enum correspondiente al color introducido
		tColores color = null;
		
		switch(_color) {
			case 'R':
			case 'r':
				color = tColores.ROJO;
			break;
			
			case 'V':
			case 'v':
				color = tColores.VERDE;
			break;
			
			case 'A':
			case 'a':
				color = tColores.AZUL;
			break;
			
			case 'D':
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
	 * @param _numero representa el numero entero
	 * @return
	 */
	public tColores intToColor(int _numero) {
		tColores color = null;
		
		switch(_numero) {
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
	 * Metodo mostrarColor. Recibe un color de tipo tColores y devuelve su equivalente en String, mostrando asi el color de forma mas
	 * amigable para el jugador.
	 * @param _color representa el color de tipo tColores que queremos mostrar como String
	 */
	public String mostrarColor(tColores _color) {
		String color = "";
		
		switch(_color) {
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
	 * Metodo generarSecuencia. Genera una secuencia de colores de forma aleatoria dentro del intervalo [0, _numColores], la cual se 
	 * almacenará en el array secuenciaColores.
	 * @param _numColores representa el número de colores que tiene el tipo enumerado tColores. 
	 */
	public void generarSecuencia(int _numColores) {
		
		// Crear un array de 12 elementos de tipo tColores
        //tColores[] secuenciaColores = new tColores[_numColores];

        // Llenar el array con valores aleatorios del enum
        for (int i = 0; i < secuenciaColores.length; i++) {
            // Asignar el valor del enum correspondiente al índice aleatorio
            secuenciaColores[i] = intToColor((int) (Math.random() * 4) + 1);
        }

	}
	
	/**
	 * Metodo comprobarColor (int _index, tColores _color). Comprueba si el color introducido por el usuario es correcto o no, devolviendo 
	 * un booleano que indica si ha habido fallo. Correcto - false ; Incorrecto - true.
	 * @param _index es el indice que el color ocupa dentro del array secuenciaColores.
	 * @param _color es el color introducido por el usuario.
	 * @return
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		
		boolean res = false;
		
		if (intToColor(_index) != _color) {
			res = true;
		}
		
		return res;
		
	}
	
	/**
	 * Metodo mostrarSecuencia. Muestra la secuencia actual por pantalla para que el usuario la pueda memorizar. Al pulsar una tecla, la 
	 * secuencia debe borrarse para permitir que el usuario introduzca los colores.
	 * @param _numero es el numero de la secuencia actual.
	 */
	public void mostrarSecuencia(int _numero) {	
		int secAct = _numero - 2;
        // Imprimir el array resultante
		System.out.print("Secuencia " + secAct + ": ");
        for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " - ");
		}
        
        System.out.println("\nCuando memorices la secuencia, pulsa ENTER...");
		if (sc.hasNextLine()) {
			String s = sc.nextLine();
		}
        
		// Bucle for utilizado para "limpiar" la consola
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
        
	}
	
	/**
	 * Metodo play. Encargado de controlar la secuencia en la que se encuentra el juego, así como de leer de teclado los colores que 
	 * teclee el usuario y sacar por pantalla los correspondientes mensajes.
	 */
	public void play() {
		int op = 0;
		int i = 3;
		char ch = 'a';
		menu();
		op = sc.nextInt();
	
		do {
			switch(op) {
			case 0:
				System.out.println("Saliendo del juego. Hasta la proxima...");
			break;
			case 1:
				i = 3;
				System.out.println("Comenzando el juego.");
				generarSecuencia(MAX_COLORES_SEQ);
				mostrarSecuencia(i);
				System.out.println("Introduce la inicial de los colores, uno a uno: ");
				
				ch = sc.next();
				while(i) {
					while() {
						comprobarColor(ch);
					}
				}

			break;
			default:
				System.out.println("Opcion introducida no valida.");
			}
		} while(op != 0);
		


		
		
		/*
		despues habria un do-while
			dentro habra un switch con las opciones del menu
			al  menu se le debe llamar justo antes del bucle do while
			variables... secActual, fallo, puntuacion...

			En la sentencia 1 muestra 3 colores, en la 2 muestra cuatro colores... sentencia = array - 2

			// Implementar metodos toLowerCase y toUpperCase.
			// Comprobar colores uno a uno segun los introduzca el jugador. (while dentro del do-while)
			// Antes del while anterior, otro while que compruebe si ha introducido un char.
			 * 
			 */

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
		// Condicion if que se asegura de que la partida comience al pulsar ENTER
		if (sc.hasNextLine()) {
			String s = sc.nextLine();
		}
		play();
		
	}
	
}
