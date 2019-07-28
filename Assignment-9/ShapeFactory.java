import java.util.*;
public class ShapeFactory{
	//input: shape type(like rect, eq. tri etc.), array of mid point and list of size param
	//output: object of given shape type
	public Shape createShape(String shapeType, double[] point, List<Double> sizeParam){
		if(shapeType == null){
			return null;
		}
		Screen screen = new Screen();
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			 Circle circle = new Circle(point, sizeParam);
			 screen.shapeList.add(circle);
			 return circle;
		}
		else if(shapeType.equalsIgnoreCase("EQUILATERALTRIANGLE")){
			EquilateralTriangle equilateralTriangle = new EquilateralTriangle(point, sizeParam);
			screen.shapeList.add(equilateralTriangle);
			return equilateralTriangle;
		}
		else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			Rectangle rectangle = new Rectangle(point, sizeParam);
			screen.shapeList.add(rectangle);
			return rectangle;
		}
		else if(shapeType.equalsIgnoreCase("SQUARE")){
			Square square = new Square(point, sizeParam);
			screen.shapeList.add(square);
			return square;
		}
		return null;
	}
	//show all the shapes on screen
	public static void shapesOnScreen(){
		for(Shape shape : screen.shapeList){
			System.out.println(shape.typeOfObject()+" "+shape);
		}
	}
	//delete given object as param, from screen
	public static void deleteFromScreen(Shape shape){
		Screen screen = new Screen();
		screen.shapeList.remove(shape);
	}
	//delete all objects of specific type from screen
	public static void deleteShapeFromScreen(String shapeType){
		Screen screen = new Screen();
		int count = -1;
		LinkedList<Shape> tempShapeList = new LinkedList<Shape>();
		for(Shape shape : screen.shapeList){
			System.out.println(shape.typeOfObject());
			if(shapeType.equalsIgnoreCase(shape.typeOfObject())){
				tempShapeList.add(shape);
			}
		}

		if(tempShapeList.size() > 0){
			for (Shape shape : tempShapeList){
				screen.shapeList.remove(shape);
			}
			tempShapeList.clear();
		}
	}
	// input: String(like timestamp,area,perimeter etc.)
	// output: Array of shape objects according to input param
	public static Shape[] shapeInOrder(String param){
		if(param == null){
			return null;
		}
		Screen screen = new Screen();
		int size = screen.shapeList.size();
		Shape[] shapeArray = new Shape[size];
		// by area
		if(param.equalsIgnoreCase("AREA")){
			int count = 0;
			for(Shape shape : screen.shapeList){
				int index = 0;
				while(index < count && shapeArray[index].getArea() < shape.getArea()){
					index += 1;
				}
				if(shapeArray[index] == null){
					shapeArray[index] = shape;
					//System.out.println(shapeArray[index].getArea());
				}
				else{
					int tempIndex = count;
					while(tempIndex > index){
						shapeArray[tempIndex] = shapeArray[--tempIndex];
					}
					shapeArray[index] = shape;
					//System.out.println(shapeArray[index].getArea());
				}
				count+=1;
			}
		}

		//by perimeter
		else if(param.equalsIgnoreCase("PERIMETER")){
			int count = 0;
			for(Shape shape : screen.shapeList){
				int index = 0;
				while(index < count && shapeArray[index].getPerimeter() < shape.getPerimeter()){
					index += 1;
				}
				if(shapeArray[index] == null){
					shapeArray[index] = shape;
				}
				else{
					int tempIndex = count;
					while(tempIndex > index){
						shapeArray[tempIndex] = shapeArray[--tempIndex];
					}
					shapeArray[index] = shape;
				}
				count+=1;
			}
		}

		//by Distacne From Origin
		else if(param.equalsIgnoreCase("distanceFromOrigin")){
			int count = 0;
			for(Shape shape : screen.shapeList){
				int index = 0;
				while(index < count && shapeArray[index].distanceFromOrigin() < shape.distanceFromOrigin()){
					index += 1;
				}
				if(shapeArray[index] == null){
					shapeArray[index] = shape;
				}
				else{
					int tempIndex = count;
					while(tempIndex > index){
						shapeArray[tempIndex] = shapeArray[--tempIndex];
					}
					shapeArray[index] = shape;
				}
				count+=1;
			}
		}

		//by timestamp = before to later
		else if(param.equalsIgnoreCase("TIMESTAMP")){
			int count = 0;
			for(Shape shape : screen.shapeList){
				shapeArray[count++] = shape;
			}
		}

		else{
			return null;
		}

		return shapeArray;
	}

	public static void main(String[] args) {
		List<Double> sizeParam = new ArrayList<Double>();
		double[] point1 = new double[]{20,20},
				point2 = new double[]{40,40},
				point3 = new double[]{60,60};
		sizeParam.add(0,10.0);
    	ShapeFactory shapeFactory = new ShapeFactory();

    	Shape shape1 = shapeFactory.createShape("SQUARE", point3, sizeParam);
    	Shape shape = shapeFactory.createShape("CIRCLE", point1, sizeParam);
    	shape = shapeFactory.createShape("SQUARE", point2, sizeParam);
    	//shape = shapeFactory.createShape("SQUARE", point2, sizeParam);
    	sizeParam.add(0,11.0);
    	shape = shapeFactory.createShape("SQUARE", point3, sizeParam);
    	//System.out.println(shape.typeOfObject());
    	shapeFactory.shapesOnScreen();
    	//shapeFactory.deleteFromScreen(shape1);
    	//shapeFactory.deleteShapeFromScreen("SQUARE");
    	//System.out.println("after deletion");
    	Shape[] shapeArr = shapeInOrder("timestamp");
    	for (Shape tempShape : shapeArr){
    		System.out.println(tempShape.typeOfObject()+" "+tempShape.timeStamp());
    	}
    	//shapeFactory.shapesOnScreen();

    }
}