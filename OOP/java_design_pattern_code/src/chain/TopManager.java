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
			System.out.println(this.name+"ͨ����"+re.getName()+"����٣�"+re.getDay()+"��");
		}else{
			
			System.out.println(re.getDay()+"��ļ�����̫��������׼");
		}
	}

}
