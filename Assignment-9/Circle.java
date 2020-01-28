import java.util.*;

public class Circle implements Shape{
	private double radius;
	private double centreX;
	private double centreY;
	private Date date;

	Circle(double[] point, List<Double> sizeParam){
		if(((point[0] - sizeParam.get(0)) >= MIN_X && (point[1] - sizeParam.get(0)) >= MIN_Y) &&
			((point[0] + sizeParam.get(0)) <= MAX_X && (point[1] + sizeParam.get(0)) <= MAX_Y)){
			this.radius = sizeParam.get(0);
			this.centreX = point[0];
			this.centreY = point[1];
			Date date = new Date();
			super.date = date;
		}
		else{
			throw new AssertionError("Not Possible.");
		}
	}

	@Override
	public double getArea() {
		return Math.PI*this.radius*this.radius;
	}

	@Override
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}

	@Override
	public double[] getOrigin() {
		double origin[] = (new double[]{this.centreX, this.centreY});
		return origin;
	}

	@Override
	public boolean isPointEnclosed(double x, double y) {
		double X = Math.pow(x-this.centreX, 2), Y = Math.pow(y-this.centreY, 2);
		if(Math.pow(X+Y, 0.5) < this.radius){
			return true;
		}
		return false;
	}

	public String typeOfObject(){
		return "CIRCLE";
	}

	public double distanceFromOrigin(){
		double dist = (Math.pow(((this.centreX*this.centreX)+(this.centreY*this.centreY)),0.5)) - this.radius;
		return dist;
	}

	public Date timeStamp(){
		return this.date;
	}
}
