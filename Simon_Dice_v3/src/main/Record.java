package main;

import java.io.FileWriter;
import java.io.IOException; 

public class Record {
	final private int MAX_JUGADORES;
	private int cont;
	private Jugador[] arrJugadores;
	
	public Record() {
		this.MAX_JUGADORES = 20;
		this.cont = 0;
		this.arrJugadores = new Jugador[MAX_JUGADORES];
	}
	
	/**
	 * Metodo addPlayer. Añade un jugador al array de jugadores.
	 * Complejidad O(1).
	 */
	public void addPlayer(Jugador _player) {
		if (this.cont < this.MAX_JUGADORES) {
			this.arrJugadores[this.cont] = _player;
			this.cont++;
		} else {
			System.out.println("No es posible añadir más jugadores.");
		}
	}
	
	/**
	 * Metodo getPlayer. Recibe un String y retorna un objeto Jugador
	 * Complejidad O(n).
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
	 * Complejidad O(n²).
	 */
	public void sortRanking() {
	    Jugador acu;
	    for (int i = 0; i < this.cont; i++) {
	        for (int j = 0; j < cont - i - 1; j++) {
	            if (this.arrJugadores[j].getPuntuacion() < this.arrJugadores[j + 1].getPuntuacion()) {
	                acu = this.arrJugadores[j + 1];
	                this.arrJugadores[j + 1] = this.arrJugadores[j];
	                this.arrJugadores[j] = acu;
	            }
	        }
	    }
	}
	
	/**
	 * Metodo showBestPlayer. Muestra el jugador (o jugadores) con la puntuación más alta.
	 * Complejidad O(n).
	 */
	public void showBestPlayer() {
		sortRanking();
		int i = 0;
	    while (i < this.cont && this.arrJugadores[i].getPuntuacion() == this.arrJugadores[0].getPuntuacion()) {
			System.out.print(arrJugadores[i].getPuntuacion() + " " + arrJugadores[i].getNombre() + "\n");
	        i++;
	    }
	}
	
	/**
	 * Metodo showRanking. Muestra el ranking de los 10 mejores jugadores.
	 * Complejidad O(n).
	 * @throws IOException 
	 */
	public void showRanking() throws IOException {
		int i = 0;
		sortRanking();
		while (i < this.cont && i < 10) {
			System.out.print(arrJugadores[i].getPuntuacion() + " " + arrJugadores[i].getNombre() + "\n");
			i++;
		}
	}
	
	/**
	 * Metodo cargarRanking. Este método crea un objeto de tipo CustomReadFile y llama al método que se encarga 
	 * de leer de fichero, que como no podía ser de otra forma se encuentra en la propia clase CustomReadFile 
	 * (de ahí que debamos instanciar un objeto de esa clase).
	 * Complejidad O().
	 */
	public void cargarRanking() {
		
		
	}
	
	/**
	 * Metodo escribirRanking. Este método crea un objeto de tipo CustomWriteFile y llama al método que se encarga 
	 * de escribir en fichero, que como no podía ser de otra forma se encuentra en la propia clase CustomWriteFile. 
	 * Especificamente, este método creará una cadena de tipo String con los jugadores y sus puntuaciones, 
	 * respetando las dos columnas. Esta cadena será pasada por parámetro al método correspondiente en la clase 
	 * CustomWriteFile para que así pueda escribir la información en el fichero. El profesor proporcionará parte 
	 * del código de las clases CustomReadFile, CustomWriteFile, ICustomReadFile, ICustomWriteFile y Pair.
	 * Complejidad O().
	 */
	/*
	public void escribirRanking() throws IOException {
		FileWriter top =  new FileWriter("./src/data/top.txt", true);
		
	     for (int i = 0; i < cont; i++) 
	         top.write(arrJugadores[i].getPuntuacion() + " " + arrJugadores[i].getNombre() + "\n"); 
	
	     System.out.println("Writing successful"); 
	     //close the file  
	     top.close(); 
		
	}
	*/
}
