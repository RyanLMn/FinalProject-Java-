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
			if (rngEvent <= 10) {  //chance of an event being created.
				event = new Event();  //Creates a new event
				map.setEvent(event);  //Add the new event to the arraylist of events in the map class
				gui.addEvent(event.toString()); //Sends the event to the gui class to add it to the scroll pane
			}
			try {
				Thread.sleep(1000);  //time between ticks *REMEMBER 1000 = 1 second
			} catch (InterruptedException ex) {
			}
			map.respond();
			map.removeEvent();
			gui.update();
		}
	}
}
