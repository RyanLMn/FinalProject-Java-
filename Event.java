package EMSSystem;

import java.util.Random;
public class Event {
	private boolean ambulance;
	private boolean firetruck; 
	private boolean police; 
	private boolean emergency; 
	private int dispatch;
	private boolean end;
	private String event;

	private int locationX;
	private int locationY;

	
	public Event()
	{
		
		emergency=true;
		situation();
	}

	public void situation()
	{
	
		Random rand = new Random();
		
		//50 is max 1 is min
		locationX = rand.nextInt(Map.getBuilding().size());
		locationY=rand.nextInt(Map.getBuilding().get(locationX).size());
		
	
		dispatch=rand.nextInt(8)+1;
		switch(dispatch){
			case 1:
				ambulance=true;
				event = "Injury";
				break;
		
			case 2: 
				firetruck=true;
				event = "Cat Stuck in tree";
				break;
		
			case 3:
				police=true;
				event = "Crime";
				break;
			
			case 4:
				ambulance=true;
				firetruck=true;
				event = "Fire";
				break;
			
			case 5:
				firetruck=true;
				police=true;
				event = "???";
				break;
			
			case 6:
				police=true;
				ambulance=true;
				event = "???";
				break;
			
			case 7:
				police=true;
				ambulance=true;
				firetruck=true;
				event = "???";
				break;
		}
	}
	
	public boolean getAmbulance() {
		return ambulance;
	}
	
	public boolean getFireTruck() {
		return firetruck;
	}
	
	public boolean getPolice() {
		return police;
	}
	
	public boolean getEmergency() {
		return emergency;
	}
	
	public int getx() {
		return locationX;
	}
	
	public int gety() {
		return locationY;
	}
	
	public String toString() {
		String loc;
		loc = "(" + Integer.toString(locationX) + "," + Integer.toString(locationY) + ")";
		event += " at " + loc + "\n";
		return event;
	}
}