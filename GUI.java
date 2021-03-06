package EMSSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.DefaultCaret;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class GUI {
	private static JFrame frame;
	private static Container contentPane;
	private static JTextArea events;
	private GUIMap map;
	
	// default constructor
	public GUI() {
		events = new JTextArea();
		events.setEnabled(false);
		events.setDisabledTextColor(Color.BLACK);
		
		map = new GUIMap(25, 25);
		map.setBackground(Color.LIGHT_GRAY);
		makeFrame();
	}
	
	// makes the frame, scroll pane, and sets the layout for the gui
	public void makeFrame() {
		frame = new JFrame("EMS System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane(events);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		
		DefaultCaret caret = (DefaultCaret)events.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		
		
		frame.setPreferredSize(new Dimension(845, 675));
		
		contentPane.add(scrollPane, BorderLayout.WEST);
		contentPane.add(map, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	// updates the map
	public void update() {
		frame.repaint();
	}
	
	// adds events to the scroll pane
	public void addEvent(String event) {
		String s;
		StringBuilder x = new StringBuilder();
		
		x.append(events.getText());
		x.append("\n");
		x.append(event);
		
		s = new String(x);
		events.setText("");
		events.append(s);
	}
}
