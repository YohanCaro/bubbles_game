package co.uptc.bubbles.model.logic;

import java.util.Random;

import co.uptc.bubbles.model.Entity.Bubble;
import co.uptc.bubbles.model.Entity.Coordenate;
import co.uptc.bubbles.model.Entity.WorkSpace;
import co.uptc.bubbles.utilities.Constants;

/**
 * Clase ThreadBubble encargada de crear el hilo de la burbuja
 * Fecha 01/03/2019
 * @author Yohan Caro
 * @version 2.0
 */
public class ThreadBubble extends Thread {
	
	private final long REFRESH_TIME = 50;
	private Bubble bubble;
	private boolean toMove;
	private boolean live;
	private WorkSpace workSpace;
	private boolean tam;
	private double factor;
	
	/**
	 * Crea la bolita 
	 * @param bubble burbuja 
	 * @param workSpace espacio en dond e se puede mover
	 */
	public ThreadBubble(Bubble bubble, WorkSpace workSpace) {
		this.toMove = false;
		this.live = true;
		this.bubble = bubble;
		this.workSpace = workSpace;
		this.tam = false;
		factor = 1500;
		
	}	
	
	/**
	 * Empieza a mover la bolita
	 */
	public void mover() {
		this.toMove = true;
	}
	
	/**
	 * Cambia los valores de la velocidad y el tamaño de la bola
	 */
	public void changeValue() {
		
		if (tam) {
			this.bubble.setSize(this.bubble.getSize() + 0.2);
			this.bubble.setSpeed(factor/this.bubble.getSize());
			factor -= 10;
		} else {
			this.bubble.setSize(this.bubble.getSize() - 0.2);
			this.bubble.setSpeed(factor/this.bubble.getSize());
			factor += 10;
		}
				
		if (this.bubble.getSize() > Constants.BUBBLE_MAX_SIZE) {
			tam = false;
		} 
		if ( this.bubble.getSize() < Constants.BUBBLE_MIN_SIZE) {
			tam = true;
		}		
	}
	
	/**
	 * Speed
	 * @return
	 */
	public double calSpeed() {
		double m =  (this.bubble.getSpeed() - (this.bubble.getSize()/Constants.BUBBLE_MIN_SIZE)) / (this.bubble.getSize() - Constants.BUBBLE_MIN_SIZE);
		double b = (m*this.bubble.getSpeed()/Constants.BUBBLE_MIN_SPEED) - (this.bubble.getSize()/Constants.BUBBLE_MIN_SIZE);
		
		this.bubble.setSpeed( (this.bubble.getSize()/Constants.BUBBLE_MIN_SIZE+b)*Constants.BUBBLE_MIN_SPEED/m );
		
		return ((this.bubble.getSize()/Constants.BUBBLE_MIN_SIZE)+b)*(Constants.BUBBLE_MIN_SIZE/m);
	}
	
	/**
	 * Hilo que mueve la bolita con una velocidad y tiempo determinados
	 */
	@Override
	public void run() {
		
		while (live) {
			while (toMove) {
				this.bubble.move(this.bubble.getSpeed()*REFRESH_TIME/1000);
				returnToWorkSpace();
				changeValue();
				
				try {
					Thread.sleep(REFRESH_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Verifica que la bola vuelva al espacio de juego y la devuleve
	 * si no se encuentra en este.
	 */
	public void returnToWorkSpace() {
		Random rnd = new Random();
		//Regresa si se ha salido del eje X
		if (!workSpace.isIntoXBefore(this.bubble.getCoordenate())) {
			this.bubble.getCoordenate().setX(workSpace.getX() + 0);
			if (workSpace.isIntoCorner(this.bubble.getCoordenate()) == 1) { //Esqina superior izq
				this.bubble.setDirection(this.bubble.getDirection() + Math.toRadians(rnd.nextInt(90) + 271)); 
			} else { //Cualquier otro borde de x
				this.bubble.setDirection(this.bubble.getDirection() + Math.toRadians(rnd.nextInt(90) +1)); 
			}
		} else if (!workSpace.isIntoXAfter(this.bubble.getCoordenate())) {
			this.bubble.getCoordenate().setX(workSpace.getWidth() - 0);
			this.bubble.setDirection(this.bubble.getDirection() + Math.toRadians(rnd.nextInt(180) + 91));
		}
		//Se regresa si ha salido del eje y
		if (!workSpace.isIntoYBefore(this.bubble.getCoordenate())) {
			this.bubble.getCoordenate().setY(workSpace.getY() + 0);
			this.bubble.setDirection(this.bubble.getDirection() + Math.toRadians(rnd.nextInt(180) + 181));
		} else if (!workSpace.isIntoYAfter(this.bubble.getCoordenate())) {
			this.bubble.getCoordenate().setY(workSpace.getHeigth() - 0);
			this.bubble.setDirection(this.bubble.getDirection() + Math.toRadians(rnd.nextInt(180) + 1));
		}

	}
	
	public WorkSpace getWorkSpace() {
		return workSpace;
	}

	public boolean isLive() {
		return live;
	}
	
	public boolean isToMove() {
		return toMove;
	}
	
	public Bubble getBubble() {
		return bubble;
	}
}
