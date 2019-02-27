import co.uptc.bubbles.model.Entity.Coordenate;
import co.uptc.bubbles.model.Entity.WorkSpace;

public class TestWorkSpace {

	public static void main(String[] args) {
		WorkSpace workSpace = new WorkSpace(1000, 700, new Coordenate(0, 0));
		
		Coordenate coordenate = new Coordenate(1000, 700);
		System.out.println("El punto esta " + (workSpace.isInto(coordenate)?"dentro":"fuera") + " del área de juego!");
		System.out.println("El punto esta " + (workSpace.isIntoX(coordenate)?"dentro":"fuera") + " del área de juego en X!");
		System.out.println("El punto esta " + (workSpace.isIntoY(coordenate)?"dentro":"fuera") + " del área de juego en Y!");
	}

}
