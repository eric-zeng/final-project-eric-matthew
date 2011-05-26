
package physicsSim;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import gui.DrawingPanel;


public class tempRunner {
	public static void main(String[] args){
		Random randy = new Random();
		
		ArrayList<Thing> things = new ArrayList<Thing>();
		for(int i = 0; i < 2; i++){
			things.add(new Thing(1, randy.nextInt(10) + 10, randy.nextInt(5)+ 1, randy.nextInt(5) + 1, Color.BLACK));
		}
		things.get(1).setPoint(new Point(30,70));
		
		
	//	Thing t = new Thing(1,10,0,0,Color.RED);
		Physics p = new Physics(300,300);
		gui.DrawingPanel panel = new DrawingPanel(300,300);
		Graphics g = panel.getGraphics();
		
	//	t.setHV(3);		
		//p.start(t);
		
		g.setColor(Color.RED);
		
		for(int i = 0; i < 2000; i++){
			for(Thing t: things){	
				
				
				p.bounce(t);
				p.gravity(t);
				p.lateralMove(t);
				for(Thing test: things){
					p.collision(t,test);
				}
				g.fillOval(t.getPoint().x, t.getPoint().y, t.getRadius() * 2, t.getRadius() * 2);
				

				
				/*if(t.getPoint().y > 315){
					System.out.println(i);
					System.out.println(t.getPoint().y);
					System.out.println("----------");
				}*/
			}
			panel.sleep(20);
			panel.clear();
		}
	}
}
