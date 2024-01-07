import java.util.Scanner;

/**
 * Clase Main. Simon Dice, version 1.0 del programa. Version basica del programa, permitira jugar una partida de 12 turnos como maximo, 
 * terminando cuando el jugador falle o consiga acierte las 12 rondas.
 * @author crisuroll
 */
public class Main {

	/**
	 * Tipo enum tColores. Guarda los colores disponibles para la secuencia de Simon Dice.
	 */
	public enum tColores {ROJO, VERDE, AZUL, DORADO};
	
	/**
	 * Metodo main.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Constante que indica la secuencia máxima de la ronda de Simon Dice
		final int MAX_COLORES_SEQ = 12;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¡Bienvenido a Simon Dice! \n¿Cual es tu nombre? ");
		String name = sc.nextLine();
		System.out.println("Hola " + name + ", pulsa ENTER para jugar.");
		
		// Condicion if que se asegura de que la partida comience al pulsar ENTER
		if (sc.hasNextLine()) {
			  play();
		}
		
	}
	
	/**
	 * Metodo charToColor. Recibe como parámetro un char que representa el color introducido por el usuario (primera letra) y devuelve su 
	 * enumerado correspondiente.
	 * @param _color representa el caracter del color introducido por el usuario.
	 * @return
	 */
	public static tColores charToColor(char _color) {
		
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
	public static tColores intToColor(int _numero) {
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
	 * Metodo generarSecuencia. Genera una secuencia de colores de forma aleatoria dentro del intervalo [0, _numColores], la cual se 
	 * almacenará en el array secuenciaColores.
	 * @param _numColores representa el número de colores que tiene el tipo enumerado tColores. 
	 */
	public static void generarSecuencia(int _numColores) {
		
		// Crear un array de 12 elementos de tipo tColores
        tColores[] secuenciaColores = new tColores[_numColores];

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
	public static void mostrarSecuencia(int _numero) {
		// Bucle for utilizado para "limpiar" la consola
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		
        // Imprimir el array resultante
        for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
        
	}
	
	/**
	 * Metodo play (). Encargado de controlar la secuencia en la que se encuentra el juego, así como de leer de teclado los colores que 
	 * teclee el usuario y sacar por pantalla los correspondientes mensajes.
	 */
	public static void play() {
		

	}

}
