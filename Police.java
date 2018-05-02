package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Police extends Building{
	private PoliceCar[] policeCars;  //a new array of police cars
	
	// passes the location to the building class and makes an array of police cars
	public Police(Location l, int number) {
		super(l);
		policeCars = new PoliceCar[number];
		for (int x = 0; x< policeCars.length; x++) {
			policeCars[x] = new PoliceCar(l);
		}
	}
	
	//returns the array of police cars
	public PoliceCar[] returnPolice() {
		return policeCars;
	}
}
