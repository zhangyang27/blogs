package command;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P259
 * 有一个菜单控制公告板的系统
 * 主菜单类（Menu）内有一些菜单项（MenuItem），
 * 可以通过Menu类的addMenuItem方法增加菜单项，菜单主要就是被点击
 * 菜单项的点击将调用BoardScreen内的open、create、edit等方法。
 * 试着使用命令模式来完成这个系统
 * 
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		BoardScreen boardscreen = new BoardScreen();
		
		Menuitem mi1 = new Menuitem("菜单1");
		Menuitem mi2 = new Menuitem("菜单2");
		
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
