package Observer;

import java.util.*;

public class Buyer implements Observer {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void buy(Stock st){
		stocks.add(st.getName());
		st.addObserver(this);
	}
	
	public Buyer(String name) {
		super();
		this.name = name;
		this.stocks = new ArrayList<String>();
	}

	private String name;
	private List<String> stocks;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("客户"+this.name+"您好，您购买的股票波动超过10%，当前价为:"+arg1);
	}

}
