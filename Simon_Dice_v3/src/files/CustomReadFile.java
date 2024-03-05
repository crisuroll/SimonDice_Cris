package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import main.Jugador;

public class CustomReadFile extends FileReader implements ICustomReadFile {
	private static final Vector<Jugador> Vector = new Vector<Jugador>();

	/* Si una clase no implementa TODOS los metodos de la interfaz, la clase pasa a ser abstracta
	 * DOS MÉTODOS DE ICustomReadFile IMPLEMENTADOS
	 * - void closeReadFile(): Cierra el fichero. Controlar excepción. "Excepcion capturada en X metodo de X clase".
	 * - Vector/ArrayList...<Jugador> readPlayers(). Leer primer jugador de top.txt, añadirlo al vector. Asi con
	 *   todos. Retornar el vector.
	 * USAN UNA CONSTRUCTORA SUPER
	 */
	
	public CustomReadFile(String _fileName) throws FileNotFoundException {
		super(_fileName);
	}

	public void closeReadFile() {
		
	}
	
	public Vector<Jugador> readPlayers() {
		return Vector;
	}

}
