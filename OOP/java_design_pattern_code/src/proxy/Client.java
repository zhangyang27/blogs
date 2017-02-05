package proxy;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P210
 * 利用代理模式完成收费商务信息查询系统
 * 进行商务信息查询之前需要对用户进行验证，只有合法用户才能使用。
 * 进行商务查询时，记录查询次数，以便根据查询信息收费。
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Data data = new ProxyData();
		System.out.println(data.getData("zhangsan", 10));
		
		System.out.println(data.getData("zhangyang27", 11));
		System.out.println(data.getData("zhangyang27", 10));
	}

}
