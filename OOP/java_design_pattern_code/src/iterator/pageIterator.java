package iterator;

import java.util.*;

public class pageIterator implements Iterator{
	
	private List<String> container;
	private int cursor;
	private int MAXPAGE = 5;
	
	public pageIterator(List<String> container2) {
		// TODO Auto-generated constructor stub
		this.container = container2;
		this.cursor = 0;
	}
	@Override
	public ArrayList<String> nextPage() {
		// TODO Auto-generated method stub
		
		List<String> ret = new ArrayList<String>();
		int flag = 1;
		while(this.cursor<container.size()){
			ret.add((String) container.get(this.cursor));
			this.cursor++;
			if(flag++ >= MAXPAGE){
				break;
			}
		}
		return (ArrayList<String>) ret;
		
	}

}
