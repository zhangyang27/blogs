package simpleFactory;

public class shapeFactory {
	public static Shape getShape(String type){
		Shape shape = null;
		if(type.equalsIgnoreCase("t")){
			shape = new Triangle();
		}else if(type.equalsIgnoreCase("c")){
			shape = new Circle();
		}else if(type.equalsIgnoreCase("s")){
			shape = new Square();
		}
		
		return shape;
	}
}
