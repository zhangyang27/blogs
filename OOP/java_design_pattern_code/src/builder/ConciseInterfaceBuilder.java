package builder;

public class ConciseInterfaceBuilder extends InterfaceBuilder {

	@Override
	public void buildMenu() {
		interf.setMenu("�������ģʽ�Ĳ˵�");

	}

	@Override
	public void buildController() {
		// TODO Auto-generated method stub
		interf.setController("�������ģʽ�Ŀ�����");
	}

	@Override
	public void buildMainWindows() {
		// TODO Auto-generated method stub
		interf.setMainWindows("�������ģʽ��������");
	}

	@Override
	public void buildList() {
		// TODO Auto-generated method stub
		interf.setList("�������ģʽ�Ĳ����б�");
	}
	

	public boolean isMenu(){
		return false;
	}
	public boolean isList(){
		return false;
	}


}
