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
			if (rngEvent <= 95) {
				event = new Event();
				map.setEvent(event);
				gui.addEvent(event.toString());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				
			}
			gui.update();
		}
	}
}
