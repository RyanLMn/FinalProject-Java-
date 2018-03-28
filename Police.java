package EMSSystem;

public class Police extends Building{
//array of police cars
	
	private int number; // number of police cars at station
	
	public Police(Location l, int number) {
		super(l);
		this.number = number;
	}
}
