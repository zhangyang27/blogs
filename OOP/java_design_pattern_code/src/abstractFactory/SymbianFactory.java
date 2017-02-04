package abstractFactory;

public class SymbianFactory implements SystemFactory {

	@Override
	public SymbianOperationController createOperationController() {
		// TODO Auto-generated method stub
		return new SymbianOperationController();

	}

	@Override
	public SymbianInterfaceController createInterfaceController() {
		// TODO Auto-generated method stub
		return new SymbianInterfaceController();
	}

}
