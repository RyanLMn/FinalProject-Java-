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
	private boolean PoliceArrival;
	private boolean FiretruckArrival;
	private boolean AmbulanceArrival;

	private int locationX;
	private int locationY;

	
	public Event()
	{
		
		emergency=true;
		situation();
		PoliceArrival=false;
		FiretruckArrival=false;
		AmbulanceArrival=false;
	}
	
	public void setPA()
	{
		PoliceArrival=true;
	}
	public void setFA()
	{
		FiretruckArrival=true;
	}
	public void setAA()
	{
		AmbulanceArrival=true;
		
	}

	public boolean Arrival()
	{
		switch(dispatch) {
		case 1:
			return AmbulanceArrival;
		case 2:
			return FiretruckArrival;
		case 3:
			return PoliceArrival;
		case 4:
			return FiretruckArrival && AmbulanceArrival;
		case 5:
			return PoliceArrival && FiretruckArrival;
		case 6:
			return AmbulanceArrival && PoliceArrival;
		default:
			return AmbulanceArrival && FiretruckArrival && PoliceArrival;	
		}	
	}
	public void situation()
	{
	
		Random rand = new Random();
		
		//50 is max 1 is min
		locationX = rand.nextInt(Map.getBuilding().size());
		locationY=rand.nextInt(Map.getBuilding().get(locationX).size());
		
	
		dispatch=rand.nextInt(7)+1;
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
				event = "Arson";
				break;
			
			case 6:
				police=true;
				ambulance=true;
				event = "Armed Robbery";
				break;
			
			case 7:
				police=true;
				ambulance=true;
				firetruck=true;
				event = "Accident";
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