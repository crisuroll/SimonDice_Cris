package files;

public interface ICustomWriteFile {
	/* Si una clase no implementa TODOS los metodos de la interfaz, la clase pasa a ser abstracta
	 * DOS MÉTODOS DE ICustomReadFile IMPLEMENTADOS
	 * - void closeWriteFile(): Cierra el fichero. Controlar excepción. "Excepcion capturada en X metodo de X clase".
	 * - void writePlayers(String _chain). this.write(_chain);
	 * USAN UNA CONSTRUCTORA SUPER
	 */
	public void closeWriteFile();
	public void writePlayers(String _chain); // Esta cadena va a ser un String formado por puntuación y nombre.
}
