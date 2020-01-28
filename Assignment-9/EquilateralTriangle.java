import java.util.*;

public class EquilateralTriangle implements Shape{
	private double side;
	private double centreX;
	private double centreY;
	private double x1,x2,x3, y1,y2,y3;
	private Date date
	
	/**
	 * @param side
	 * @param centreX
	 * @param centreY
	 * create object of triangle if possible
	 */
	EquilateralTriangle(double[] point, List<Double> sizeParam){
		double tempx1 = point[0] - (sizeParam.get(0)/2),
				tempy1 = (point[1] - sizeParam.get(0)/(2*Math.pow(3, 0.5))),
				tempy2 = (point[1] + sizeParam.get(0)/(Math.pow(3, 0.5))),
				tempx2 = point[0] + (sizeParam.get(0)/2);
		if((tempx1 >= MIN_X && tempy1 >= MIN_Y) &&
				(tempx2 <= MAX_X && (tempy2 <= MAX_Y))){
			this.x1 = tempx1;	this.y1 = tempy1;
			this.x2 = centreX;	this.y2 = tempy2;
			this.x3 = tempx2;	this.y3 = tempy1;
			Date date = new Date();
			super.date = date;
		}
		else{
			throw new AssertionError("not possible.");
		}
	}
	
	/**
	 * @param x
	 * @param y
	 * @param x1
	 * @param y1
	 * @return slope of line
	 */
	public double lineSlope(double x, double y,double x1, double y1){
		if(x1-x != 0){
			return((y1-y)/(x1-x));
		}
		throw new AssertionError("line if parallel to y-axis");
	}
	
	/**
	 * @param x
	 * @param y
	 * @param m
	 * @return constant of line equation
	 */
	public double lineEqConst(double x, double y, double m){
		return(y-(m*x));
	}
	
	
	/**
	 * @param triangleX
	 * @param triangleY
	 * @param m
	 * @param c
	 * @param x
	 * @param y
	 * @return check given point with respect to line of triangle
	 */
	public boolean pointWithLine(double triangleX, double triangleY, double m, double c, double x, double y){
		if((triangleY-(m*triangleX)-c) > 0){
			if((y-(m*x)-c) > 0){
				return true;
			}
			return false;
		}
		else{
			if((y-(m*x)-c) < 0){
				return true;
			}
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see Shape#getArea()
	 * 
	 */
	@Override
	public double getArea() {
		
		return ((Math.pow(3, 0.5) * side * side) / 4);
	}

	/* (non-Javadoc)
	 * @see Shape#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		return 3 * side;
	}

	/* (non-Javadoc)
	 * @see Shape#getOrigin()
	 */
	@Override
	public double[] getOrigin() {
		double origin[] = (new double[]{this.centreX, this.centreY});
		return origin;
	}

	/* (non-Javadoc)
	 * @see Shape#isPointEnclosed(double, double)
	 * true if point is enclosed in the triangle
	 */
	@Override
	public boolean isPointEnclosed(double x, double y) { 
		double m12 = lineSlope(this.x1, this.y1, this.x2, this.y2),
				m23 = lineSlope(this.x3, this.y3, this.x2, this.y2),
				m13 = lineSlope(this.x1, this.y1, this.x3, this.y3);
		
		double c12 = lineEqConst(this.x1, this.y1, m12),
				c23 = lineEqConst(this.x2, this.y2, m23),
				c13 = lineEqConst(this.x3, this.y3, m13);
		// check the point with respect to all the lines of the triangle
		if(pointWithLine(this.x3, this.y3, m12, c12, x, y)){
			if(pointWithLine(this.x1, this.y1, m23, c23, x, y)){
				if(pointWithLine(this.x2, this.y2, m13, c13, x, y)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String typeOfObject(){
		return "CIRCLE";
	}

	public double distanceFromOrigin(){
		double dist = (Math.pow(((this.x1*this.x1)+(this.y1*this.y1)),0.5));
		return dist;
	}
	// return time of object creation
	public Date timeStamp(){
		return this.date;
	}

	public static void main(String[] args){
		
	}

}
