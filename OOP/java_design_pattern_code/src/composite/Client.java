package composite;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P183
 * ���һ���ؼ��⣬�ؼ���Ϊ���ࣺ��Ԫ�ؼ�����ť���ı����������ؼ������塢�м���壩�ȡ�
 * �������ģʽ��Ƹÿؼ��⡣
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Button b1,b2;
		Text t1;
		Panel p1,p2;
		Window w1;
		
		b1 = new Button("b1");
		b2 = new Button("b2");
		
		t1 = new Text("t1");
		p1 = new Panel("p1");
		p2 = new Panel("p2");
		
		w1 = new Window("w1");
		
		//���װ��
		p1.add(b1);
		p1.add(t1);
		p2.add(b2);
		w1.add(p1);
		w1.add(p2);
		
		w1.onclick();
	}

}
