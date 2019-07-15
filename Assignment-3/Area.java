
public class Area { 
	static double PI = 3.14;
	//area of triangle
	public static double areaTriangle(double side1, double side2, double side3) {
		if((side1+side2)>side3 && (side1+side3)>side2 && (side2+side3)>side1){
   	  		double s=(side1+side2+side3)2;
        		double  area=Math.sqrt(s(s-side1)(s-side2)(s-side3));
        		return area; 
        	}
    		else  
        		System.out.println(Area of Triangle not exist);		
		return 0;
	}
	//area of rectangle
	public static double areaRectangle(double side1, double side2) {
		return side1*side2; 
	}
	//area of square
	public static double areaSquare(double side) {
		return sideside;
	}
	//area of circle
	public static double areaCircle(double radius) {
		return (PI*radius*radius);
	}
	public static void main(String[] args) {
	}
}
