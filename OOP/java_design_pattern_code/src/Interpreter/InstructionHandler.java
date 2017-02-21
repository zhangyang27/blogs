package Interpreter;

public class InstructionHandler {
	public String handler(String instruction){
		AbstractNode action = null,target = null,from = null,to = null;
		String[] words = instruction.split(" ");
		int index = 0;
		action = new ActionNode(words[index++]);
		
		if(words[2].toUpperCase().equals("FROM")){ //�ַ����Ƚ���ʱ��ע��==��equals������
			//�Ǿ���û�и����ض��ı�����������ȫ��
			target = new TargetNode(words[index++]);
		}else{
			target = new TargetNode(words[index++],words[index++]);
		}
		index++;//����FROM�ؼ��֣����FROM������srcDB;
		from = new FromNode(words[index++]);
		index++;//����TO�ؼ��֣����to������desDB;
		to = new ToNode(words[index]);
		return new SentenceNode(action, target, from, to).interpret();
	}
}
