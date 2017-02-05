package proxy;
import java.util.*;

public class ProxyData implements Data {
	private BusniessData bd;
	private Map<String, Integer> queryCount;
	public ProxyData() {
		// TODO Auto-generated constructor stub
		this.bd = new BusniessData();
		queryCount = new HashMap<String, Integer>();
		
	}

	@Override
	public String getData(String name,int orderID) {
		//完成计费和权限检查
		if(this.validate(name)){
			this.addQueryCount(name);
			return this.bd.getData(name,orderID);
		}else{
			return "permission deny";
		}
		
	}

	private void addQueryCount(String name) {
		// TODO Auto-generated method stub
		if(queryCount.containsKey(name)){
			queryCount.put(name, queryCount.get(name)+1);
		}else{
			queryCount.put(name,0);
		}
		System.out.println("name:"+name+"--queryCount："+queryCount.get(name));
		
	}

	private boolean validate(String name) {
		// TODO Auto-generated method stub
		if(name=="zhangyang27"){
			return true;
		}
		return false;
	}

}
