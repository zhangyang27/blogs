package singleton;
import java.util.*;
/*
 * ����һ�����ݿ����ӳأ���Ӧ����һ������
 * ���ܹ�ӵ��ָ�����������Ӷ��󣬲����ڲ�ѯʱ����ӳ�������ѡ���Ӷ��������ӡ�
 */
public class DBconnectionPool {
	private List<String> connecionList = null;
	
	//�����췽��˽�л�����Ϊ�ǵ�����
	private DBconnectionPool(){
		connecionList = new ArrayList<String>();
	};
	
	//���ڲ���İ취����ɵ�������ĳ�ʼ����
	//����������ʵ���ӳټ���
	//�ֿ��Ա�֤�̰߳�ȫ
	private static class HolderClass{
		private final static DBconnectionPool instance = new DBconnectionPool();
	}
	
	public static DBconnectionPool getInstance(){
		return HolderClass.instance;
	}

	public void addConnection(String con) {
		// TODO Auto-generated method stub
		connecionList.add(con);
		System.out.println("�������:"+con);
	}
	public void query(String sql) {
		//���ѡ��һ������
		Random rd = new Random();
		int i = rd.nextInt(connecionList.size());
		String con = connecionList.get(i);
		System.out.println("ʹ������-"+con+"-��ѯ����䣺"+sql);
	}
}
