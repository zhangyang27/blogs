package composite;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P183
 * 设计一个控件库，控件分为两类：单元控件（按钮、文本）和容器控件（窗体、中间面板）等。
 * 试用组合模式设计该控件库。
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Button b1,b2;
		Text t1;
		Panel p1,p2;
		Window w1;
		
		b1 = new Button("b1");
		b2 = new Button("b2");
		
		t1 = new Text("t1");
		p1 = new Panel("p1");
		p2 = new Panel("p2");
		
		w1 = new Window("w1");
		
		//随便装的
		p1.add(b1);
		p1.add(t1);
		p2.add(b2);
		w1.add(p1);
		w1.add(p2);
		
		w1.onclick();
	}

}
