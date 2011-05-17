
package physicsSim;
import java.awt.Color;
import java.awt.Point;


public class Thing {
	private Color c;
	private int mass;
	private int radius;
	private int vVelocity;
	private int hVelocity;
	private int time;
	private Point p;
	private int xMax;
	private int yMax;
	
	public Thing(){
		mass = 10;
		radius = 10;
		vVelocity = 0;
		hVelocity = 0;
		c = Color.red;
		p = new Point(0,0);
		//p = getClicked
		time = 0;
		xMax = 300;
		yMax = 300;
	}
	
	public Thing(int m, int r, int vV, int hV, Color col) throws IllegalArgumentException{
		if(m <= 0 || r <= 0){
			throw new IllegalArgumentException();
		}
		mass = m;
		radius = r;
		vVelocity = vV;
		hVelocity = hV;
		c = col;
		p = new Point(0,0);
		time = 0;
		xMax = 300;
		yMax = 300;
	}
	
	public Thing(Color col){
		mass = 10;
		radius = 10;
		vVelocity = 0;
		hVelocity = 0;
		c = col;
		p = new Point(0,0);
		time = 0;
		xMax = 300;
		yMax = 300;
	}
	
	public void bounce(){
		if(p.y >= yMax || p.y <= 0){
			vVelocity = - vVelocity;
		}
	}
	
	public int getVV(){
		return vVelocity;
	}
	
	public void setVV(int vV){
		vVelocity = vV;
	}
	
	public int getHV(){
		return hVelocity;
	}
	
	public void setHV(int hV){
		hVelocity = hV;
	}
	
	public Point getPoint(){
		return p;
	}
	
	public void setPoint(Point yLikeANeedle){
		p = yLikeANeedle;
	}
	
	public int getTime(){
		return time;
	}
	
	public void setTime(int t){
		time = t;
	}
	
	public int getXMax(){
		return xMax;
	}
	public int getYMax(){
		return yMax;
	}
}
