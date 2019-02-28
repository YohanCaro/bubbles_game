import co.uptc.bubbles.model.Entity.Coordenate;

public class TestCoordinate {

	public static void main(String[] args) {
		Coordenate coordenate = new Coordenate(0, 0);
		coordenate.move(100, Math.toRadians(45));
		System.out.println(coordenate.getX()+ "," + coordenate.getY());
		
	}

}
