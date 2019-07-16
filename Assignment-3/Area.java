
public class Area {  
	static double PI = 3.14;
	//area of triangle
	public static double areaTriangle(double base, double height) {
		return (base*height)/2;
	}
	//area of rectangle
	public static double areaRectangle(double side1, double side2) {
		return (side1*side2); 
	}
	//area of square
	public static double areaSquare(double side) {
		return (side*side);
	}
	//area of circle
	public static double areaCircle(double radius) {
		return (PI*radius*radius);
	}
	public static void main(String[] args) {
	}
}
