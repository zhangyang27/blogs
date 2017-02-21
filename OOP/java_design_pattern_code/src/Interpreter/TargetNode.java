package Interpreter;

public class TargetNode extends AbstractNode {
	private String action;
	private String target;
	public TargetNode(String action,String target) {
		// TODO Auto-generated constructor stub
		this.action = action;
		this.target = target;
	}
	public TargetNode(String action) {
		// TODO Auto-generated constructor stub
		this.action = action;
		this.target = null;
	}
	@Override
	public String interpret() {
		// TODO Auto-generated method stub
		String output = "";
		if(this.action.equalsIgnoreCase("TABLE")){
			output += "��";
		}else if(this.action.equalsIgnoreCase("VIEW")){
			output += "��ͼ";
		}else{
			output += "ָ������";
		}
		if(this.target == null){
			output += "ȫ��";
		}else{
			output += this.target;
		}
		return output;
	}

}
