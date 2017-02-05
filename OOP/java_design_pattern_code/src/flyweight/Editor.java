package flyweight;
import java.util.*;
/**
 * ��������һ���ĵ��༭��
 * Element������Ÿ���Ԫ�أ��ַ�����ͼƬ����Ƶ�ȵ�
 * @author zhangyang27
 */
public class Editor {
	private List<String> content;
	public Editor(){
		this.content = new ArrayList<String>();
	}
	
	/**
	 * ������԰Ѳ�ͬ��Ԫ�ط����ڲ�ͬ��λ�úͲ�ͬ�Ĵ�С
	 * @param e
	 * @param x
	 * @param y
	 * @param size
	 */
	public void add(Element e,int x,int y,int size){
		String s = "��<<"+e.getContent()+">>����X:"+x+",Y:"+y+"����СΪ��"+size;
		this.content.add(s);
	}
	
	public void each(){
		for(String s:this.content){
			System.out.println(s);
		}
	}
}
