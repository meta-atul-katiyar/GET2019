import java.util.*;
enum ShapeType{
	CIRCLE, EQUILATERAL_TRIANGLE, RECTANGLE, RIGHT_TRIANGLE, SQUARE, 
}

interface Shape {
	
	double MIN_X = 0;
	double MIN_Y = 0;
	double MAX_X = 100;
	double MAX_Y = 100;


	public double getArea(); 
	public double getPerimeter(); 
	public double[] getOrigin(); 
	boolean isPointEnclosed(double x, double y);
	String typeOfObject();
	double distanceFromOrigin();
	Date timeStamp();

}
