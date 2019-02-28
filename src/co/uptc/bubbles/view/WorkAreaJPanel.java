package co.uptc.bubbles.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import co.uptc.bubbles.model.logic.ThreadBubble;
import co.uptc.structures.simple_list.Cursor;
import co.uptc.structures.simple_list.MySimpleList;

public class WorkAreaJPanel extends JPanel implements Runnable {
	
	private final long REFRES_TIME = 50;
	private BubbleGUI bubbleGUI;
	private MySimpleList<BubbleGUI> bubblesList;
	
	public WorkAreaJPanel(ThreadBubble bubble) {
		this.bubbleGUI = new BubbleGUI(bubble);
		this.bubbleGUI.start();
		this.bubbleGUI.mover();
		this.start();
	}
	
	public WorkAreaJPanel(MySimpleList<ThreadBubble> threads) {
		bubblesList = new MySimpleList<>();
		Cursor<ThreadBubble> cursor = new Cursor<>(threads);
		
		while (!cursor.isOut()) {
			BubbleGUI b = new BubbleGUI(cursor.getInfo());
			b.start();
			b.mover();
			bubblesList.add(b);
			cursor.next();
		}
		
		this.start();
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		bubbleGUI.draw((Graphics2D) g);
		
		Cursor<BubbleGUI> cursor = new Cursor<>(this.bubblesList);
		
		while (!cursor.isOut()) {
			cursor.getInfo().draw((Graphics2D) g);
			cursor.next();
		}
	}
	
//	@Override
//	public void run() {
//		while (bubbleGUI.isToMove()) {
//			try {
//				Thread.sleep(REFRES_TIME);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			this.repaint();
//		}
//	}
	
	@Override
	public void run() {
		Cursor<BubbleGUI> cursor = new Cursor<>(bubblesList);
		while (cursor.getInfo().isToMove()) {
			try {
				Thread.sleep(REFRES_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
			cursor.next();
			if (cursor.isOut()) {
				cursor.reset();
			}
		}
	}
	
	
	

}
