package composite;
import java.util.*;
public class Panel implements Widget {
	private ArrayList<Widget> contains = new ArrayList<Widget>();
	private String name;
	public Panel(String name){
		this.name = name;
	}
	
	public void add(Widget w){
		contains.add(w);
	}
	
	
	public void remove(Widget w){
		contains.remove(w);
	}
	
	public Widget getChild(int index){
		return contains.get(index);
	}
	
	@Override
	public void onclick() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"panel±»µã»÷ÁË");
		for(Widget w:contains){
			w.onclick();
		}
	}

}
