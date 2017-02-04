package abstractFactory;


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
