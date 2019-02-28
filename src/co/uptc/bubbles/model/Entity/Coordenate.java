package co.uptc.bubbles.model.Entity;

public class Coordenate {
	
	private double x;
	private double y;
	
	public Coordenate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void move (double distance, double angle) {
		this.x = this.x + distance*Math.cos(angle);
		this.y = this.y + distance*Math.sin(angle);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
