package Memento;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P322
 * ��һ��RPG���Σ�Ϊ�˸�����ṩ���෽�㣬����Ϸ�����л�����һ���ָ���
 * ���ڱ��浱ǰ����Ϸ������������Ϸ��������ҽ�ɫ������������
 * ���Է��ص���ǰ����ĳ�����������Ļָ��㿪ʼ��Ϸ��
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		Caretaker ct = new Caretaker();
		
		GameSense gs = new GameSense("սʿ�۰�����", "���ڹ���", "��˪��", "123");
		gs.display();
		ct.save(gs.generateMemento());
		
		gs.setPlace("����֮��");
		gs.setGold("550");
		gs.display();
		ct.save(gs.generateMemento());
		
		gs.setGoods("������");
		gs.setGold("670");
		gs.display();
		System.out.println("��ɫ����...�ָ�...");
		gs.restoreFromMemento(ct.getMementoGameSense());
		gs.display();
		
	}

}
