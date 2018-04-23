package EMSSystem;

import java.util.ArrayList;

/**
 * 
 * @author Ryan Morgan
 *
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
	
	public Map() {
		buildings = new ArrayList<>();
		house = new ArrayList<>();
		road = new ArrayList<>();
		
		build();
	}
	
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
		e= new EMT(l, 5);
		buildings.get(rngx).set(rngy, e);
		
		do {
			rngx = Randomizer.getRgen((buildings.size()/2)+1) * 2;
			rngy = Randomizer.getRgen((buildings.get(0).size()/2)+1) * 2;
		} while (!(buildings.get(rngx).get(rngy) instanceof House));
		l = new Location (rngx,rngy);
		f= new FireDept(l, 3);
		buildings.get(rngx).set(rngy, f);
		
		do {
			rngx = Randomizer.getRgen((buildings.size()/2)+1) * 2;
			rngy = Randomizer.getRgen((buildings.get(0).size()/2)+1) * 2;
		} while (!(buildings.get(rngx).get(rngy) instanceof House));
		l = new Location (rngx,rngy);
		p= new Police(l, 7);
		buildings.get(rngx).set(rngy, p);
		
		do {
			rngx = Randomizer.getRgen((buildings.size()/2)+1) * 2;
			rngy = Randomizer.getRgen((buildings.get(0).size()/2)+1) * 2;
		} while (!(buildings.get(rngx).get(rngy) instanceof House));
		l = new Location (rngx,rngy);
		h= new Hospital(l);
		buildings.get(rngx).set(rngy, h);
		
	}
	
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
	
	public static ArrayList<ArrayList<Building>> getBuilding(){
		return buildings;
	}
	
	public static ArrayList<House> getHouse(){
		return house;
	}
	
	public static ArrayList<Roads> getRoad(){
		return road;
	}
	
	public Location getETMLoc() {
		return e.getLocation();
	}
	
	public Location getFireLoc() {
		return f.getLocation();
	}
	
	public Location getPoliceLoc() {
		return p.getLocation();
	}
	
	public Location getHospitalLoc() {
		return h.getLocation();
	}
	
	public void setEvent(Event event) {
		events.add(event);
		
		
		
	}
	
	public static ArrayList<Event> getEvent() {
		return events;
	}
}
