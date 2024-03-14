package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import files.CustomReadFile;
import files.CustomWriteFile; 

/**
 * Clase Record. Utilizada para el control del ranking.
 * @author crisuroll
 */
public class Record {
	/**
	 * Artibutos
	 */
	final private int MAX_JUGADORES;
	private int cont;
	private Jugador[] arrJugadores;
	
	/**
	 * Constructora Record.
	 */
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
	 * Metodo getPlayer. Recibe un String y retorna un objeto Jugador. METODO NO UTILIZADO.
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
	        for (int j = 0; j < this.cont - i - 1; j++) {
	            if (this.arrJugadores[j].getPuntuacion() < this.arrJugadores[j + 1].getPuntuacion()) {
	                acu = this.arrJugadores[j + 1];
	                this.arrJugadores[j + 1] = this.arrJugadores[j];
	                this.arrJugadores[j] = acu;
	            }
	        }
	    }
	}
	
	/**
	 * Metodo showBestPlayer. Muestra el jugador (o jugadores) con la puntuación mas alta.
	 * Complejidad O(n).
	 */
	public void showBestPlayer() {
		sortRanking();
		int i = 0;
	    while (i < this.cont && this.arrJugadores[i].getPuntuacion() == this.arrJugadores[0].getPuntuacion()) {
			System.out.print(this.arrJugadores[i].getPuntuacion() + " " + this.arrJugadores[i].getNombre() + "\n");
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
			System.out.print(this.arrJugadores[i].getPuntuacion() + " " + this.arrJugadores[i].getNombre() + "\n");
			i++;
		}
	}
	
	/**
	 * Metodo cargarRanking. Lee los jugadores del fichero con readPlayers() y los guarda en el array arrJugadores[].
	 * Complejidad O(n).
	 * @throws IOException 
	 */
	public void cargarRanking() throws IOException {
		CustomReadFile crf = new CustomReadFile("./src/data/top.txt");
		ArrayList<Jugador> miAL = crf.readPlayers();
		int i = 0;
		int size = miAL.size();
		while (i < size && i < this.MAX_JUGADORES) {
	        Jugador j = miAL.get(i);
	        addPlayer(j);
	        i++;
		}
		crf.closeReadFile();
	}
	
	/**
	 * Metodo escribirRanking. Escribe en fichero los jugadores almacenados en arrJugadores[].
	 * Complejidad O(n).
	 */
	public void escribirRanking() throws IOException {
		CustomWriteFile cwf =  new CustomWriteFile("./src/data/top.txt");
		String str = "";
		for (int i = 0; i < cont; i++) {
			str = str + (this.arrJugadores[i].getPuntuacion() + " " + this.arrJugadores[i].getNombre() + "\n");  
		}
		cwf.writePlayers(str);
		cwf.closeWriteFile();
	}
}
