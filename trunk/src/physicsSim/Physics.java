package physicsSim;
import java.awt.Point;


public class Physics {
	
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
	
	public void gravity(Thing t){
		int acceleration = 1;
		t.setVV(t.getVV() + acceleration);
		t.setPoint(new Point(t.getPoint().x, t.getPoint().y + t.getVV()));
	}

	public void lateralMove(Thing t){
		t.setPoint(new Point(t.getPoint().x + t.getHV(), t.getPoint().y));
	}

	public void bounce(Thing t){
		System.out.println("Velocity = " + t.getVV());
		System.out.println("Y Coordinate = " + t.getPoint().y);
		System.out.println("--------------------");
		
		if((t.getPoint().y > t.getYMax() - t.getRadius() * 2) && (t.getVV() > 0))
			t.setVV(t.getVV() * -1);
		
		if((t.getPoint().y < 0) && (t.getVV() < 0))
			t.setVV(t.getVV() * -1);
		
		
		if(t.getPoint().x > t.getXMax() - t.getRadius() * 2 || t.getPoint().x < 0){
			t.setHV(t.getHV() * -1);
		}
	}
}
