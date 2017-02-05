package flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ElementFactory {
	//final变量智只能被赋值一次
	private final Map<String,Element> elements;
	public ElementFactory(){
		elements = new HashMap<String, Element>();
	}
	/**
	 * 假设name带上类型信息，比如
	 * String: sdfasfa
	 * Picture: hello.jpg
	 * Vedio: queen.mp4
	 * 从这里可以看出这例子不如https://github.com/iluwatar/java-design-patterns/blob/master/flyweight的好
	 * 因为视频、图片用两个工厂来存还是用一个map来存呢？这是有歧义的。作为一个map不太合适。
	 * 这里为了简洁就用一个map来存吧
	 * @return
	 */
	Element createEle(String name){
		Element ele = elements.get(name);
		if (ele == null) {
			if(name.indexOf("mp4") > -1){
				ele = new Vedio(name);
			}else if(name.indexOf("jpg") > -1){
				ele = new Picture(name);
			}else{
				ele = new Strings(name);
			}
			elements.put(name,ele);
		}
		
		return ele;
	}
}
