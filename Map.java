package EMSSystem;

import java.util.ArrayList;

/**
 * 
 * @author Ryan Morgan
 *
 * the row and column values are backwards
 */

public class Map {
	private static ArrayList<ArrayList<Building>> buildings;
	private static ArrayList<House> house;
	private static ArrayList<Roads> road;
	private static EMT e;
	private static FireDept f;
	private static Police p;
	private static Hospital h;
	private static boolean emt = false, fire = false, police = false, hospital = false;
	private final int numberOfCars = 6;
	
	private static ArrayList<Event> events = new ArrayList<>();
	
	// Constructor
	public Map() {
		buildings = new ArrayList<>();
		house = new ArrayList<>();
		road = new ArrayList<>();
		
		build();
	}
	
	// builds the map by creating the roads, houses, and emergency buildings
	public void build() {
		int number = 1;
		
		for (int x=0; x < 25; x++) {
			buildings.add(new ArrayList<Building>());
			for (int y=0; y < 25; y++) {
				Location l = new Location (x,y);
				
				if (x%2==0 && y%2==0) {
					House h = new House (l);
					buildings.get(x).add(h);
				} else {
					Roads r = new Roads(l, numberOfCars);
					buildings.get(x).add(r);
				}
				
			}
		}
		int rngx;
		int rngy;
		do {
			rngx = Randomizer.getRgen((buildings.size()/2)+1) * 2;
			rngy = Randomizer.getRgen((buildings.get(0).size()/2)+1) * 2;
		} while (!(buildings.get(rngx).get(rngy) instanceof House));
		Location l = new Location (rngx,rngy);
		h= new Hospital(l);
		buildings.get(rngx).set(rngy, h);
		
		do {
			rngx = Randomizer.getRgen((buildings.size()/2)+1) * 2;
			rngy = Randomizer.getRgen((buildings.get(0).size()/2)+1) * 2;
		} while (!(buildings.get(rngx).get(rngy) instanceof House));
		l = new Location (rngx,rngy);
		e= new EMT(l, 10);
		buildings.get(rngx).set(rngy, e);
		
		do {
			rngx = Randomizer.getRgen((buildings.size()/2)+1) * 2;
			rngy = Randomizer.getRgen((buildings.get(0).size()/2)+1) * 2;
		} while (!(buildings.get(rngx).get(rngy) instanceof House));
		l = new Location (rngx,rngy);
		f= new FireDept(l, 10);
		buildings.get(rngx).set(rngy, f);
		
		do {
			rngx = Randomizer.getRgen((buildings.size()/2)+1) * 2;
			rngy = Randomizer.getRgen((buildings.get(0).size()/2)+1) * 2;
		} while (!(buildings.get(rngx).get(rngy) instanceof House));
		l = new Location (rngx,rngy);
		p= new Police(l, 10);
		buildings.get(rngx).set(rngy, p);
		
	}
	
	// print a text version of the map to the console window, does not show the vehicles
	public void display() {
		for (int x=0; x < buildings.size(); x++) {
			for (int y=0; y < buildings.get(x).size(); y++) {
				Building B = buildings.get(x).get(y);
				if (B instanceof House) {
					System.out.print(" B");
				} else if (B instanceof Roads) {
					System.out.print(" R");
				} else if (B instanceof EMT) {
					System.out.print(" E");
				} else if (B instanceof FireDept) {
					System.out.print(" F");
				} else if (B instanceof Hospital) {
					System.out.print(" H");
				} else if (B instanceof Police) {
					System.out.print(" P");
				}
			}
			System.out.print("\n");
		}
	}
	
	// return the arraylist of arraylist of buildings
	public static ArrayList<ArrayList<Building>> getBuilding(){
		return buildings;
	}
	
	// return the arraylist of houses
	public static ArrayList<House> getHouse(){
		return house;
	}
	
	// return the arraylist of roads
	public static ArrayList<Roads> getRoad(){
		return road;
	}
	
	// returns the location of the EMT building
	public static Location getETMLoc() {
		return e.getLocation();
	}
	
	// returns the location of the Fire Dept.
	public static Location getFireLoc() {
		return f.getLocation();
	}
	
	// returns the location of the police station
	public static Location getPoliceLoc() {
		return p.getLocation();
	}
	
	//returns the location of the hospital
	public static Location getHospitalLoc() {
		return h.getLocation();
	}
	
	// adds events to the "events" arraylist and passes the location of the event to available emergency vehicles
	public void setEvent(Event event) {
		events.add(event);
		if (event.getFireTruck()) {
			for(int x=0; x < f.returnFiretrucks().length; x++) {
				if (!f.returnFiretrucks()[x].getActive()) {
					f.returnFiretrucks()[x].setActive();
					f.returnFiretrucks()[x].setElocationX(event.getx());
					f.returnFiretrucks()[x].setElocationY(event.gety());
					f.returnFiretrucks()[x].setEvent(event);
					break;
				}
			}
		}
		
		if (event.getPolice()) {
			for(int x=0; x < p.returnPolice().length; x++) {
				if (!p.returnPolice()[x].getActive()) {
					p.returnPolice()[x].setActive();
					p.returnPolice()[x].setElocationX(event.getx());
					p.returnPolice()[x].setElocationY(event.gety());
					p.returnPolice()[x].setEvent(event);
					break;
				}
			}
		}
		
		if (event.getAmbulance()) {
			for (int x=0; x < e.returnAmbs().length; x++) {
				if (!e.returnAmbs()[x].getActive()) {
					e.returnAmbs()[x].setActive();
					e.returnAmbs()[x].setDropOff();
					e.returnAmbs()[x].setElocationX(event.getx());
					e.returnAmbs()[x].setElocationY(event.gety());
					e.returnAmbs()[x].setEvent(event);
					break;
				}
			}
		}
		
	}
	
	// removes events from the arraylist once the event has ended
	public void removeEvent() {
		for (int x=0; x < events.size(); x++) {
			if (!events.get(x).getEmergency()) {
				events.remove(x);
			}
		}
	}
	
	// makes the emergency vehicles respond to the event
	public void respond() {
		for(int x=0; x < f.returnFiretrucks().length; x++) {
			f.returnFiretrucks()[x].Respond();
		}
		
		for (int x=0; x < p.returnPolice().length; x++) {
			p.returnPolice()[x].Respond();
		}
		
		for (int x=0; x < e.returnAmbs().length; x++) {
			e.returnAmbs()[x].Respond();
		}
		
		for (int x=0; x<events.size(); x++) {
			events.get(x).Arrival();
		}
	}
	
	
	// returns the arraylist of events
	public static ArrayList<Event> getEvent() {
		return events;
	}
	
	//returns the array of ambulances
	public static ambulance[] getAmbs() {
		return e.returnAmbs();
	}
	
	//returns the array of fire trucks
	public static firetruck[] getFTrukcs() {
		return f.returnFiretrucks();
	}
	
	// returns the array of police cars
	public static PoliceCar[] getPolicecars() {
		return p.returnPolice();
	}
}
