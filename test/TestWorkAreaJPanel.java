import java.awt.Toolkit;

import javax.swing.JFrame;

import co.uptc.bubbles.model.Entity.Bubble;
import co.uptc.bubbles.model.Entity.Coordenate;
import co.uptc.bubbles.model.Entity.WorkSpace;
import co.uptc.bubbles.model.logic.ThreadBubble;
import co.uptc.bubbles.view.WorkAreaJPanel;
import co.uptc.structures.simple_list.MySimpleList;

public class TestWorkAreaJPanel {

	public static void main(String[] args) {
		Bubble bubble = new Bubble(new Coordenate(250, 250), 51, 500.0, Math.toRadians(45));
		WorkSpace space = new WorkSpace(1000, 600, new Coordenate(100, 100));
		ThreadBubble threadBubble = new ThreadBubble(bubble, space);
		
		MySimpleList<ThreadBubble> list = new MySimpleList<>();
		
		list.add(new ThreadBubble(new Bubble(new Coordenate(250, 250), 20, 100, Math.toRadians(45)) , space));
		list.add(new ThreadBubble(new Bubble(new Coordenate(10, 400), 30, 100, Math.toRadians(45)) , space));
		list.add(new ThreadBubble(new Bubble(new Coordenate(500, 300), 40, 100, Math.toRadians(45)) , space));
		
		JFrame frame = new JFrame("WorkAreaJPanel");
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//		frame.add(new WorkAreaJPanel(threadBubble));
		frame.add(new WorkAreaJPanel(list));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
