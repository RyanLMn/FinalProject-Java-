package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Roads extends Building{
	private int number; //number of cars allowed on road (6) for now  *OUTDATED, NOT CURRENTLY IN USE*
	private boolean event; //shows if an event if happening on this road *OUTDATED, NOT CURRENTLY IN USE*
	
	public Roads (Location l, int number) {
		super (l);	//passes the location to the constructor of building
		this.number = number; //sets the variable called number
	}
}
