package chain;

public abstract class Approver {
	protected Approver successor;
	protected String name;
	public Approver(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public void setSuccessor(Approver successor){
		this.successor = successor;
	}
	abstract public void processRequest(Request re);
}
