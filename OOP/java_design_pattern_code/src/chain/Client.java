package chain;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P237
 * ��ְ����ģʽ������������ģ��
 * ���С�����죬���ο�����
 * ���쵽ʮ�죬���������
 * ʮ�쵽��ʮ�죻�ܾ��������
 * ������ʮ����ֱ�Ӿܾ���
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Approver director,manager,topManager;
		director = new Director("����");
		manager = new Manager("����");
		topManager = new TopManager("�ܾ���");
		
		//�ͻ��˶�̬����
		director.setSuccessor(manager);
		manager.setSuccessor(topManager);
		
		//��������
		Request re = new Request("����", 1);
		director.processRequest(re);
		re = new Request("����", 5);	
		director.processRequest(re);
		re = new Request("����", 6);	
		director.processRequest(re);
		re = new Request("����", 15);	
		director.processRequest(re);
		re = new Request("����", 32);
		director.processRequest(re);
		
	}

}
