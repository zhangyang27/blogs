package singleton;
/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P276
 * ����һ�����ݿ����ӳأ���Ӧ����һ������
 * ���ܹ�ӵ��ָ�����������Ӷ��󣬲����ڲ�ѯʱ����ӳ�������ѡ���Ӷ��������ӡ�
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBconnectionPool db1,db2,db3;
		db1 = DBconnectionPool.getInstance();
		db2 = DBconnectionPool.getInstance();
		db3 = DBconnectionPool.getInstance();
		
		
		//������Ӷ���
		db1.addConnection("con1");
		db2.addConnection("con2");
		db3.addConnection("con3");
		
		//�������Ӷ���
		db1.query("select * from user");
		db2.query("select * from info");
		db3.query("show processlist");
		db1.query("select id from user where name = '1'");
		
		if(db1 == db2 && db2 == db3){
			System.out.println("ֻ��һ�����ݿ����ӳأ�����ģʽ�ɹ�");
		}
	}

}
