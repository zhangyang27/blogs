package prototype;

import java.io.IOException;

public class Client {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//ǳ��¡
		Address ad = new Address("zhangsan address");
		Customer1 c1 = new Customer1("����", ad,11);
		Customer1 c2 = c1.clone(); 
		System.out.println(c1 == c2);
		System.out.println(c1.getName() == c2.getName());
		System.out.println(c1.getAddress() == c2.getAddress());
		System.out.println(c1.getAge() == c2.getAge()); //����true���������͵�==�ǱȽ����ݣ��������ͱȽϵ�ַ
		System.out.println("*****���********"); 
		//���¡
		CustomerDeepCopy cdp1 = new CustomerDeepCopy("����", ad,11);
		CustomerDeepCopy cdp2 = cdp1.deepclone(); 
		System.out.println(cdp1 == cdp2);
		System.out.println(cdp1.getName() == cdp2.getName());
		System.out.println(cdp1.getAddress() == cdp2.getAddress());
		System.out.println(cdp1.getAge() == cdp2.getAge()); //����true���������͵�==�ǱȽ����ݣ��������ͱȽϵ�ַ
	
	}

}
