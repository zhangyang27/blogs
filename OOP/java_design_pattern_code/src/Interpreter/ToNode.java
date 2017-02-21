package Interpreter;
/**
 * 只有一个关键字 to，所以不要action来区分
 * @author zhangyang27
 *
 */
public class ToNode extends AbstractNode {
	
	private String target;
	public ToNode(String target) {
		// TODO Auto-generated constructor stub
		this.target = target;
	}
	
	@Override
	public String interpret() {
		return "到"+this.target;
	}

}
