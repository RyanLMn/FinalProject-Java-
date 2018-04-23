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

	//private Dimension size;
	
	public GUIMap(int width, int height) {
		w = width;
		h = height;
		//size = new Dimension(0,0);
	}
	
	@Override
	public void paintComponent (Graphics g) {
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
		
		for (int i=0; i < Map.getEvent().size() ; i++) {
			int X = Map.getEvent().get(i).getx();
			int Y = Map.getEvent().get(i).gety();
			X *= m;
			Y *= m;
			
			g.setColor(Color.MAGENTA);
			g.fillRect(X, Y, m, m);
		}
	}
	
	public Dimension setPreferredSize(int i, int j) {
		// TODO Auto-generated method stub
		return new Dimension(w,h);
	}
}
