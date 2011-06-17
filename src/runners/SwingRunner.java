package runners;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import physicsSim.Physics;
import physicsSim.Thing;

import gui.DrawComponent;
import gui.Frame;
import gui.menuPanel;

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
			t.setId(things.size());
		}
		
//Graphics initialization
		
		
		JFrame f = new Frame(width + 9, height + 35);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		JPanel panel = new JPanel(new BorderLayout());
		JComponent c = new DrawComponent(things, p);
		c.setDoubleBuffered(true);
		panel.add(c);
		panel.setVisible(true);

		f.add(panel);
		
		JFrame f2 = new Frame(250, 300);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setLocation(width + 9,0);
		
		JPanel menuPanel = new menuPanel(c);
	//	menuPanel.add(new MenuComponent());
	//	JButton b = new JButton("hi");
	//	menuPanel.add(b);
		f2.add(menuPanel);
		f2.setVisible(true);
		((DrawComponent) c).menuPanelAddToTotal((menuPanel)menuPanel);
		
		//f2.add(new JButton("hello"));
	}

}
