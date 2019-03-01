package co.uptc.bubbles.view;

import java.awt.Graphics2D;

import co.uptc.structures.simple_list.Cursor;
import co.uptc.structures.simple_list.MySimpleList;

public class BubblesGUIGroup extends MySimpleList<BubbleGUI> {
	
	public BubblesGUIGroup(MySimpleList<BubbleGUI> list) {
		super(list);
	}
	
	public BubblesGUIGroup() {
		
	}
	
	public void draw(Graphics2D g2D) {
		//Si se borra da igual .-.
		Cursor<BubbleGUI> cursor = new Cursor<>(this);
		
		while (!cursor.isOut()) {
			cursor.nextAndGetInfo().draw(g2D);
		}
		
	}
	
}
