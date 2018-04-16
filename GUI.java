package EMSSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class GUI {
	private static JFrame frame;
	private static Container contentPane;
	private static JList events;
	private GUIMap map;
	
	public GUI() {
		events = new JList();
		
		map = new GUIMap(25, 25);
		map.setBackground(Color.LIGHT_GRAY);
		makeFrame();
	}
	
	public void makeFrame() {
		frame = new JFrame("EMS System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane(events);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		
		frame.setPreferredSize(new Dimension(900, 700));
		
		contentPane.add(scrollPane, BorderLayout.WEST);
		contentPane.add(map, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void update() {
		frame.repaint();
	}
}
