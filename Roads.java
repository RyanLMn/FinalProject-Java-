package EMSSystem;

public class Roads extends Building{
	private int number; //number of cars allowed on road (6) for now
	
	public Roads (Location l, int number) {
		super (l);
		this.number = number;
	}
}
