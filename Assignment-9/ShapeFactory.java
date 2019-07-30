import java.util.*;
public class ShapeFactory{
	//input: shape type(like rect, eq. tri etc.), array of mid point and list of size param
	//output: object of given shape type
	public Shape createShape(String shapeType, double[] point, List<Double> sizeParam){
		if(shapeType == null){
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			 Circle circle = new Circle(point, sizeParam);
			 return circle;
		}
		else if(shapeType.equalsIgnoreCase("EQUILATERALTRIANGLE")){
			EquilateralTriangle equilateralTriangle = new EquilateralTriangle(point, sizeParam);
			return equilateralTriangle;
		}
		else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			Rectangle rectangle = new Rectangle(point, sizeParam);
			return rectangle;
		}
		else if(shapeType.equalsIgnoreCase("SQUARE")){
			Square square = new Square(point, sizeParam);
			return square;
		}
		return null;
	}
}
