package flyweight;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P207
 * 开发一个文档编辑器，文档中可以插入图片、动画、视频
 * 图片、视频、动画会多次重复出现，并且每次大小和位置都不同。
 * 使用享元模式设计此文档编辑器。
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Editor editor = new Editor();
		ElementFactory ef = new ElementFactory();
		//下面创建元素、并模拟写入文档
		Element str1 = ef.createEle("下面是听力考试");
		editor.add(str1, 1, 1, 1);
		Element str2 = ef.createEle("请观察视频，听对话，并回答问题:");
		editor.add(str2, 2, 1, 1);
		
		Element v1 = ef.createEle("听力.mp4");
		editor.add(v1, 3, 1, 1);
		
		Element str3 = ef.createEle("请再看一遍:");
		editor.add(str3, 4, 1, 1);
		
		Element v2 = ef.createEle("听力.mp4");
		editor.add(v2, 5, 1, 2);
		
		Element str4 = ef.createEle("请回答如下问题...");
		editor.add(str4, 6, 1, 1);
		
		editor.each();
		
		//没有使用Picture，没关系，例子只是讲明享元模式
		//v1和v2是否是同一个对象呢？如果是，则符合享元模式。
		System.out.println(v1==v2);
	}

}
