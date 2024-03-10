package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Jugador;

public class CustomReadFile extends FileReader implements ICustomReadFile {
	private final ArrayList<Jugador> miAL = new ArrayList<Jugador>();
	private CustomReadFile crf = new CustomReadFile("./src/data/top.txt");
	/* DOS MÉTODOS DE ICustomReadFile IMPLEMENTADOS
	 * - void closeReadFile(): Cierra el fichero. Controlar excepción. "Excepcion capturada en X metodo de X clase".
	 * - Vector/ArrayList...<Jugador> readPlayers(). Leer primer jugador de top.txt, añadirlo al vector. Asi con
	 *   todos. Retornar el vector.
	 * USAN UNA CONSTRUCTORA SUPER
	 */
	
	public CustomReadFile(String _fileName) throws FileNotFoundException {
		super(_fileName);
	}

	public void closeReadFile() throws IOException {
		this.crf.close();
	}
	
	public ArrayList<Jugador> readPlayers() throws FileNotFoundException {
		Scanner sc = new Scanner(crf);
		int i = 0;
		while(sc.hasNextLine()) {
			Jugador j = new Jugador(sc.nextLine());
			miAL.add(j);
		}
		return miAL;
	}

}
