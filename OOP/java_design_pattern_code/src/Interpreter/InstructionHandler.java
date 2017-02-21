package Interpreter;

public class InstructionHandler {
	public String handler(String instruction){
		AbstractNode action = null,target = null,from = null,to = null;
		String[] words = instruction.split(" ");
		int index = 0;
		action = new ActionNode(words[index++]);
		
		if(words[2].toUpperCase().equals("FROM")){ //字符串比较中时，注意==与equals的区别
			//那就是没有跟上特定的表名，所以是全部
			target = new TargetNode(words[index++]);
		}else{
			target = new TargetNode(words[index++],words[index++]);
		}
		index++;//跳过FROM关键字，获得FROM后名的srcDB;
		from = new FromNode(words[index++]);
		index++;//跳过TO关键字，获得to后名的desDB;
		to = new ToNode(words[index]);
		return new SentenceNode(action, target, from, to).interpret();
	}
}
