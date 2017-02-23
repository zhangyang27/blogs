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
			//����һ�����Ҫ��
			throw new UnsupportedOperationException("�ݲ�֧������ͼ��...");
		}
		
		return shape;
	}
}
