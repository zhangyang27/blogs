package adapter;

public class Client {

	public static void main(String[] args) {
		String a = "abc";
		//֮ǰ�ļ��ܲ��ԣ��������������ļ��ӷ�������Ķ���������ֱ��ʹ��new
		Encrypt en = new OldEncrypt();
		//ʹ���˶���������
		en = new EncryptAdapter();
		//ʹ����������
		en = new ClassAdapter();
		String afterEncrypt = en.encrypt(a);
	
		//����������������ݿ�
		System.out.println(afterEncrypt+"������ϣ����洢�����ݿ�");
	}

}
