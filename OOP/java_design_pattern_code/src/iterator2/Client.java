package iterator2;

import java.util.*;
import java.util.*;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P291
 * 一个班级包含很多学生，
 * 使用Java内置的迭代器实现对学生信息的遍历，
 * 要求按学生年龄由大到小的次序输出学生的信息。
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		Class _class = new Class();
		_class.add(new Student("A", 12));
		_class.add(new Student("B", 3));
		_class.add(new Student("c", 15));
		ArrayList<Student>  sts = _class.getContainer();
		for(Student st:sts){
			System.out.println(st);
		}
		System.out.println("----使用逆年龄迭代器----");
		
		Iterator<Student> itr = (Iterator<Student>) _class.createIterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		System.out.println("----原动态数组----");
		sts = _class.getContainer();
		for(Student st:sts){
			System.out.println(st); //看结果果然元素位置改变了，符合预期
		}
		
	}
}
