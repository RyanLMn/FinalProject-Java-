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
	private int counter;

	private int locationX;
	private int locationY;

	// default constructor that sets variables and calls situation
	public Event()
	{
		
		emergency=true;
		situation();
		PoliceArrival=false;
		FiretruckArrival=false;
		AmbulanceArrival=false;
	}
	
	// set to true when the ppolice car arives at the event
	public void setPA()
	{
		PoliceArrival=true;
	}
	
	// set to true when the firetruck arrives at the event
	public void setFA()
	{
		FiretruckArrival=true;
	}
	
	// set to true when the ambulance arrives at the event
	public void setAA()
	{
		AmbulanceArrival=true;
		
	}
	
	// returns true when all of the emercency vehicles for an event arrive
	public boolean Arrival()
	{
		boolean arrived = false;
		switch(dispatch) {
		case 1:
			arrived = AmbulanceArrival;
			break;
		case 2:
			arrived = FiretruckArrival;
			break;
		case 3:
			arrived = PoliceArrival;
			break;
		case 4:
			arrived = FiretruckArrival && AmbulanceArrival;
			break;
		case 5:
			arrived = PoliceArrival && FiretruckArrival;
			break;
		case 6:
			arrived = AmbulanceArrival && PoliceArrival;
			break;
		case 7:
			arrived = AmbulanceArrival && FiretruckArrival && PoliceArrival;
			break;
		}
		if (arrived) {
			counter--;
			if (counter == 0)
				emergency = false;
		}
		return arrived;
	}
	
	// sets the events randomly around the map when called
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
				counter = 2;
				break;
		
			case 2: 
				firetruck=true;
				event = "Cat Stuck in tree";
				counter = 1;
				break;
		
			case 3:
				police=true;
				event = "Crime";
				counter = 3;
				break;
			
			case 4:
				ambulance=true;
				firetruck=true;
				event = "Fire";
				counter = 4;
				break;
			
			case 5:
				firetruck=true;
				police=true;
				event = "Arson";
				counter = 4;
				break;
			
			case 6:
				police=true;
				ambulance=true;
				event = "Armed Robbery";
				counter = 5;
				break;
			
			case 7:
				police=true;
				ambulance=true;
				firetruck=true;
				event = "Accident";
				counter = 7;
				break;
		}
	}
	
	// returns the value of the variable ambulance
	public boolean getAmbulance() {
		return ambulance;
	}
	
	
	// returns the value of the variable firetruck
	public boolean getFireTruck() {
		return firetruck;
	}
	
	// returns the value of the variable police
	public boolean getPolice() {
		return police;
	}
	
	// returns the emergency value
	public boolean getEmergency() {
		return emergency;
	}
	
	// set the emergency value of the event to show when the event ends
	public void setEmergency() {
		emergency = false;
	}
	
	// return the x loation of the event
	public int getx() {
		return locationX;
	}
	
	// return the y location of the event
	public int gety() {
		return locationY;
	}
	
	//return the coordinates of the event
	public String toString() {
		String loc;
		loc = "(" + Integer.toString(locationX+1) + "," + Integer.toString(locationY+1) + ")";
		event += " at " + loc + "\n";
		return event;
	}
}