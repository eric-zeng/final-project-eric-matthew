package physicsSim;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

import gui.DrawComponent;
import gui.Frame;

public class SwingRunner {

	public static void main(String[] args) {
		
		
//Physics initialization
		
		int height = 640;
		int width = 480;
		
		Physics p = new Physics(height, width);
		Thing t = new Thing(1,10,0,0,Color.RED);
		ArrayList<Thing> things = new ArrayList<Thing>();
		things.add(t);
		
//Graphics initialization
		
		
		JFrame f = new Frame(height, width);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		JComponent c = new DrawComponent(things);
		f.add(c);
	}

}
