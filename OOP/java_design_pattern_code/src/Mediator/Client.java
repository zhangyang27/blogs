package Mediator;

import java.util.ArrayList;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P309
 * 在一个图形类库中，类库需要定义预先定义若干窗格（Pane）对象，比如：TextPane/ListPane/GraphicPane
 * 窗格之间不允许直接引用，应由包含一组窗格的窗口（Windows）组成，窗口负责协调窗格之间的行为。
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		ConcreteWindow cw = new ConcreteWindow();
		Pane list = new ListPane();
		Pane graphic = new GraphicPane();
		Pane text = new TextPane();
	
		
		text.setWindows(cw);
		graphic.setWindows(cw);
		list.setWindows(cw);
		
		cw.gp = (GraphicPane) graphic;
		cw.lp = (ListPane) list;
		cw.tp = (TextPane) text;
		
		list.onclick();
		
	}
}
