package Interpreter;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P276
 * Ϊ���ݿⱸ�ݺ�ͬ������һ�׼򵥵����ݿ�ͬ��ָ�
 * ͨ��ָ����Զ����ݿ��е����ݺͽṹ���б���
 * �磺"COPY VIEW FROM srcDB to desDB" ����������ͼ��srcDB��desDB
 * �磺"MOVE TABLE Student From srcDB to desDB"������Student���srcDB��desDB
 * �����ý�����ģʽ����Ʋ�ʵ�ָ����ݿ�ͬ��ָ��
 * 
 * �Ҹо�������Ƚϼ򵥣����ķ���������ֻ�м򵥱�ʾ��û����ϱ��ʽ����Ȼ�ҿ��������һ��and�����Ӷ��ҽ������ܽ����£�
 * ���ս��:
 * expression ::= action target src des
 * �������ս����
 * action ::= COPY | MOVE
 * target ::= TABLE[table_name] | VIEW[view_name] 
 * src ::= FROM srcDB
 * des ::= TO desDB
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		//д��֮�����ݴ��Խϲ�����û���������дָ����޷�����
		String instruct1 = "COPY VIEW FROM cDB to dDB";
		String instruct2 = "MOVE TABLE Student From aDB to bDB";
		String instruct3 = "COPY TABLE Student From aDB to bDB";
		InstructionHandler handler = new InstructionHandler();
		
		System.out.println(instruct1+"�Ľ������£�");
		System.out.println(handler.handler(instruct1));
		System.out.println("-------------------");
		System.out.println(instruct2+"�Ľ������£�");
		System.out.println(handler.handler(instruct2));
		System.out.println("-------------------");
		System.out.println(instruct3+"�Ľ������£�");
		System.out.println(handler.handler(instruct3));
		
	}

}
