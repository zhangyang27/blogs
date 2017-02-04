package builder;

public class CompleteInterfaceBuilder extends InterfaceBuilder {

	@Override
	public void buildMenu() {
		interf.setMenu("建立完整模式的菜单");

	}

	@Override
	public void buildController() {
		// TODO Auto-generated method stub
		interf.setController("建立完整模式的控制条");
	}

	@Override
	public void buildMainWindows() {
		// TODO Auto-generated method stub
		interf.setMainWindows("建立完整模式的主窗口");
	}

	@Override
	public void buildList() {
		// TODO Auto-generated method stub
		interf.setList("建立完整模式的播放列表");
	}

}
