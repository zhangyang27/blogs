package strategy;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P366
 * 开发一款飞行模拟器，模拟不同飞机的飞行特征和起飞特征，具体特征见图
 * 图见本目录的README.md
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		
		Aircraft aircraft = new Harrier();
		aircraft.fly();
	}

}
