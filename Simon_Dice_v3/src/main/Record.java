package main;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import files.CustomReadFile;
import files.CustomWriteFile; 

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
	public void addPlayer(Jugador _player) { // ESTO SE ELIMINA
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
	 * Metodo cargarRanking. Lee los jugadores del fichero con readPlayers() y los guarda en el array de jugadores arrJugadores.
	 * Complejidad O(n).
	 * @throws FileNotFoundException 
	 */
	/*
	 * Pasar por la constructora el nombre del fichero a leer.
	 */
	public void cargarRanking() throws FileNotFoundException {
		CustomReadFile crf = new CustomReadFile("./src/data/top.txt");
		ArrayList<Jugador> miAL = crf.readPlayers();
		Scanner sc = new Scanner(crf);
		int i = 0;
		while (sc.hasNextLine() || i < this.MAX_JUGADORES) {
			String linea = sc.nextLine();
	        Jugador j = new Jugador(linea);
	        this.arrJugadores[i] = j;
	        i++;
		}
		/*
		 * Recorrer el vector y, por redundante que suene, coger los jugadores del vector y meterlos en el array.
		 * Rellenar hasta que se acabe el vector o || hasta MAX_JUGADORES.
		 */
	}
	
	/**
	 * Metodo escribirRanking. Este método crea un objeto de tipo CustomWriteFile y llama al método que se encarga 
	 * de escribir en fichero, que como no podía ser de otra forma se encuentra en la propia clase CustomWriteFile. 
	 * Especificamente, este método creará una cadena de tipo String con los jugadores y sus puntuaciones, 
	 * respetando las dos columnas. Esta cadena será pasada por parámetro al método correspondiente en la clase 
	 * CustomWriteFile para que así pueda escribir la información en el fichero. El profesor proporcionará parte 
	 * del código de las clases CustomReadFile, CustomWriteFile, ICustomReadFile, ICustomWriteFile y Pair.
	 * Complejidad O(n).
	 */
	/*
	 * Va a ir al primer jugador, coger su puntuación y nombre, y añadirlo al String. Concatena los siguientes
	 * jugadores. Como resultado hay un String enorme. Le decimos a la clase CustomWriteFile que lo escriba
	 * en el fichero, que es el parámetro _chain.
	 */
	
	public void escribirRanking() throws IOException {
		CustomWriteFile cwf =  new CustomWriteFile("./src/data/top.txt");
		String str = "";
		for (int i = 0; i < cont; i++) {
			str = str + (this.arrJugadores[i].getPuntuacion() + " " + this.arrJugadores[i].getNombre() + "\n");  
		}
		cwf.write(str);
	}
}
