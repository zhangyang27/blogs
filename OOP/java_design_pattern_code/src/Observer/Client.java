package Observer;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P322
 * 实时在线股票软件
 * 当股票购买者所购买的某支股票价格变化幅度达到5%时，
 * 系统将自动发送通知（包括新价格）给购买该股票的所有股民
 * 
 * 我故意使用了Observable类和Observer接口来完成，增加对JDK的熟悉
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		Buyer b1 = new Buyer("张三");
		Buyer b2 = new Buyer("王四");
		Buyer b3 = new Buyer("罗七");
		Buyer b4 = new Buyer("赵云");
		
		Stock st1 = new Stock("中国中铁",18);
		Stock st2 = new Stock("中国石化",27);
		
		b1.buy(st1);
		b1.buy(st2);
		
		b2.buy(st1);
		
		b3.buy(st2);
		

		b4.buy(st1);
		b4.buy(st2);
		
		System.out.println(st1.getName()+"目前有用购买者人数："+st1.countObservers());
		
		st1.setPrice(17);
		st1.setPrice(40);
	}

}
