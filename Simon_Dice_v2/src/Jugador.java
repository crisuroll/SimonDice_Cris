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
	private int puntos;
	
	/**
	 * Constructora Jugador.
	 * @param _nombre recibe un String con el nombre del jugador.
	 */
	public Jugador(String _nombre) {
		this.nombre = _nombre;
		this.puntuacion = 0;
	}
	
	/**
	 * Metodo getNombre.
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Metodo getPuntuacion.
	 * @return
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	/**
	 * Metodo setNombre.
	 */
	public void setNombre() {
		
	}
	
	/**
	 * Metodo setPuntuacion.
	 */
	public void setPuntuacion(int _puntos) {
		this.puntos = _puntos;
	}
	
}
