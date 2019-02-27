package co.uptc.bubbles.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import co.uptc.bubbles.model.logic.ThreadBubble;

public class WorkAreaJPanel extends JPanel implements Runnable {
	
	private final long REFRES_TIME = 50;
	private BubbleGUI bubbleGUI;
	
	public WorkAreaJPanel(ThreadBubble bubble) {
		this.bubbleGUI = new BubbleGUI(bubble);
		this.bubbleGUI.start();
		this.bubbleGUI.mover();
		this.start();
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		bubbleGUI.draw((Graphics2D) g);
	}
	
	@Override
	public void run() {
		while (bubbleGUI.isToMove()) {
			try {
				Thread.sleep(REFRES_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
	
	
	

}
