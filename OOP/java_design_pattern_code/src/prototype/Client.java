package prototype;

import java.io.IOException;
/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P104
 * Sunny软件公司在某销售管理系统中设计并实现了一个客户类Customer
 * 其包含一个客户地址的成员变量，客户地址类型为Address，用浅克隆和深克隆分别实现
 * Customer对象的复制。
 *
 */
public class Client {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//浅克隆
		Address ad = new Address("zhangsan address");
		Customer1 c1 = new Customer1("张三", ad,11);
		Customer1 c2 = c1.clone(); 
		System.out.println(c1 == c2);
		System.out.println(c1.getName() == c2.getName());
		System.out.println(c1.getAddress() == c2.getAddress());
		System.out.println(c1.getAge() == c2.getAge()); //返回true，基本类型的==是比较内容，引用类型比较地址
		System.out.println("*****下面是深克隆********"); 
		//深克隆
		CustomerDeepCopy cdp1 = new CustomerDeepCopy("张三", ad,11);
		CustomerDeepCopy cdp2 = cdp1.deepclone(); 
		System.out.println(cdp1 == cdp2);
		System.out.println(cdp1.getName() == cdp2.getName()); //name是String类型，不是基本类型
		System.out.println(cdp1.getAddress() == cdp2.getAddress());
		System.out.println(cdp1.getAge() == cdp2.getAge()); //返回true，基本类型的==是比较内容，引用类型比较地址
	
	}

}
