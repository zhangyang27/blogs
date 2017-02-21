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
			output += "表";
		}else if(this.action.equalsIgnoreCase("VIEW")){
			output += "视图";
		}else{
			output += "指令有误";
		}
		if(this.target == null){
			output += "全部";
		}else{
			output += this.target;
		}
		return output;
	}

}
