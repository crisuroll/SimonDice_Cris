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
	 * Constructora Jugador.
	 * @param _nombre recibe un String con el nombre del jugador.
	 */
	public Jugador(String _nombre) {
		this.nombre = _nombre;
		this.puntuacion = 0;
	}
	
	/**
	 * Metodo getNombre.
	 * @return nombre.
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Metodo getPuntuacion.
	 * @return puntuacion.
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	/**
	 * Metodo setNombre.
	 */
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	
	/**
	 * Metodo setPuntuacion.
	 */
	public void setPuntuacion(int _puntuacion) {
		this.puntuacion = _puntuacion;
	}
	
}
