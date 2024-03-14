package files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import main.Jugador;

/**
 * Interfaz ICustomReadFile. Contiene los metodos closeReadFile y readPlayers(), utilizados en la clase CustomReadFile.
 * @author crisuroll
 */
public interface ICustomReadFile {
	public void closeReadFile() throws IOException;
	public ArrayList<Jugador> readPlayers() throws FileNotFoundException;
}
