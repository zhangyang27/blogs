package strategy;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P366
 * ����һ�����ģ������ģ�ⲻͬ�ɻ��ķ����������������������������ͼ
 * ͼ����Ŀ¼��README.md
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		
		Aircraft aircraft = new Harrier();
		aircraft.fly();
	}

}
