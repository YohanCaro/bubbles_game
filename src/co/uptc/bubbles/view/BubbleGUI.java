package co.uptc.bubbles.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import co.uptc.bubbles.model.Entity.Bubble;
import co.uptc.bubbles.model.logic.ThreadBubble;

public class BubbleGUI extends ThreadBubble {
	
	private Color color;

	public BubbleGUI(ThreadBubble threadBubble) {
		super(threadBubble.getBubble(), threadBubble.getWorkSpace());
		Random rnd = new Random();
		this.color = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval((int)this.getBubble().getCoordenate().getX(), (int)this.getBubble().getCoordenate().getY(),
				(int)this.getBubble().getSize(), (int)this.getBubble().getSize());
		g.drawRect(0, 0, 1050, 720);
	}

}
