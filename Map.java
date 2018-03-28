package EMSSystem;

import java.util.ArrayList;

public class Map {
	private static ArrayList<Building> buildings;
	private static ArrayList<House> house;
	private static ArrayList<Roads> road;
	private static EMT emt;
	private static FireDept fireDept;
	private static Hospital hospital;
	private static Police police;
	private final int numberOfCars = 6;
	
	public Map() {
		buildings = new ArrayList<>();
		house = new ArrayList<>();
		road = new ArrayList<>();
	}
	
	public void build() {
		int number = 1;
		for (int x=0; x < 25; x++) {
			for (int y=0; y < 25; y++) {
				//int rng = Randomizer.getRgen(10);
				Location l = new Location (x,y);
				
				if (x%2==0 && y%2==0) {
					House h = new House (l);
					buildings.add(h);
					
				} else {
					Roads r = new Roads(l, numberOfCars);
					buildings.add(r);
				}
				
			}
		}
	}
	
	public void display() {
		int x;
		int y;
		int count = 1;
		for (Building B: buildings) {
			x = B.getLocation().getRow();
			y = B.getLocation().getColumn();
			if (B instanceof House) {
				System.out.print(" H");
			} else if (B instanceof Roads) {
				System.out.print(" R");
			}
			if (count == 25){
				System.out.print("\n");
				count = 1;
			}
			count++;
		}
	}
	
	public static ArrayList<Building> getBuilding(){
		return buildings;
	}
	
	public static ArrayList<House> getHouse(){
		return house;
	}
	
	public static ArrayList<Roads> getRoad(){
		return road;
	}
}
