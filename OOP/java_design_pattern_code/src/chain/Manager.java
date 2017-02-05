package chain;

public class Manager extends Approver {

	public Manager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processRequest(Request re) {
		// TODO Auto-generated method stub
		if(re.getDay() <= 10){
			System.out.println(this.name+"通过了"+re.getName()+"的请假："+re.getDay()+"天");
		}else{
			this.successor.processRequest(re);
		}
	}

}
