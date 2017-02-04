package prototype;

import java.io.IOException;

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
		System.out.println("*****深拷贝********"); 
		//深克隆
		CustomerDeepCopy cdp1 = new CustomerDeepCopy("张三", ad,11);
		CustomerDeepCopy cdp2 = cdp1.deepclone(); 
		System.out.println(cdp1 == cdp2);
		System.out.println(cdp1.getName() == cdp2.getName());
		System.out.println(cdp1.getAddress() == cdp2.getAddress());
		System.out.println(cdp1.getAge() == cdp2.getAge()); //返回true，基本类型的==是比较内容，引用类型比较地址
	
	}

}
