package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Location {
	int row, col; // creates the row and column variables
	
	public Location (int row, int col) {
		this.row = row;  //sets the row value to the value passed to it
		this.col = col;  //sets the column value to the value passes to it
	}
	
	public int getRow() {
		return row;  //returns the row variable
	}
	
	public int getColumn() {
		return col;  //returns the column variable
	}
	
	// return true or false if the location exits at a certain point
	public boolean euquals (Object obj) {
		if (obj instanceof Location) {
			Location other = (Location) obj;
			return row  == other.getRow() && col == other.getColumn();
		} else
			return false;	
	}
}
