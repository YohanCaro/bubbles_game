package co.uptc.bubbles.utilities;

public class Constants {
	
	public static final int BUBBLE_MAX_SIZE = 70;
	public static final int BUBBLE_MIN_SIZE = 3;
	public static final double BUBBLE_MAX_SPEED = 300;
	public static final double BUBBLE_MIN_SPEED = 50;
	public static final double PERIOD_SIZE = 50;
	public static final double PERIOD_SPEED = 50;
	
	public static double PENDIENTE = (BUBBLE_MAX_SPEED-BUBBLE_MIN_SPEED)/(BUBBLE_MAX_SIZE-BUBBLE_MIN_SIZE);
	public static double B = (PENDIENTE*BUBBLE_MAX_SPEED/BUBBLE_MIN_SPEED) - (BUBBLE_MAX_SIZE/BUBBLE_MIN_SIZE);
	
}
