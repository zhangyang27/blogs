package decorator;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P181
 * ����һ�����ݼ���ģ�顣�м򵥵�λ�Ƽ��ܡ�����������ܡ���ģ���ܣ�
 * �����û�������һ�ּ���Ч��������λ�Ƽ��ܺ����ʹ������������ܺ���ģ���ܡ�
 * ʹ��װ����ģʽ�������û�����
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		String s = "abc";
		Encrypt encrypt = new ModEncrypt(new ReverseEncrypt(new ShiftEncrypt()));
		String afterEncryptStr = encrypt.encrypt(s);
		System.out.println(afterEncryptStr);
		//д�����֮�����ͦ���桢ͦ��Ȥ�� 2017-02-04 17:20:52 ����
	}

}
