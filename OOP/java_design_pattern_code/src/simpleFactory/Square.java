package simpleFactory;

public class Square implements Shape {
	
	public Square (){
		System.out.println("����һ��������");
	};
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("��һ������");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("��һ��������");
	}

}
