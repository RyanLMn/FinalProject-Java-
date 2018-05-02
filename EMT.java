package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class EMT extends Building {
	private ambulance[] ambulances;
	
	// passes the location to the building class, and makes an array of ambulances
	public EMT(Location l, int number) {
		super(l);
		ambulances = new ambulance[number];
		for (int x = 0; x< ambulances.length; x++) {
			ambulances[x] = new ambulance(l);
		}
	}
	
	//returns the array of ambulances
	public ambulance[] returnAmbs() {
		return ambulances;
	}
}
