package proxy;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P210
 * ���ô���ģʽ����շ�������Ϣ��ѯϵͳ
 * ����������Ϣ��ѯ֮ǰ��Ҫ���û�������֤��ֻ�кϷ��û�����ʹ�á�
 * ���������ѯʱ����¼��ѯ�������Ա���ݲ�ѯ��Ϣ�շѡ�
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Data data = new ProxyData();
		System.out.println(data.getData("zhangsan", 10));
		
		System.out.println(data.getData("zhangyang27", 11));
		System.out.println(data.getData("zhangyang27", 10));
	}

}
