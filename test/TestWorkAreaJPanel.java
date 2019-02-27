import java.awt.Toolkit;

import javax.swing.JFrame;

import co.uptc.bubbles.model.Entity.Bubble;
import co.uptc.bubbles.model.Entity.Coordenate;
import co.uptc.bubbles.model.Entity.WorkSpace;
import co.uptc.bubbles.model.logic.ThreadBubble;
import co.uptc.bubbles.view.WorkAreaJPanel;

public class TestWorkAreaJPanel {

	public static void main(String[] args) {
		Bubble bubble = new Bubble(new Coordenate(250, 250), 50, 500.0, Math.toRadians(45));
		WorkSpace space = new WorkSpace(700, 700, new Coordenate(0, 0));
		ThreadBubble threadBubble = new ThreadBubble(bubble, space);
		
		JFrame frame = new JFrame("WorkAreaJPanel");
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.add(new WorkAreaJPanel(threadBubble));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
