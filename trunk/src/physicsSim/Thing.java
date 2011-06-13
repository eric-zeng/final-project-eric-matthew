
package physicsSim;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Thing {
	
////////////////////////////////////////Fields////////////////////////////////////////
	private Color c;
	private double mass;
	private int radius;
	private double vVelocity;
	private double hVelocity;
	private int time;
	private Point p;
	private boolean collOn;
	private long id;
	private ArrayList<Long> collIds;

	
	
//////////////////////////////////////Initialization///////////////////////////////////////	
	public Thing(){
		mass = 10;
		radius = 10;
		vVelocity = 0;
		hVelocity = 0;
		c = Color.red;
		p = new Point(0,100);
		//p = getClicked
		time = 0;
		collIds = new ArrayList<Long>();
		
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
		collIds = new ArrayList<Long>();
	}
	
	public Thing(Color col){
		mass = 10;
		radius = 10;
		vVelocity = 0;
		hVelocity = 0;
		c = col;
		p = new Point(0,0);
		time = 0;
		collIds = new ArrayList<Long>();
	}
	
	public Thing (boolean random){
		Random rand = new Random();
		radius = rand.nextInt(60) + 10;
		mass = radius;
		vVelocity = rand.nextInt(30);
		hVelocity = rand.nextInt(30);
		c = new Color(rand.nextInt(254) + 1, rand.nextInt(254) + 1, rand.nextInt(254) + 1);
		p = new Point(rand.nextInt(580), rand.nextInt(420));
		time = 0;
		collIds = new ArrayList<Long>();
	}
	
	public Thing(int x, int y){
		mass = 10;
		radius = 10;
		vVelocity = 0;
		hVelocity = 0;
		c = Color.red;
		p = new Point(x,y);
		time = 0;
		collIds = new ArrayList<Long>();
	}
	
	public Thing(boolean random, int x, int y){
		Random rand = new Random();
		radius = rand.nextInt(60) + 10;
		mass = radius;
		vVelocity = 0;
		hVelocity = 0;
		c = new Color(rand.nextInt(254) + 1, rand.nextInt(254) + 1, rand.nextInt(254) + 1);
		p = new Point(x, y);
		time = 0;
		collIds = new ArrayList<Long>();
	}
	
	
////////////////////////////////////////// Set/Get ////////////////////////////////////////////////
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
	
	public void setColor(Color color) {
		c = color;
	}
	
	public double getMass(){
		return mass;
	}
	
	public boolean getCollOn(){
		return collOn;
	}
	
	public void setCollOn(boolean a){
		collOn = a;
	}
	
	public void setId(long num){
		id = num;
	}
	
	public long getId(){
		return id;
	}
	

////////////////////////////////////////Physics and Vectors ///////////////////////////////////////////
	public double getVAngle(){
		double dv = getVV();
		double dh = getHV();
		double hyp = Math.sqrt(dv*dv + dh*dh);
		return Math.acos(dh/hyp);
	}

	public boolean isColliding(Thing other){
		return (radius + other.getRadius() >= Math.sqrt(Math.pow(p.x + other.getPoint().x, 2))+ Math.pow(p.y + other.getPoint().y, 2));
	}
	
	public double getCollAngle(Thing other){
		Point otherPoint = other.getPoint();
		double dist = other.getRadius() + radius;
		double opposite = otherPoint.y - p.y;
		return Math.asin(dist/opposite);
	}
	
	public void collVector(Thing other){
		double angle = getCollAngle(other);
		if(hVelocity + vVelocity > other.getHV() + other.getVV()){
			double newAngle = angle + 90;
			
		}else{
			
		}
	}
	
	public void collIdAdd(Thing other){
		collIds.add(other.getId());
	}
	
	public void collIdRemove(Thing other){
		for(long num : collIds){
			if(num == other.getId()){
				collIds.remove(collIds.indexOf(num));
			}
		}
	}
	
	public boolean collOn(Thing other){
		for(long num : collIds){
			if(num == other.getId()){
				return false;
			}
		
		}
		return true;
	}

	
}
