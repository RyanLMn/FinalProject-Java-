package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class EMT extends Building {
//array of ambulances
	private int number; // number of ambulances at station
	
	public EMT(Location l, int number) {
		super(l);
		this.number = number;
	}
}
