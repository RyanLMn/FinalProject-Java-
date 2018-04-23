package EMSSystem;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class EMT extends Building {
	private ambulance[] ambulances;
	
	
	public EMT(Location l, int number) {
		super(l);
		ambulances = new ambulance[number];
		for (int x = 0; x< ambulances.length; x++) {
			ambulances[x] = new ambulance();
		}
	}
	
	public ambulance[] returnAmbs() {
		return ambulances;
	}
}
