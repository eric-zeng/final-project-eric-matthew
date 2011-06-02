package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;

import physicsSim.*;

public class DrawComponent extends JComponent implements MouseListener, MouseMotionListener{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Thing> things;
	private Physics p;
	private int time;
	private int timeStart;
	private Point startPoint;
		
	public DrawComponent(ArrayList<Thing> things, Physics p){
		this.things = things;
		this.p = p;
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void updatePositions(){
		for(int i = 0; i < things.size(); i++){
			Thing t = things.get(i);
			p.bounce(t);
			p.gravity(t);
			p.lateralMove(t);
			for(int j = i + 1; j < things.size(); j++){
				Thing test = things.get(j);
			//	Random r = new Random();
				if(p.isColliding(t,test)){
				//	p.collisionVelocity(t, test);
				}
			}
			
		}
		time++;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		things.add(new Thing(true, e.getX(), e.getY()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		addOneHundred();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		timeStart = time;
		startPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//if the mouse has moved
		if(e.getX() != startPoint.x && e.getY() != startPoint.y){
			int timeDif = time - timeStart;
			Point current = e.getPoint();
			
		//	System.out.println("HIIIIIIIIIIIII # 1");
			
			//to test if it is on each thing
			for(Thing t: things){
				Point p = t.getPoint();
				int d = 2 * t.getRadius();
		//		System.out.println("HIIIIIIIIIIIII # 2");
				
				//if the mouse is in the square around the circle
				if((startPoint.x > p.x) && (startPoint.x < p.x + d) &&
						(startPoint.y > p.y) && (startPoint.y < p.y + d)){
					
			//		System.out.println("HIIIIIIIIIIIII # 3");
					double vV = (current.y - startPoint.y) / (double)timeDif;
					double hV = (current.x - startPoint.x) / (double)timeDif;
					
					t.setVV(vV);
					t.setHV(hV);
					
				}
				
			}
			
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	/*	for(Thing t: things){
			Point p = t.getPoint();
			int d = 2 * t.getRadius();
			
			//if the mouse is in the square around the circle
			if((startPoint.x > p.x) && (startPoint.x < p.x + d) &&
					(startPoint.y > p.y) && (startPoint.y < p.y + d)){
				t.setPoint(new Point(e.getX() - t.getRadius(), e.getY() - t.getRadius()));
			}
				
		}*/
				
	}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void addOneHundred(){
		for(int i = 0; i < 100; i++){
			things.add(new Thing(true));
		}
	}

}
