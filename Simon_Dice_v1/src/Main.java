import java.util.Scanner;

/**
 * Clase Main. Simon Dice, version 1.0 del programa. Version basica del programa, permitira jugar una 
 * partida de 12 turnos como maximo, terminando cuando el jugador falle o consiga acierte las 12 rondas.
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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Simon Dice! \nWhat is your name? ");
		String name = sc.nextLine();
		System.out.println("Hello " + name + ", press ENTER to start playing.");
		
		// Condicion if que se asegura de que la partida comience al pulsar ENTER
		if (sc.hasNextLine()) {
			  String s = sc.nextLine();
		}
		
		// Constante que indica la secuencia máxima de la ronda de Simon Dice
		final int MAX_COLORES_SEQ = 12;
		
		// Declaracion del array
		tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
		
	}
	
	/*
	 * Metodo charToColor. Recibe como parámetro un char que representa el color introducido por el 
	 * usuario (primera letra) y devuelve su enumerado correspondiente. Para evitar inconsistencias, 
	 * es recomendable comprobar la letra introducida, tanto en mayúscula, como en minúscula. 
	 * No podrán existir dos colores cuyo nombre empiece con la misma letra.
	 */
	
	/**
	 * Metodo charToColor. Recibe como parámetro un char que representa el color introducido por el 
	 * usuario (primera letra) y devuelve su enumerado correspondiente.
	 * @param _color representa el caracter del color introducido por el usuario.
	 * @return
	 */
	public tColores charToColor(char _color) {
		
	}
	
	/*
	 * Metodo intToColor. Este método recibe como parámetro un número entero y devuelve un color. 
	 * El número recibido representa la posición del color en el tipo enumerado.
	 */
	
	/**
	 * Metodo intToColor. Recibe como parámetro un número entero y devuelve un color.
	 * @param _numero representa el numero entero
	 * @return
	 */
	public tColores intToColor(int _numero) {
		
	}
	
	/*
	 * Metodo generarSecuencia. Este método genera una secuencia de colores de forma 
	 * aleatoria dentro del intervalo [0, _numColores], la cual se almacenará en el array 
	 * secuenciaColores. Para generar los colores de forma aleatoria, se puede generar primero un 
	 * número aleatorio y, seguidamente, utilizar la función intToColor para convertirlo al tipo
	 * tColores. La secuencia se genera completa al principio del juego y al jugador solamente se le 
	 * muestra en cada momento una parte cada vez más larga de ella.
	 */
	
	/**
	 * Metodo generarSecuencia. Genera una secuencia de colores de forma aleatoria dentro del 
	 * intervalo [0, _numColores], la cual se almacenará en el array secuenciaColores.
	 * @param _numColores representa el número de colores que tiene el tipo enumerado tColores. 
	 * @return
	 */
	public void generarSecuencia(int _numColores) {
		
	}
	
	/*
	 * Metodo comprobarColor (int _index, tColores _color). Método que comprueba si el color 
	 * introducido por el usuario es correcto o no, devolviendo un booleano que indica si ha habido 
	 * fallo. Si el color es correcto, la función devolverá false, en caso contrario, devolverá true 
	 * (pues el usuario ha fallado).
	 */
	
	/**
	 * Metodo comprobarColor (int _index, tColores _color). Comprueba si el color introducido por el 
	 * usuario es correcto o no, devolviendo un booleano que indica si ha habido fallo.
	 * Correcto - false ; Incorrecto - true.
	 * @param _index es el indice que el color ocupa dentro del array secuenciaColores.
	 * @param _color es el color introducido por el usuario.
	 * @return
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		
	}
	
	/*
	 * Metodo mostrarSecuencia. El objetivo de este método es mostrar la secuencia actual por 
	 * pantalla para que el usuario la pueda memorizar. Al pulsar una tecla, la secuencia debe 
	 * borrarse para permitir que el usuario introduzca los colores. Para borrar la pantalla se 
	 * puede hacer uso del siguiente bucle:
	 */
	
	/**
	 * Metodo mostrarSecuencia. Muestra la secuencia actual por pantalla para que el usuario la 
	 * pueda memorizar. Al pulsar una tecla, la secuencia debe borrarse para permitir que el usuario 
	 * introduzca los colores.
	 * @param _numero es el numero de la secuencia actual.
	 */
	public void mostrarSecuencia(int _numero) {
		// Bucle for utilizado para "limpiar" la consola
		/*
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		 */
	}
	
	/*
	 * Metodo play (). Método que llevará el control del juego. Será el encargado de controlar la 
	 * secuencia en la que se encuentra el juego, así como de leer de teclado los colores que teclee 
	 * el usuario y sacar por pantalla los correspondientes mensajes. Para generar las secuencias de 
	 * colores y comprobar los colores introducidos por el usuario, se deberán utilizar las funciones
	 * anteriores.
	 */
	
	/**
	 * Metodo play (). Encargado de controlar la secuencia en la que se encuentra el juego, así como 
	 * de leer de teclado los colores que teclee el usuario y sacar por pantalla los correspondientes
	 * mensajes.
	 */
	public void play() {
		
	}

}
