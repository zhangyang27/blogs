package flyweight;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P207
 * ����һ���ĵ��༭�����ĵ��п��Բ���ͼƬ����������Ƶ
 * ͼƬ����Ƶ�����������ظ����֣�����ÿ�δ�С��λ�ö���ͬ��
 * ʹ����Ԫģʽ��ƴ��ĵ��༭����
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Editor editor = new Editor();
		ElementFactory ef = new ElementFactory();
		//���洴��Ԫ�ء���ģ��д���ĵ�
		Element str1 = ef.createEle("��������������");
		editor.add(str1, 1, 1, 1);
		Element str2 = ef.createEle("��۲���Ƶ�����Ի������ش�����:");
		editor.add(str2, 2, 1, 1);
		
		Element v1 = ef.createEle("����.mp4");
		editor.add(v1, 3, 1, 1);
		
		Element str3 = ef.createEle("���ٿ�һ��:");
		editor.add(str3, 4, 1, 1);
		
		Element v2 = ef.createEle("����.mp4");
		editor.add(v2, 5, 1, 2);
		
		Element str4 = ef.createEle("��ش���������...");
		editor.add(str4, 6, 1, 1);
		
		editor.each();
		
		//û��ʹ��Picture��û��ϵ������ֻ�ǽ�����Ԫģʽ
		//v1��v2�Ƿ���ͬһ�������أ�����ǣ��������Ԫģʽ��
		System.out.println(v1==v2);
	}

}
