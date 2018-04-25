package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class FireDept extends Building {
	private firetruck[] Firetrucks;
	
	public FireDept(Location l, int number) {
		super(l);
		Firetrucks = new firetruck[number];
		for (int x = 0; x< Firetrucks.length; x++) {
			Firetrucks[x] = new firetruck(l);
		}
	}
	
	public firetruck[] returnFiretrucks () {
		return Firetrucks;
	}
}
