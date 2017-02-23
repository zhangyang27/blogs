package factory;

/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P73
 * ʹ�ù�������ģʽ���һ����������ȡ���ֲ�ͬ���͵�ͼƬ��ʽ�����ÿһ��ͼƬ��ʽ�����һ��ͼƬ��ȡ��
 * ���磺GIFͼƬ��ȡ����ȡGIF��ʽ��ͼƬ��JPGͼƬ��ȡ����ȡJPG��ʽ��ͼƬ��
 * ��Ҫ��ֿ���ϵͳ������Ժ���չ�ԡ�
 * @author zhangyang27
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PicReader reader;
		Class c = null;
		try {
			c = Class.forName("factory.PngFactory");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Object obj = null;
		try {
			obj = c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReaderFactory rd = (ReaderFactory)obj;
		reader = rd.createReader();
		reader.read("XͼƬ");
	}

}
