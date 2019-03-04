package co.uptc.bubbles.model.Entity;

import co.uptc.bubbles.utilities.Constants;

/**
 * Clase WorkSpace encargada de crear el espacio de juego en el modelo
 * Fecha 01/02/2019
 * @author Yohan Caro
 * @version 1.1
 */
public class WorkSpace extends Coordenate {
	
	private double width;
	private double heigth;
	
	/**
	 * Constructor que crea el espacio de tarabajo con
	 * @param width el ancho
	 * @param heigth el alto
	 * @param coor la coordenada en donde empieza
	 */
	public WorkSpace(double width, double heigth, Coordenate coor) {
		super(coor.getX(), coor.getY());
		this.heigth = heigth;
		this.width = width;
	}
	
	/**
	 * Evalua si un punto está dentro del area de juego
	 * @param coor coordenada
	 * @return true si está
	 */
	public boolean isInto(Coordenate coor) {
		return (coor.getX() >= this.getX() && coor.getX() <= width && coor.getY() >= this.getY() && coor.getY() <= heigth);
	}
	
	/**
	 * Evaluea si un punto esta antes en el area de juego en X
	 * @param coor coordenada
	 * @return true si etá
	 */
	public boolean isIntoXBefore(Coordenate coor) {		
		return (coor.getX() >= this.getX());
	}
	
	/**
	 * Evaluea si un punto esta antes en el area de juego en X
	 * @param coor coordenada
	 * @return true si etá
	 */
	public boolean isIntoXAfter(Coordenate coor) {		
		return (coor.getX() <= width);
	}
	
	/**
	 * Evalua si un punto está antes en el area de juego en Y
	 * @param coor coordenada
	 * @return true si está
	 */
	public boolean isIntoYBefore(Coordenate coor) {
		return (coor.getY() >= this.getY());
	}
	
	/**
	 * Evalua si un punto está antes en el area de juego en Y
	 * @param coor coordenada
	 * @return true si está
	 */
	public boolean isIntoYAfter(Coordenate coor) {
		return (coor.getY() <= heigth);
	}
	
	/**
	 * Muestra en que  esquina se encuentra un punto (si no esta devuelve 0)
	 * @param coor coordenada del punto
	 * @return n el numero con la esquina (1 sup-izq, 2 sup-der, 3 inf-izq, 4 inf-der)
	 */
	public byte isIntoCorner(Coordenate coor) {
		byte n = 0;
		if (coor.getX() <= Constants.BUBBLE_MAX_SIZE && coor.getY() <= Constants.BUBBLE_MAX_SIZE) {
			n = 1;
		} else if (coor.getX() > (this.width - Constants.BUBBLE_MAX_SIZE) && coor.getY() <= Constants.BUBBLE_MAX_SIZE) {
			n = 2;
		} else if (coor.getX() < Constants.BUBBLE_MAX_SIZE && coor.getY() > (this.heigth - Constants.BUBBLE_MAX_SIZE)) {
			n = 3;
		} else if (coor.getX() > (this.width - Constants.BUBBLE_MAX_SIZE) && coor.getY() > (this.heigth - Constants.BUBBLE_MAX_SIZE)) {
			n = 4;
		}		
		return n;
	}
	

	
	public double getHeigth() {
		return heigth;
	}
	
	public double getWidth() {
		return width;
	}

}
