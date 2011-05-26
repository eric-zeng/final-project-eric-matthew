
package physicsSim;
import java.awt.Color;
import java.awt.Point;



public class Thing {
	private Color c;
	private double mass;
	private int radius;
	private double vVelocity;
	private double hVelocity;
	private int time;
	private Point p;
	
	public Thing(){
		mass = 10;
		radius = 10;
		vVelocity = 0;
		hVelocity = 0;
		c = Color.red;
		p = new Point(0,100);
		//p = getClicked
		time = 0;
	}
	
	public Thing(double m, int r, double vV, double hV, Color col) throws IllegalArgumentException{
		if(m <= 0 || r <= 0){
			throw new IllegalArgumentException();
		}
		mass = m;
		radius = r;
		vVelocity = vV;
		hVelocity = hV;
		c = col;
		p = new Point(0,100);
		time = 0;
	}
	
	public Thing(Color col){
		mass = 10;
		radius = 10;
		vVelocity = 0;
		hVelocity = 0;
		c = col;
		p = new Point(0,0);
		time = 0;
	}
	
	
	
	public double getVV(){
		return vVelocity;
	}
	
	public void setVV(double vV){
		vVelocity = vV;
	}
	
	public double getHV(){
		return hVelocity;
	}
	
	public void setHV(double hV){
		hVelocity = hV;
	}
	
	public Point getPoint(){
		return p;
	}
	
	public void setPoint(Point y){
		p = y;
	}
	
	public int getTime(){
		return time;
	}
	
	public void setTime(int t){
		time = t;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public Color getColor(){
		return c;
	}
}
