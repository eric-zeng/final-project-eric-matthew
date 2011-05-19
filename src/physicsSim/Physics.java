package physicsSim;
import java.awt.Point;


public class Physics {
	
	public void gravity(Thing t){
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
	}

	public void lateralMove(Thing t){
		int velocity = t.getHV();
		t.setPoint(new Point(t.getPoint().x + velocity, t.getPoint().y));
	}

	public void bounce(Thing t){
		if(t.getPoint().y >= t.getYMax() || t.getPoint().y <= 0){
			t.setVV(t.getVV() * -1);
		}
		if(t.getPoint().x > t.getXMax() || t.getPoint().x < 0){
			t.setHV(t.getHV() * -1);
		}
	}
}
