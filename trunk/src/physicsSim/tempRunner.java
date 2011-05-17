
package physicsSim;
import java.awt.Graphics;
import gui.DrawingPanel;


public class tempRunner {
	public static void main(String[] args){
		Thing t = new Thing();
		Physics p = new Physics();
		gui.DrawingPanel panel = new DrawingPanel(300,300);
		Graphics g = panel.getGraphics();
		for(int i = 0; i < 2000; i++){
			g.drawOval(t.getPoint().x, t.getPoint().y,10,10);
			p.gravity(t);
			t.bounce();
			panel.sleep(20);
			g.drawString("" + i, 270, 270);
			panel.clear();
		}
	}
}
