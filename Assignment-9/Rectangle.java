import java.util.*;

public class Rectangle implements Shape{
	private double length;
	private double width;
	private double centreX;
	private double centreY;
	private Date date;

	Rectangle(double[] point, List<Double> sizeParam){
		if(((point[0] - sizeParam.get(0)/2) >= MIN_X && (point[1] - sizeParam.get(1)/2) >= MIN_Y) &&
				((point[0] + sizeParam.get(0)/2) <= MAX_X && (point[1] + sizeParam.get(1)/2) <= MAX_Y)){
			this.length = sizeParam.get(0);
			this.width = sizeParam.get(1);
			this.centreX = point[0];
			this.centreY = point[1];
			Date date = new Date();
			date = date;
		}
		else{
			throw new AssertionError("Not Possible.");
		}
	}

	@Override
	public double getArea() {
		return (this.length * this.width);
	}

	@Override
	public double getPerimeter() {
		return (2 * (this.length + this.width));
	}

	@Override
	public double[] getOrigin() {
		double origin[] = (new double[]{this.centreX, this.centreY});
		return origin;
	}

	@Override
	public boolean isPointEnclosed(double x, double y) {
		if(((this.centreX + (this.length/2)) > x) && ((this.centreX - (this.length/2)) < x)){
			if(((this.centreY + (this.width/2)) > y) && ((this.centreY - (this.width/2)) < y)){
				return true;
			}
		}
		return false;
	}
	public String typeOfObject(){
		return "CIRCLE";
	}

	public double distanceFromOrigin(){
		double x = this.centreX - (this.length/2),
				y = this.centreY - (this.width/2);
		double dist = (Math.pow(((x*x)+(y*y)),0.5));
		return dist;
	}
	// return time of object creation
	public Date timeStamp(){
		return this.date;
	}
}
