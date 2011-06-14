package physicsSim;

public class Vector {
	private double angle;
	private double magnitude;
	
	public Vector(double hV, double vV){
		updateVector(hV,vV);
	}
	
	public void updateVector(double hV, double vV){
		magnitude = Math.sqrt(hV * hV + vV * vV);
		angle = Math.asin(vV / magnitude);
	}
	
	public double getAngle(){
		return angle;
	}
	
	public double getMagnitude(){
		return magnitude;
	}
	
	public double getVecHV(){
		return magnitude * Math.cos(angle);
	}
	
	public double getVecVV(){
		return magnitude * Math.sin(angle);
	}
	
	public void setAngle(double angle){
		if(angle >= 360)
			angle -= 360;
		else if(angle < 0)
			angle += 360;
		this.angle = angle;
	}
	
	public void setMagnitude (double magnitude){
		this.magnitude = magnitude;
	}
	
	public void magnitudeToThing(Thing a){
		a.setHV(getVecHV());
		a.setVV(getVecVV());
	}
	

}
