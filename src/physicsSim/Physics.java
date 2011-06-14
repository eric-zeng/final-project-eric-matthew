package physicsSim;
import java.awt.Point;



public class Physics {
	
	private double acceleration;
	private int xMax;
	private int yMax;

	
	//private double velocity;
	/*public void gravity(Thing t){
		int velocity = t.getVV();
		int time = t.getTime();
		if(velocity >= 0){
			time++;
			t.setVV((int)Math.round(0.01 * (velocity + time * time)));
		}else{
			time--;
			t.setVV((int)Math.round(0.01 * (velocity - time * time)));
		}
		t.setTime(time);
		t.setPoint(new Point(t.getPoint().x, t.getPoint().y + t.getVV()));
	}*/
	
	/*public void start(Thing t){
		hVelocity = t.getHV();
	}*/
	
	public Physics(int x, int y){
		xMax = x;
		yMax = y;
	}
	
	public void gravity(Thing t){
		acceleration = 1;
		//velocity += acceleration;
		t.setVV(t.getVV() + acceleration);
		t.setPoint(new Point(t.getPoint().x, (int)Math.round(t.getPoint().y + t.getVV())));
		
		
			
	}

	public void lateralMove(Thing t){
		if(t.getHV() > 0)
			t.setHV(t.getHV() - 0.0001);
		else
			t.setHV(t.getHV() + 0.0001);
		t.setPoint(new Point((int)Math.round(t.getPoint().x + t.getHV()), t.getPoint().y));
	}

	public void bounce(Thing t){
	/*	System.out.println("Velocity = " + t.getVV());
		System.out.println("Y Coordinate = " + t.getPoint().y);
		System.out.println("--------------------");*/
		
		//for bouncing on top
		
		if((t.getPoint().y > yMax - t.getRadius() * 2) && (t.getVV() > 0)){
			t.setVV(t.getVV() * -1 + 1);
			if(t.getHV() > 0)
				t.setHV(t.getHV() - 0.02);
			else
				t.setHV(t.getHV() + 0.02);
		}
		
		//for bouncing on bottom
	
		if((t.getPoint().y < 0) && (t.getVV() < 0))
			t.setVV(t.getVV() * -1);
		
		//bouncing on right
		
		if(t.getPoint().x > xMax - t.getRadius() * 2){
			t.setPoint(new Point(xMax - t.getRadius() * 2,t.getPoint().y));
			t.setHV(t.getHV() * -1);
		}
		
		//bouncing on left
		if(t.getPoint().x < 0){
			t.setPoint(new Point(0,t.getPoint().y));
			t.setHV(t.getHV() * -1);
		}
		
		//eliminates overshooting
		
		if(t.getPoint().y > yMax - 2 * t.getRadius())
			t.setPoint(new Point(t.getPoint().x, yMax - 2 * t.getRadius() + 1));
	}
	
	public boolean isColliding(Thing a, Thing b){
		/*
		 * System.out.println(a.getRadius() + b.getRadius());
		 *System.out.println(Math.sqrt((Math.pow(a.getPoint().x - b.getPoint().x, 2)) + (Math.pow(a.getPoint().y - b.getPoint().y, 2))));
		 *System.out.println("----------");
		 */
		return (a.getRadius() + b.getRadius() > Math.sqrt((Math.pow(a.getPoint().x - b.getPoint().x, 2)) + (Math.pow(a.getPoint().y - b.getPoint().y, 2))));
		
	}
	
	public void collision(Thing a, Thing b){
		//Momentum and Velocity
		double m1 = a.getMass();
		double m2 = b.getMass();
		
		Vector av = new Vector (a.getHV(), a.getVV());
		Vector bv = new Vector (b.getHV(), b.getVV());
		
		double v1 = av.getMagnitude();
		double v2 = bv.getMagnitude();
		
		av.setMagnitude((v1 * (m1 - m2) + 2 * m2 * v2)/(m1 + m2));
		bv.setMagnitude((v2 * (m2 - m1) + 2 * m1 * v1)/(m1 + m2));
		
		
		
		//Direction
		
		if(Math.abs(av.getMagnitude()) >= Math.abs(bv.getMagnitude())){
			av.setAngle(av.getAngle() + 180);
		}else if(Math.abs(bv.getMagnitude()) > Math.abs(av.getMagnitude())){
			bv.setAngle(bv.getAngle() + 180);
		}
		
		av.magnitudeToThing(a);
		bv.magnitudeToThing(b);
		
		//Intersecting check
		
		if(isColliding(a, b)){
			double dist = Math.sqrt((Math.pow(a.getPoint().x - b.getPoint().x, 2)) + (Math.pow(a.getPoint().y - b.getPoint().y, 2)));
			double requiredDist = a.getRadius() + b.getRadius();
			
			double diff = requiredDist - dist;
			
			double newAHV = Math.sin(av.getAngle()) * diff;
			double newAVV = Math.cos(av.getAngle()) * diff;
			
			a.setPoint(new Point((int)(a.getPoint().x + newAHV), (int)(a.getPoint().y + newAVV)));
			
			double newBHV = Math.sin(bv.getAngle()) * diff;
			double newBVV = Math.cos(bv.getAngle()) * diff;
			
			b.setPoint(new Point((int)(b.getPoint().x + newBHV), (int)(b.getPoint().y + newBVV)));
		}
		
		
		
		
	}
	
	
/*	public void collision(Thing t1, Thing t2){
		int r1 = t1.getRadius();
		int r2 = t2.getRadius();
		Point c1 = new Point(t1.getPoint().x + r1, t1.getPoint().y + r1);
		Point c2 = new Point(t2.getPoint().x + r2, t2.getPoint().y + r2);
		
		double distance = Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
		
		if(distance < r1 + r2){
			t1.setVV(t1.getVV() * -1);
			t2.setVV(t2.getVV() * -1);
			t1.setHV(t1.getHV() * -1);
			t2.setHV(t2.getHV() * -1);
		}
	}*/
	
	
	
	/*
	    public void collisionVelocity (Thing a, Thing b){
	    Vector av = new Vector (a.getHV(), a.getVV());
		Vector bv = new Vector (b.getHV(), b.getVV());
		
		av.setMagnitude((av.getMagnitude() * (a.getMass() - b.getMass()) + (2 * b.getMass() * bv.getMagnitude())) / (a.getMass() + b.getMass()));
		bv.setMagnitude((bv.getMagnitude() * (b.getMass() - a.getMass()) + (2 * a.getMass() * av.getMagnitude())) / (a.getMass() + b.getMass()));
		
		a.setHV(av.getVecHV());
		a.setVV(av.getVecVV());
		b.setHV(bv.getVecHV());
		b.setVV(bv.getVecVV());
	}
	*/
	
	public void collisionDirection(Thing a, Thing b){
		Vector av = new Vector (a.getHV(), a.getVV());
		Vector bv = new Vector (b.getHV(), b.getVV());
		
		double collAngle = Math.asin((a.getPoint().y - b.getPoint().y) / (Math.sqrt((Math.pow(a.getPoint().x - b.getPoint().x, 2)) + (Math.pow(a.getPoint().y - b.getPoint().y, 2)))));
		
		av.setAngle(collAngle + 90);
		bv.setAngle(collAngle);
		
		a.setHV(av.getVecHV());
		a.setVV(av.getVecVV());
		b.setHV(bv.getVecHV());
		b.setVV(bv.getVecVV());
		
	}
	
}
