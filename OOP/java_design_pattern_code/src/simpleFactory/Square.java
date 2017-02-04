package simpleFactory;

public class Square implements Shape {
	
	public Square (){
		System.out.println("创建一个正方形");
	};
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("画一个正形");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("画一个正方形");
	}

}
