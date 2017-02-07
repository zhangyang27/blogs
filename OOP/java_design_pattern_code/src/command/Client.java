package command;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P259
 * ��һ���˵����ƹ�����ϵͳ
 * ���˵��ࣨMenu������һЩ�˵��MenuItem����
 * ����ͨ��Menu���addMenuItem�������Ӳ˵���˵���Ҫ���Ǳ����
 * �˵���ĵ��������BoardScreen�ڵ�open��create��edit�ȷ�����
 * ����ʹ������ģʽ��������ϵͳ
 * 
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		BoardScreen boardscreen = new BoardScreen();
		
		Menuitem mi1 = new Menuitem("�˵�1");
		Menuitem mi2 = new Menuitem("�˵�2");
		
		menu.add(mi1);
		menu.add(mi2);
		
		menu.display();
		
		Command openCm = new OpenCommand(boardscreen);
		Command createCm = new CreateCommand(boardscreen);
		
		mi1.setCommand(openCm);
		mi2.setCommand(createCm);
		
		mi1.onclick();
		mi2.onclick();
	}

}
