package command;
import java.util.*;


public class Menu {
	ArrayList<Menuitem> menuitems = new ArrayList<Menuitem>();
	
	public void add(Menuitem mi){
		this.menuitems.add(mi);
	}
	
	public void display(){
		System.out.println("�˵�����Ĳ˵��У�");
		for(Menuitem mi:this.menuitems){
			System.out.println(mi.toString());
		}
	}
}
