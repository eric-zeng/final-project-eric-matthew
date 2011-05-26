package physicsSim;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;

import gui.DrawComponent;
import gui.Frame;

public class SwingRunner {

	public static void main(String[] args) {
		
		//Swing initialization
		JFrame f = new Frame(640, 480);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		JComponent c = new DrawComponent();
		f.add(c);
		
		//Physics initialization
		
		Physics p = new Physics();
		Thing t = new Thing(1,10,0,0,Color.RED);
		
		

	}

}
