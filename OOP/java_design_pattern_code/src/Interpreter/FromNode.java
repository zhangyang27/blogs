package Interpreter;
/**
 * 只有一个关键字 FROM，所以不要action来区分
 * @author zhangyang27
 *
 */
public class FromNode extends AbstractNode {
	
	private String target;
	public FromNode(String target) {
		// TODO Auto-generated constructor stub
		this.target = target;
	}
	
	@Override
	public String interpret() {
		return "从"+this.target;
	}

}
