package co.uptc.bubbles.model.logic;

import co.uptc.bubbles.model.Entity.Bubble;
import co.uptc.bubbles.model.Entity.Coordenate;
import co.uptc.bubbles.model.Entity.WorkSpace;
import co.uptc.bubbles.utilities.Constants;

public class ThreadBubble extends Thread {
	
	private final long REFRESH_TIME = 50;
	private Bubble bubble;
	private boolean toMove;
	private boolean live;
	private WorkSpace workSpace;
	
	public ThreadBubble(Bubble bubble, WorkSpace workSpace) {
		this.toMove = false;
		this.live = true;
		this.bubble = bubble;
		this.workSpace = workSpace;
	}	
	
	public void mover() {
		this.toMove = true;
	}
	
	//Calcular la velocidad y el tamaño
	public void changeValue() {
		
//		this.bubble.setSize(this.bubble.getSize());
//		this.bubble.setSpeed(this.bubble.getSpeed());
		this.bubble.setSize(Math.random()*Constants.BUBBLE_MAX_SIZE);
		this.bubble.setSpeed(Math.random()*Constants.BUBBLE_MAX_SPEED);
	}
	
	@Override
	public void run() {
		
		while (live) {
			while (toMove) {
				
				this.bubble.move(this.bubble.getSpeed()*REFRESH_TIME/1000);
				if (!workSpace.isInto(this.bubble.getCoordenate())) {
					this.bubble.setDirection(this.bubble.getDirection() + (Math.random()*Math.PI)); 
				}
				changeValue();
				
				try {
					Thread.sleep(REFRESH_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
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
