package builder;

public class Client {
	/**
	 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 (1) P120
	 *
	 * 开发一款视频播放器，为了方便用户使用播放器提供了多重界面显示模式
	 * 如：完整模式、精简模式、记忆模式、网络模式
	 * 不同模式下主界面的组成元素略有差异
	 * 如在完整模式下会显示菜单、播放列表、主窗口、控制条
	 * 而在精简模式下只显示主窗口和控制条
	 * 请使用建造者模式设计此软件。
	 */
	public static void main(String[] args) {
		InterfaceBuilder ib = new ConciseInterfaceBuilder();
		Interface interf = ib.construct();
		System.out.println(interf.getList());
		System.out.println(interf.getMainWindows());
		System.out.println(interf.getMenu());
		System.out.println(interf.getController());
		
	}

}
