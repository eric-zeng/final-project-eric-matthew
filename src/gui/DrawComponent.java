package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import physicsSim.*;

public class DrawComponent extends JComponent{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Thing> things;
	private Physics p;
		
	public DrawComponent(ArrayList<Thing> things, Physics p){
		this.things = things;
		this.p = p;
	}
	
	public void updatePositions(){
		for(Thing t: things){
			p.bounce(t);
			p.gravity(t);
			p.lateralMove(t);
			
		}
		repaint();
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.RED);
		for(Thing t : things){
			int x = t.getPoint().x;
			int y = t.getPoint().y;
			int height = t.getRadius();
			int width = t.getRadius();
			
			g.fillOval(x, y, height, width);
		}
		
		try { 
            Thread.sleep(16); 
        } catch (InterruptedException e) {}
        
		updatePositions();
		
		
	}

}
