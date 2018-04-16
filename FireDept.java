package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class FireDept extends Building {
// array of firetrucks
	
	private int number; //number of fire trucks at station
	
	public FireDept(Location l, int number) {
		super(l);
		this.number = number;
	}
}
