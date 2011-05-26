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
			for(Thing test: things){
				p.collision(t,test);
			}
			
		}
		repaint();
	}
	
	public void paintComponent(Graphics g){
		
		g.drawRect(0, 0, 640, 480);
		for(Thing t : things){
			int x = t.getPoint().x;
			int y = t.getPoint().y;
			int radius = t.getRadius();
			g.setColor(t.getColor());
			
			g.fillOval(x, y, radius * 2, radius * 2);
		}
		
		try { 
            Thread.sleep(16); 
        } catch (InterruptedException e) {}
        
		updatePositions();
		
		
	}

}
