package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Roads extends Building{
	private int number; //number of cars allowed on road (6) for now
	private boolean event;
	
	public Roads (Location l, int number) {
		super (l);
		this.number = number;
	}
}
