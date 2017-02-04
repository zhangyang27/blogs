package simpleFactory;

public class Client {
	public static void main(String[] args) {
		Shape shape = shapeFactory.getShape("t");
		shape.draw();
		shape.erase();
		shape = shapeFactory.getShape("c");
		shape.draw();
		shape.erase();
	}

}
