package simpleFactory;

public class Triangle implements Shape {

	public Triangle(){
		System.out.println("����һ��������");
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("��һ��������");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("��ȥһ��������");
	}

}
