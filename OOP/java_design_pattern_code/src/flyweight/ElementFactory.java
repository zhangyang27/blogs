package flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ElementFactory {
	//final������ֻ�ܱ���ֵһ��
	private final Map<String,Element> elements;
	public ElementFactory(){
		elements = new HashMap<String, Element>();
	}
	/**
	 * ����name����������Ϣ������
	 * String: sdfasfa
	 * Picture: hello.jpg
	 * Vedio: queen.mp4
	 * ��������Կ��������Ӳ���https://github.com/iluwatar/java-design-patterns/blob/master/flyweight�ĺ�
	 * ��Ϊ��Ƶ��ͼƬ�������������滹����һ��map�����أ�����������ġ���Ϊһ��map��̫���ʡ�
	 * ����Ϊ�˼�����һ��map�����
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
