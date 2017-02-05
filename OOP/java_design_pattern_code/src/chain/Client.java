package chain;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P237
 * 用职责链模式开发假条审批模块
 * 请假小于三天，主任可批；
 * 三天到十天，经理可批；
 * 十天到三十天；总经理可批；
 * 大于三十天则直接拒绝；
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Approver director,manager,topManager;
		director = new Director("主任");
		manager = new Manager("经理");
		topManager = new TopManager("总经理");
		
		//客户端动态建链
		director.setSuccessor(manager);
		manager.setSuccessor(topManager);
		
		//处理请求
		Request re = new Request("张三", 1);
		director.processRequest(re);
		re = new Request("张三", 5);	
		director.processRequest(re);
		re = new Request("张三", 6);	
		director.processRequest(re);
		re = new Request("张三", 15);	
		director.processRequest(re);
		re = new Request("张三", 32);
		director.processRequest(re);
		
	}

}
