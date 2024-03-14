package main;

import java.io.IOException;

/**
 * Clase Main. Simon Dice, version 3.0 del programa.
 * @author crisuroll
 */
public class Main {
	
	/**
	 * Metodo main. Creacion de un objeto Engine para comenzar el juego con su metodo start().
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Engine eng = new Engine();
		eng.start();
	}
	
}
