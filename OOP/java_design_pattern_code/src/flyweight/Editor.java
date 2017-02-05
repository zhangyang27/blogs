package flyweight;
import java.util.*;
/**
 * 假设这是一个文档编辑器
 * Element里面放着各种元素：字符串、图片、视频等等
 * @author zhangyang27
 */
public class Editor {
	private List<String> content;
	public Editor(){
		this.content = new ArrayList<String>();
	}
	
	/**
	 * 假设可以把不同的元素放置在不同的位置和不同的大小
	 * @param e
	 * @param x
	 * @param y
	 * @param size
	 */
	public void add(Element e,int x,int y,int size){
		String s = "将<<"+e.getContent()+">>放在X:"+x+",Y:"+y+"。大小为："+size;
		this.content.add(s);
	}
	
	public void each(){
		for(String s:this.content){
			System.out.println(s);
		}
	}
}
