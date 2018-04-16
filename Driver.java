package EMSSystem;

import java.util.ArrayList;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Driver {
	
	public static void main(String[] args){
		Map map;
		GUI gui;
		Event event;
		ArrayList<Event> events = new ArrayList<>();
		
		map  = new Map();
		
		gui = new GUI();
		
		int rngEvent;
		for (int time = 0; time < 2016; time+=5) {
			rngEvent = Randomizer.getRgen(100);
			if (rngEvent <= 5) {
				map.setEvent(new Event());
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				
			}
		}
	}
}
