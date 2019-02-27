package co.uptc.bubbles.model.Entity;

public class WorkSpace extends Coordenate {
	
	private double width;
	private double heigth;
	
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
	 * Evaluea si un punto esta en el area de juego en X
	 * @param coor coordenada
	 * @return true si etá
	 */
	public boolean isIntoX(Coordenate coor) {		
		return (coor.getX() >= 0 && coor.getX() <= width);
	}
	
	/**
	 * Evalua si un punto está en el area de juego en Y
	 * @param coor coordenada
	 * @return true si está
	 */
	public boolean isIntoY(Coordenate coor) {
		return (coor.getY() >= 0 && coor.getY() <= heigth);
	}

}
