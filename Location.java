package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Location {
	int row, col;
	
	public Location (int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return col;
	}
	
	public boolean euquals (Object obj) {
		if (obj instanceof Location) {
			Location other = (Location) obj;
			return row  == other.getRow() && col == other.getColumn();
		} else
			return false;	
	}
}
