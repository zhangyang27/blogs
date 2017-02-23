package simpleFactory;
/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P59
 * ʹ�ü򵥹���ģʽ���һ�����Դ�����ͬ������״����Բͼ�����κ������εȵģ���ͼ����
 * ÿ����ͼ���߶���draw()��erase()����������Ҫ���ڻ��Ʋ�֧�ֵļ���ͼ��ʱ����ʾһ��UnSupportedShapeException
 *
 */
public class Client {
	public static void main(String[] args) {
		Shape shape = shapeFactory.getShape("t");
		shape.draw();
		shape.erase();
		shape = shapeFactory.getShape("c");
		shape.draw();
		shape.erase();
		shape = shapeFactory.getShape("a");
		shape.draw();
		shape.erase();
	}

}
