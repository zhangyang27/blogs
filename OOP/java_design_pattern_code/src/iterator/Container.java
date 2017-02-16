package iterator;

import java.util.*;

abstract class Container {
	List<String> container = new ArrayList<String>();
	public void add(String obj){
		this.container.add(obj);
	}
	public abstract Iterator createIterator();
	
}
