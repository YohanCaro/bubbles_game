import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;

import co.uptc.bubbles.model.Entity.Bubble;
import co.uptc.bubbles.model.Entity.Coordenate;
import co.uptc.bubbles.model.Entity.WorkSpace;
import co.uptc.bubbles.model.logic.ThreadBubble;
import co.uptc.bubbles.utilities.Constants;
import co.uptc.bubbles.view.BubbleGUI;
import co.uptc.bubbles.view.BubblesGUIGroup;
import co.uptc.bubbles.view.WorkAreaJPanel;
import co.uptc.structures.simple_list.Cursor;
import co.uptc.structures.simple_list.MySimpleList;

public class TestWorkAreaJPanel {

	public static void main(String[] args) {
		int numberBubbles = 30; 
		int width = 1000;
		int heigth = 680;
		int posArea = 10;
		
		Random rnd = new Random();
		WorkSpace space = new WorkSpace(width, heigth, new Coordenate(posArea, posArea));
		BubblesGUIGroup list = new BubblesGUIGroup();
		
		for (int i = 0; i < numberBubbles; i++) {
			list.add(new BubbleGUI(new ThreadBubble(
					new Bubble(new Coordenate(rnd.nextInt(width-posArea), rnd.nextInt(heigth-posArea)),
							rnd.nextInt((Constants.BUBBLE_MAX_SIZE -Constants.BUBBLE_MIN_SIZE)+Constants.BUBBLE_MIN_SIZE),
							rnd.nextInt((int) ((Constants.BUBBLE_MAX_SPEED -Constants.BUBBLE_MIN_SPEED)+Constants.BUBBLE_MIN_SPEED)),
							rnd.nextInt(360)) , space)));
		}
		Cursor<BubbleGUI> cursor = new Cursor<>(list);
		
		JFrame frame = new JFrame("WorkAreaJPanel");
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.add(new WorkAreaJPanel(cursor));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
