package files;

import java.util.Vector;

import main.Jugador;

public interface ICustomReadFile {
	/* Si una clase no implementa TODOS los metodos de la interfaz, la clase pasa a ser abstracta
	 * DOS MÉTODOS DE ICustomReadFile IMPLEMENTADOS
	 * - void closeReadFile(): Cierra el fichero. Controlar excepción. "Excepcion capturada en X metodo de X clase".
	 * - Vector/ArrayList...<Jugador> readPlayers(). Leer primer jugador de top.txt, añadirlo al vector. Asi con
	 *   todos. Retornar el vector.
	 * USAN UNA CONSTRUCTORA SUPER
	 */
	public void closeReadFile();
	public Vector<Jugador> readPlayers();
}
