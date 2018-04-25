package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Building {
	private Location location;	
	
	public Building(Location l) { 
		location = l;  //gives the building a location
	}
	
	public int getRow() {
		return location.getRow();  //returns the row that the building is in
	}
	
	public int getCol() {
		return location.getColumn();  //returns the column that the building is in
	}
	
	public Location getLocation() {
		return location;  //returns value of location
	}
}
