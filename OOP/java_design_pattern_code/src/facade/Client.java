package facade;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P194
 * �ֻ���һ�����ݹ��ܣ��ǽ��ֻ�ͨѶ¼����Ƭ�����ŵȸ��Ƶ�sd���ڡ�
 * ������Ҫ����ҵ���ཻ����ͨѶ�ࡢ��Ƭ�����ŵȣ�
 * ʹ�����ģʽ������ɡ�
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		BackupFacade backup = new BackupFacade();
		backup.backUp();
	}
}
