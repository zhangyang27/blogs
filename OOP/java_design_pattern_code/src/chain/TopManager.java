package chain;

public class TopManager extends Approver {

	public TopManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processRequest(Request re) {
		// TODO Auto-generated method stub
		if(re.getDay() <= 30){
			System.out.println(this.name+"通过了"+re.getName()+"的请假："+re.getDay()+"天");
		}else{
			
			System.out.println(re.getDay()+"天的假期因太长，不批准");
		}
	}

}
