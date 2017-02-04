package simpleFactory;

public class Triangle implements Shape {

	public Triangle(){
		System.out.println("创建一个三角形");
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("画一个三角形");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("擦去一个三角形");
	}

}
