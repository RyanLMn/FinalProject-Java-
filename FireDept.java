package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class FireDept extends Building {
	private firetruck[] Firetrucks;
	
	// defult constuctor, gives the location l to the building class
	public FireDept(Location l, int number) {
		super(l);
		Firetrucks = new firetruck[number];
		for (int x = 0; x< Firetrucks.length; x++) {
			Firetrucks[x] = new firetruck(l);
		}
	}
	
	// returns the array of firetrucks
	public firetruck[] returnFiretrucks () {
		return Firetrucks;
	}
}
