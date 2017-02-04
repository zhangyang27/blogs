package abstractFactory;

public class AndroidFactory implements SystemFactory {

	@Override
	public OperationController createOperationController() {
		// TODO Auto-generated method stub
		return new AndroidOperationController();
	}

	@Override
	public InterfaceController createInterfaceController() {
		// TODO Auto-generated method stub
		return new AndroidInterfaceController();
	}

}
