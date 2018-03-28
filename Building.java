package EMSSystem;

public class Building {
	private Location location;	
	
	public Building(Location l) {
		location = l;
	}
	
	public int getRow() {
		return location.getRow();
	}
	
	public int getCol() {
		return location.getColumn();
	}
	
	public Location getLocation() {
		return location;
	}
}
