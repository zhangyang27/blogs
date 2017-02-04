package adapter;

public class Client {

	public static void main(String[] args) {
		String a = "abc";
		//之前的加密策略，书上是用配置文件加反射产生的对象，我这里直接使用new
		Encrypt en = new OldEncrypt();
		//使用了对象适配器
		en = new EncryptAdapter();
		//使用类适配器
		en = new ClassAdapter();
		String afterEncrypt = en.encrypt(a);
	
		//后续处理：储存进数据库
		System.out.println(afterEncrypt+"加密完毕，并存储进数据库");
	}

}
