package builder;

public class Client {

	public static void main(String[] args) {
		InterfaceBuilder ib = new ConciseInterfaceBuilder();
		Interface interf = ib.construct();
		System.out.println(interf.getList());
		System.out.println(interf.getMainWindows());
		System.out.println(interf.getMenu());
		System.out.println(interf.getController());
		
	}

}
