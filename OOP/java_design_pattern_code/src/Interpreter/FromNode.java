package Interpreter;
/**
 * ֻ��һ���ؼ��� FROM�����Բ�Ҫaction������
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
		return "��"+this.target;
	}

}
