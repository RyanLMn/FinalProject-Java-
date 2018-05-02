package EMSSystem;
 
public class PoliceCar extends Dispatch{ //subclass of dispatch, specifies PoliceCars
	public PoliceCar(Location l) //Sets home location for the policeCar, in which case wherever the police station spawns on map.
	{
		super(l);
		size=1; //size not implemented in program
	
	}
}
