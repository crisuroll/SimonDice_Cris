package files;

import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile {
	/* Si una clase no implementa TODOS los metodos de la interfaz, la clase pasa a ser abstracta
	 * DOS MÉTODOS DE ICustomReadFile IMPLEMENTADOS
	 * - void closeWriteFile(): Cierra el fichero. Controlar excepción. "Excepcion capturada en X metodo de X clase".
	 * - void writePlayers(String _chain). this.write(_chain);
	 * USAN UNA CONSTRUCTORA SUPER
	 */
	private CustomWriteFile cwf = new CustomWriteFile("./src/data/top.txt");
	public CustomWriteFile(String fileName) throws IOException {
		super(fileName);
	}
	
	public void closeWriteFile() throws IOException {
		this.cwf.close();
	}
	public void writePlayers(String _chain) throws IOException {
		this.write(_chain);
	}
}
