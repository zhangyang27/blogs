package Interpreter;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P276
 * 为数据库备份和同步开发一套简单的数据库同步指令，
 * 通过指令可以对数据库中的数据和结构进行备份
 * 如："COPY VIEW FROM srcDB to desDB" 则复制所有视图从srcDB到desDB
 * 如："MOVE TABLE Student From srcDB to desDB"，则复制Student表从srcDB到desDB
 * 试着用解释器模式来设计并实现该数据库同步指令
 * 
 * 我感觉这套题比较简单，从文法规则来看只有简单表示，没有组合表达式（当然我可以再添加一个and），从而我将规则总结如下：
 * 非终结符:
 * expression ::= action target src des
 * 下面是终结符：
 * action ::= COPY | MOVE
 * target ::= TABLE[table_name] | VIEW[view_name] 
 * src ::= FROM srcDB
 * des ::= TO desDB
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		//写完之后发现容错性较差，比如用户不按规则写指令，将无法报错
		String instruct1 = "COPY VIEW FROM cDB to dDB";
		String instruct2 = "MOVE TABLE Student From aDB to bDB";
		String instruct3 = "COPY TABLE Student From aDB to bDB";
		InstructionHandler handler = new InstructionHandler();
		
		System.out.println(instruct1+"的解释如下：");
		System.out.println(handler.handler(instruct1));
		System.out.println("-------------------");
		System.out.println(instruct2+"的解释如下：");
		System.out.println(handler.handler(instruct2));
		System.out.println("-------------------");
		System.out.println(instruct3+"的解释如下：");
		System.out.println(handler.handler(instruct3));
		
	}

}
