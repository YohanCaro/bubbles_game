package co.uptc.bubbles.model.Entity;

public class Bubble {

	protected Coordenate coordenate;
	protected double size;
	protected double speed; //Pixel/seg
	protected double direction;
	
	public Bubble(Coordenate coordenate, double size, double speed, double direction) {
		this.coordenate = coordenate;
		this.size = size;
		this.speed = speed;
		this.direction = direction;
	}
	
	public Bubble() {
		
	}
	
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
