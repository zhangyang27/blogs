package abstractFactory;

public interface SystemFactory {
	public OperationController createOperationController();
	public InterfaceController createInterfaceController();
}
