package iterator;

import java.util.ArrayList;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P292
 * 设计一个逐页迭代器，每次可以返回指定个数（元素），并将该迭代器用于数据的分页处理。
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		Container container = new ConcreteAggregate();
		container.add("A");
		container.add("B");
		container.add("C");
		container.add("D");
		container.add("E");
		container.add("F");
		container.add("G");
		container.add("H");
		container.add("I");
		container.add("J");
		container.add("K");
		container.add("L");
		
		Iterator iter = container.createIterator();
		
		ArrayList<String> contents = iter.nextPage();
		for(String str:contents){
			System.out.println(str);
		}
		System.out.println("----------第二页------------");		
		contents = iter.nextPage();
		for(String str:contents){
			System.out.println(str);
		}
		System.out.println("----------最后一页------------");		
		contents = iter.nextPage();
		for(String str:contents){
			System.out.println(str);
		}
	}
}
