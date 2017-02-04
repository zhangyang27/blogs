package decorator;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P181
 * 开发一个数据加密模块。有简单的位移加密、逆向输出加密、求模加密；
 * 但是用户不满足一种加密效果。想在位移加密后的再使用逆向输出加密和求模加密。
 * 使用装饰者模式来满足用户需求。
 * @author zhangyang27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		String s = "abc";
		Encrypt encrypt = new ModEncrypt(new ReverseEncrypt(new ShiftEncrypt()));
		String afterEncryptStr = encrypt.encrypt(s);
		System.out.println(afterEncryptStr);
		//写完代码之后觉得挺神奇、挺有趣的 2017-02-04 17:20:52 哈哈
	}

}
