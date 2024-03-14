package files;

import java.io.IOException;

/**
 * Interfaz ICustomWriteFile. Contiene los metodos closeWriteFile y writePlayers(), utilizados en la clase CustomWriteFile.
 * @author crisuroll
 */
public interface ICustomWriteFile {
	public void closeWriteFile() throws IOException;
	public void writePlayers(String _chain) throws IOException;
}
