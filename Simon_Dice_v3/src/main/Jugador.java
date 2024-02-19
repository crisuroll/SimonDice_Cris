package main;
/**
 * Clase Jugador. Usada para crear jugadores, almacenando su nombre y puntuacion.
 * @author crisuroll
 */
public class Jugador {

	/**
	 * Atributos.
	 */
	private String nombre;
	private int puntuacion;
	
	/**
	 * Constructora Jugador. Recibe el nombre del jugador e inicializa por defecto la puntuacion a 0.
	 * @param _nombre recibe un String con el nombre del jugador.
	 */
	public Jugador(String _nombre) {
		this.nombre = _nombre;
		this.puntuacion = 0;
	}
	
	/**
	 * Metodo getNombre. Devuelve el nombre del jugador.
	 * @return nombre.
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Metodo getPuntuacion. Devuelve la puntuacion del jugador.
	 * @return puntuacion.
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	/**
	 * Metodo setNombre. Recibe el nombre del jugador y lo inicializa.
	 */
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	
	/**
	 * Metodo setPuntuacion. Recibe la puntuacion del jugador y la inicializa.
	 */
	public void setPuntuacion(int _puntuacion) {
		this.puntuacion = _puntuacion;
	}
	
}
