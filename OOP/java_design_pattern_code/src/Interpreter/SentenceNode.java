package Interpreter;
/**
 * 非终结符，有终结符组成了一个句子
 * @author zhangyang27
 *
 */
public class SentenceNode extends AbstractNode {
	private AbstractNode action;
	public SentenceNode(AbstractNode action, AbstractNode target, AbstractNode from,
			AbstractNode to) {
		super();
		this.action = action;
		this.target = target;
		this.from = from;
		this.to = to;
	}


	private AbstractNode target;
	private AbstractNode from;
	private AbstractNode to;
	
	
	@Override
	public String interpret() {
		return this.action.interpret()+this.target.interpret()+this.from.interpret()+this.to.interpret();
	}

}
