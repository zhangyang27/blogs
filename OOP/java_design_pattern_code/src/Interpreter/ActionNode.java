package Interpreter;

public class ActionNode extends AbstractNode {
	private String action;
	public ActionNode(String action) {
		// TODO Auto-generated constructor stub
		this.action = action;
	}
	@Override
	public String interpret() {
		// TODO Auto-generated method stub
		if(this.action.equalsIgnoreCase("MOVE")){
			return "�ƶ�";
		}else if(this.action.equalsIgnoreCase("COPY")){
			return "����";
		}else{
			return "ָ������";
		}
	}

}
