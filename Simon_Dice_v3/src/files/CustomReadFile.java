package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Jugador;

/**
 * Clase CustomReadFile. Se encarga de la lectura de los jugadores del fichero.
 * @author crisuroll
 */
public class CustomReadFile extends FileReader implements ICustomReadFile {
	/**
	 * Atributos.
	 */
	private final ArrayList<Jugador> miAL = new ArrayList<Jugador>();
	private Scanner sc;
	
	/**
	 * Constructora CustomReadFile.
	 * @param _fileName recibe el nombre del fichero a leer.
	 * @throws FileNotFoundException
	 */
	public CustomReadFile(String _fileName) throws FileNotFoundException {
		super(_fileName);
		this.sc = new Scanner(this);
	}

	/**
	 * Metodo closeReadFile(). Cierra el fichero utilizado.
	 * Complejidad O(1).
	 */
	public void closeReadFile() throws IOException {
		this.close();
	}
	
	/**
	 * Metodo readPlayers(). Lee el fichero y guarda los jugadores en un ArrayList.
	 * Complejidad O(n).
	 */
	public ArrayList<Jugador> readPlayers() throws FileNotFoundException {
		while(this.sc.hasNextLine()) {
			/* ESTA ES OTRA MANERA DE HACERLO QUE SE ME HA OCURRIDO.
	        String linea = this.sc.nextLine();
			String[] datos = linea.split(" ");
			int punt = Integer.parseInt(datos[0].trim());
			String nom = datos[1].trim();
			Jugador j = new Jugador(nom);
			j.setPuntuacion(punt);
			this.miAL.add(j);
			*/
			int punt = sc.nextInt();
			String nom = sc.next();
			Jugador j = new Jugador(nom);
			j.setPuntuacion(punt);
			this.miAL.add(j);
			this.sc.nextLine(); // Saltamos a la siguiente linea del fichero. Si no, da error.
		}        
		return this.miAL;
	}

}
