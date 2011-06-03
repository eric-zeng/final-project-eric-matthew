package physicsSim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.DrawComponent;
import gui.Frame;

public class SwingRunner {
	public static void main(String[] args) {
		
		
//Physics initialization
		
		int width = 640;
		int height = 480;
		
		Physics p = new Physics(width, height);
		/*Thing t = new Thing(1,15,0,4,Color.RED);
		Thing h = new Thing(1,40,-5,4, Color.BLUE);
		h.setPoint(new Point(100, 20));*/
		ArrayList<Thing> things = new ArrayList<Thing>();
		for(int i = 0; i < 1; i++){
			Thing t = new Thing(true);
			things.add(t);
		}
		
//Graphics initialization
		
		
		JFrame f = new Frame(width + 9, height + 35 + 100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		JPanel panel = new JPanel(new BorderLayout());
		JComponent c = new DrawComponent(things, p);
		c.setDoubleBuffered(true);
		panel.add(c);
		panel.setVisible(true);

		f.add(panel);
		
		//JFrame f2 = new Frame(100, 100);
		
	/*	JButton b = new JButton("Hello");
		f2.add(b);
		f2.setVisible(true);*/
	}

}
