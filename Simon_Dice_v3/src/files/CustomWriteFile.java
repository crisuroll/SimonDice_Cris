package files;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase CustomWriteFile. Se encarga de la escritura de los jugadores en el fichero.
 * @author crisuroll
 */
public class CustomWriteFile extends FileWriter implements ICustomWriteFile {
	/**
	 * Constructura CustomWriteFile.
	 * @param fileName recibe el nombre del fichero.
	 * @throws IOException
	 */
	public CustomWriteFile(String fileName) throws IOException {
		super(fileName);
	}
	
	/**
	 * Metodo closeWriteFile(). Cierra el fichero utilizado.
	 * Complejidad O(1).
	 */
	public void closeWriteFile() throws IOException {
		this.close();
	}
	
	/**
	 * Metodo writePlayers(). Recibe una cadena de jugadores y los agrega al fichero.
	 * @param _chain recibe una cadena.
	 * Complejidad O(n).
	 */
	public void writePlayers(String _chain) throws IOException {
		this.write(_chain);
	}
}
