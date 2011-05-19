
package physicsSim;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import gui.DrawingPanel;


public class tempRunner {
	public static void main(String[] args){
		Random randy = new Random();
		
		/*ArrayList<Thing> things = new ArrayList<Thing>();
		for(int i = 0; i < 1; i++){
			things.add(new Thing(1, randy.nextInt( 20) + 1, randy.nextInt(5)+ 1, randy.nextInt(5) + 1, Color.BLACK));
		}
		*/
		
		Thing t = new Thing();
		Physics p = new Physics();
		gui.DrawingPanel panel = new DrawingPanel(300,300);
		Graphics g = panel.getGraphics();
		t.setHV(randy.nextInt(5) + 1);		
		
		for(int i = 0; i < 2000; i++){
			//for(Thing t: things){	
				
				g.drawOval(t.getPoint().x, t.getPoint().y, t.getRadius() * 2, t.getRadius() * 2);
				p.bounce(t);
				p.gravity(t);
				p.lateralMove(t);
				

				
				if(t.getPoint().y > 315){
					System.out.println(i);
					System.out.println(t.getPoint().y);
					System.out.println("----------");
				}
			//}
			panel.sleep(20);
			panel.clear();
		}
	}
}
