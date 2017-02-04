package simpleFactory;

public class Circle implements Shape {

	public Circle(){
		System.out.println("创建一个圆形");
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("画一个圆形");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("画一个圆形");
	}

}
