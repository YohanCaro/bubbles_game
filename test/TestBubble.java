import co.uptc.bubbles.model.Entity.Bubble;
import co.uptc.bubbles.model.Entity.Coordenate;
import co.uptc.bubbles.model.Entity.WorkSpace;
import co.uptc.bubbles.model.logic.ThreadBubble;

public class TestBubble {

	public static void main(String[] args) {
		Bubble bubble = new Bubble(new Coordenate(100, 100), 50, 100.0, Math.toRadians(60));
		WorkSpace space = new WorkSpace(1000, 700, new Coordenate(0, 0));
		ThreadBubble threadBubble = new ThreadBubble(bubble, space);
		threadBubble.start();		
		threadBubble.mover();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					System.out.println(threadBubble.getBubble().getCoordenate().getX() + " , " 
				+ threadBubble.getBubble().getCoordenate().getY());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
