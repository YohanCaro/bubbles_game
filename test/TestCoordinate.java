import co.uptc.bubbles.model.Entity.Coordenate;

public class TestCoordinate {

	public static void main(String[] args) {
		Coordenate coordenate = new Coordenate(100, 100);
		coordenate.move(150, Math.toRadians(180));
		System.out.println(coordenate.getX()+ "," + coordenate.getY());
	}

}
