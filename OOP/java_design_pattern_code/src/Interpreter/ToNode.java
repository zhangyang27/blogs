package Interpreter;
/**
 * ֻ��һ���ؼ��� to�����Բ�Ҫaction������
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
		return "��"+this.target;
	}

}
