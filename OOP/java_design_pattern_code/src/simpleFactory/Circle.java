package simpleFactory;

public class Circle implements Shape {

	public Circle(){
		System.out.println("����һ��Բ��");
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("��һ��Բ��");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("��һ��Բ��");
	}

}
