package co.uptc.bubbles.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import co.uptc.bubbles.model.logic.ThreadBubble;
import co.uptc.structures.simple_list.Cursor;
import co.uptc.structures.simple_list.MySimpleList;

public class WorkAreaJPanel extends JPanel implements Runnable {
	
	private final long REFRES_TIME = 50;
	private BubblesGUIGroup groupBubbles;
	private Cursor<BubbleGUI> cursor;
	
	public WorkAreaJPanel(BubblesGUIGroup bubblesGUIGroup) {
		this.groupBubbles = bubblesGUIGroup;
		this.start();
	}
	
	public WorkAreaJPanel(Cursor<BubbleGUI> cursor) {
		this.cursor = cursor;
		this.start();
	}
	
	public void start() {
		this.cursor.reset();
		new Thread(this).start();
				
		while (!this.cursor.isOut()) {
			this.cursor.getInfo().start();
			this.cursor.nextAndGetInfo().mover();
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		while (!cursor.isOut()) {
			cursor.nextAndGetInfo().draw((Graphics2D) g);
		}
		cursor.reset();
	}
		
	@Override
	public void run() {
//		while (!cursor.isOut()) {
			while (true) {
				try {
					Thread.sleep(REFRES_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.repaint();
			}
//		}
	}
	
	
	

}
