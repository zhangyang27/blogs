package abstractFactory;

/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P86
 * 对于手机游戏软件
 * 该软件需要支持Symbian/Android/Windows等多个平台
 * 针对不同的平台，
 * 需要实现不同的游戏控制操作类：OperationController 和 界面控制操作类InterfaceController
 * 请使用工厂类来封装这类的初始化过程。
 * 为了支持新的操作系统，请使用工厂模式对其进行设计。
 * @author zhangyang27
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceController ic;
		OperationController oc;
		SystemFactory sf = new AndroidFactory();
		ic = sf.createInterfaceController();
		oc = sf.createOperationController();
		ic.begin();
		oc.move();
		ic.exit();
		
		sf = new SymbianFactory();
		ic = sf.createInterfaceController();
		oc = sf.createOperationController();
		ic.begin();
		oc.move();
		ic.exit();
		
	}
}
