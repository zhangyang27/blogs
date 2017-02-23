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
		}else{
			//改了一下题的要求
			throw new UnsupportedOperationException("暂不支持所需图形...");
		}
		
		return shape;
	}
}
