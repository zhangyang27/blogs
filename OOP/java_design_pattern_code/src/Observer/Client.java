package Observer;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P322
 * ʵʱ���߹�Ʊ���
 * ����Ʊ�������������ĳ֧��Ʊ�۸�仯���ȴﵽ5%ʱ��
 * ϵͳ���Զ�����֪ͨ�������¼۸񣩸�����ù�Ʊ�����й���
 * 
 * �ҹ���ʹ����Observable���Observer�ӿ�����ɣ����Ӷ�JDK����Ϥ
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		Buyer b1 = new Buyer("����");
		Buyer b2 = new Buyer("����");
		Buyer b3 = new Buyer("����");
		Buyer b4 = new Buyer("����");
		
		Stock st1 = new Stock("�й�����",18);
		Stock st2 = new Stock("�й�ʯ��",27);
		
		b1.buy(st1);
		b1.buy(st2);
		
		b2.buy(st1);
		
		b3.buy(st2);
		

		b4.buy(st1);
		b4.buy(st2);
		
		System.out.println(st1.getName()+"Ŀǰ���ù�����������"+st1.countObservers());
		
		st1.setPrice(17);
		st1.setPrice(40);
	}

}
