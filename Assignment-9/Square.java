import java.util.*;

public class Square implements Shape{
	private double side;
	private double centreX;
	private double centreY;
	private String shapeType = "SQUARE";
	private Date date;

	Square(double[] point, List<Double> sizeParam){
		if(((point[0] - sizeParam.get(0)/2) >= MIN_X && (point[1] - sizeParam.get(0)/2) >= MIN_Y) &&
			((point[0] + sizeParam.get(0)/2) <= MAX_X && (point[1] + sizeParam.get(0)/2) <= MAX_Y)){
			this.side = sizeParam.get(0);
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
		return (this.side * this.side);
	}

	@Override
	public double getPerimeter() {
		return (2 * this.side);
	}

	@Override
	public double[] getOrigin() {
		double origin[] = (new double[]{this.centreX, this.centreY});
		return origin;
	}

	@Override
	public boolean isPointEnclosed(double x, double y) {
		if(((this.centreX + (this.side/2)) > x) && ((this.centreX - (this.side/2)) < x)){
			if(((this.centreY + (this.side/2)) > y) && ((this.centreY - (this.side/2)) < y)){
				return true;
			}
		}
		return false;
	}

	public String typeOfObject(){
		return "SQUARE";
	}

	public double distanceFromOrigin(){
		double x = this.centreX - (this.side/2),
				y = this.centreY - (this.side/2);
		double dist = (Math.pow(((x*x)+(y*y)),0.5));
		return dist;
	}
	// return time of object creation
	public Date timeStamp(){
		return this.date;
	}
}