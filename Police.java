package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Police extends Building{
	private PoliceCar[] policeCars;
	
	public Police(Location l, int number) {
		super(l);
		policeCars = new PoliceCar[number];
		for (int x = 0; x< policeCars.length; x++) {
			policeCars[x] = new PoliceCar();
		}
	}
	
	public PoliceCar[] returnPolice() {
		return policeCars;
	}
}
