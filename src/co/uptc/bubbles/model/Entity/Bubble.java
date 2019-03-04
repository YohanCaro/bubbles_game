package co.uptc.bubbles.model.Entity;

/**
 * Clase Bubble creadora de la burbuja (model)
 * Fecha 01/03/2019
 * @author Yohan Caro
 * @version 1.0
 */
public class Bubble {

	protected Coordenate coordenate;
	protected double size;
	protected double speed; //Pixel/seg
	protected double direction;
	
	/**
	 * Constructor que inicaliza:
	 * @param coordenate coordenada
	 * @param size tamaño
	 * @param speed velocidad
	 * @param direction direccion
	 */
	public Bubble(Coordenate coordenate, double size, double speed, double direction) {
		this.coordenate = coordenate;
		this.size = size;
		this.speed = speed;
		this.direction = direction;
	}
	
	/**
	 * Constructor vacio
	 */
	public Bubble() {
		
	}
	
	/**
	 * Mueve las coordenadas de la bolita
	 * @param distance distancia a la que se mueve
	 */
	public void move(double distance) {
		this.coordenate.move(distance, this.direction);
	}
	
	public Coordenate getCoordenate() {
		return coordenate;
	}
	
	public double getSize() {
		return size;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public double getDirection() {
		return direction;
	}

	public void setCoordenate(Coordenate coordenate) {
		this.coordenate = coordenate;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}
	
}
