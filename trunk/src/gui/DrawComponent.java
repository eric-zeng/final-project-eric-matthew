package gui;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import physicsSim.Thing;

public class DrawComponent extends JComponent{
		private ArrayList<Thing> things;
		
	public DrawComponent(ArrayList<Thing> things){
		
		this.things = things;
		
	}
	
	public void paintComponent(Graphics g){
		for(Thing t : things){
			int x = t.getPoint().x;
			int y = t.getPoint().y;
			int height = t.getRadius();
			int width = t.getRadius();
			
			g.fillOval(x, y, height, width);
		}
	}

}
