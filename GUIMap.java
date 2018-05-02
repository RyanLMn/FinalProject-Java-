package EMSSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class GUIMap extends JPanel{
	private int w;
	private int h;
	private final int m = 25;
	
	private final int carSize = 6;

	//private Dimension size;
	
	public GUIMap(int width, int height) {
		w = width;
		h = height;
		//size = new Dimension(0,0);
	}
	
	// paints the map with all buildings and vehicles
	@Override
	public void paintComponent (Graphics g) {
		// shows the basic map
		ArrayList<ArrayList<Building>> buildings = Map.getBuilding();
		for (int x=0; x < buildings.size(); x++) {
			for (int y=0; y < buildings.get(x).size(); y++) {
				Building B = buildings.get(x).get(y);
				int X = x;
				int Y = y;
				X *= m;
				Y *= m;
				if (B instanceof House) {
					g.setColor(Color.GRAY);
					g.fillRect(X, Y, m, m);
				} else if (B instanceof Roads) {
					g.setColor(Color.BLACK);
					g.fillRect(X, Y, m, m);
				} else if (B instanceof EMT) {
					g.setColor(Color.GREEN);
					g.fillRect(X, Y, m, m);
				} else if (B instanceof FireDept) {
					g.setColor(Color.RED);
					g.fillRect(X, Y, m, m);
				} else if (B instanceof Hospital) {
					g.setColor(Color.WHITE);
					g.fillRect(X, Y, m, m);
				} else {
					g.setColor(Color.BLUE);
					g.fillRect(X, Y, m, m);
				}
			}
		}
		
		// shows the events
		for (int i=0; i < Map.getEvent().size() ; i++) {
			int X = Map.getEvent().get(i).getx();
			int Y = Map.getEvent().get(i).gety();
			X *= m;
			Y *= m;
			
			g.setColor(Color.MAGENTA);
			g.fillRect(X, Y, m, m);
		}
		
		ambulance[] ambulances = Map.getAmbs();
		firetruck[] firetrucks = Map.getFTrukcs();
		PoliceCar[] policecars = Map.getPolicecars();
		
		// shows the location of the active ambulances
		for (int i=0; i < ambulances.length; i++) {
			if (ambulances[i].active) {
				int X = ambulances[i].currentlocationX;
				int Y = ambulances[i].currentlocationY;
				X *= m;
				Y *= m;
				for (int x = 0; x < i; x++) {
					if ((ambulances[i].currentlocationX == ambulances[x].currentlocationX) && (ambulances[i].currentlocationY == ambulances[x].currentlocationY))
						X += 9;
				}
				if (X > (ambulances[i].currentlocationX * m + 18)) {
					X = ambulances[i].currentlocationX * m;
					Y += 9;
				}	
				g.setColor(Color.GREEN);
				g.fillRect(X, Y, carSize, carSize);
			}
		}
		
		// shows the location of the active fire trucks 
		for (int i=0; i < firetrucks.length; i++) {
			if (firetrucks[i].active) {
				int X = firetrucks[i].currentlocationX;
				int Y = firetrucks[i].currentlocationY;
				X *= m;
				Y *= m;
				for (int x = 0; x < ambulances.length; x++) {
					if ((firetrucks[i].currentlocationX == ambulances[x].currentlocationX) && (firetrucks[i].currentlocationY == ambulances[x].currentlocationY))
						X += 9;
				}
				for (int x = 0; x < i; x++) {
					if ((firetrucks[i].currentlocationX == firetrucks[x].currentlocationX) && (firetrucks[i].currentlocationY == firetrucks[x].currentlocationY))
						X += 9;
				}
				if (X > (firetrucks[i].currentlocationX * m + 18)) {
					X = firetrucks[i].currentlocationX * m;
					Y += 9;
				}
				g.setColor(Color.RED);
				g.fillRect(X, Y, carSize, carSize);
			}
		}
		
		// shows the location of the active police cars
		for (int i=0; i < policecars.length; i++) {
			if (policecars[i].active) {
				int X = policecars[i].currentlocationX;
				int Y = policecars[i].currentlocationY;
				X *= m;
				Y *= m;
				for (int x = 0; x < ambulances.length; x++) {
					if ((policecars[i].currentlocationX == ambulances[x].currentlocationX) && (policecars[i].currentlocationY == ambulances[x].currentlocationY))
						X += 9;
				}
				for (int x = 0; x < firetrucks.length; x++) {
					if ((policecars[i].currentlocationX == firetrucks[x].currentlocationX) && (policecars[i].currentlocationY == firetrucks[x].currentlocationY)) 
						X += 9;
				}
				for (int x = 0; x < i; x++) {
					if ((policecars[i].currentlocationX == policecars[x].currentlocationX) && (policecars[i].currentlocationY == policecars[x].currentlocationY))
						X += 9;
				}
				if (X > (policecars[i].currentlocationX * m + 18)) {
					X = policecars[i].currentlocationX * m;
					Y += 9;
				}
				g.setColor(Color.BLUE);
				g.fillRect(X, Y, carSize, carSize);
			}
		}
		
	}
	
	public Dimension setPreferredSize(int i, int j) {
		// TODO Auto-generated method stub
		return new Dimension(w,h);
	}
}
