package main;

public class Record {
	final private int MAX_JUGADORES;
	private int cont;
	private Jugador[] arrJugadores;
	
	public Record() {
		this.MAX_JUGADORES = 20;
		this.cont = 0;
	}
	
	/**
	 * Metodo addPlayer. Añade un jugador al array de jugadores.
	 */
	public void addPlayer(String _nombre) {
		
	}
	
	/**
	 * Metodo getPlayer. Recibe un String y retorna un objeto Jugador
	 */
	public Jugador getPlayer(String _nombre) {
		boolean encontrado = false;
		int i = 0;
		Jugador j = null;
		while (encontrado == false && i < this.arrJugadores.length) {
			if (this.arrJugadores[i].getNombre().equals(_nombre)) { 
				j = this.arrJugadores[i];
				System.out.println("Se ha encontrado el jugador '" + j.getNombre() + "'." );
				encontrado = true;
			}
			i++;
		}
		if(encontrado == false) {
			System.out.println("No se ha encontrado el jugador '" + _nombre + "'.");
		}
		return j;
	}
	
	/**
	 * Metodo sortRanking. Coge el array de jugadores y lo ordena de mayor a menor puntuacion.
	 */
	public void sortRanking() {
		
		
	}
	
	/**
	 * Metodo showRanking. Muestra el ranking de los 10 mejores jugadores.
	 */
	public void showRanking() {
		
		
	}
	
	/**
	 * Metodo showBestPlayer. Muestra el jugador (o jugadores) con la puntuación más alta.
	 */
	public void showBestPlayer() {
		
		
	}
	
	/**
	 * Metodo cargarRanking. Este método crea un objeto de tipo CustomReadFile y llama al método que se encarga 
	 * de leer de fichero, que como no podía ser de otra forma se encuentra en la propia clase CustomReadFile 
	 * (de ahí que debamos instanciar un objeto de esa clase).
	 */
	public void cargarRanking() {
		
		
	}
	
	/**
	 * Metodo escribirRanking. Este método crea un objeto de tipo CustomWriteFile y llama al método que se encarga 
	 * de escribir en fichero, que como no podía ser de otra forma se encuentra en la propia clase CustomWriteFile. 
	 * Específicamente, este método creará una cadena de tipo String con los jugadores y sus puntuaciones, 
	 * respetando las dos columnas. Esta cadena será pasada por parámetro al método correspondiente en la clase 
	 * CustomWriteFile para que así pueda escribir la información en el fichero. El profesor proporcionará parte 
	 * del código de las clases CustomReadFile, CustomWriteFile, ICustomReadFile, ICustomWriteFile y Pair.
	 */
	public void escribirRanking() {
		
		
	}
}
