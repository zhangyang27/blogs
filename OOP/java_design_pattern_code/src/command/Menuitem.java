package command;

public class Menuitem {
	private String name;
	public Menuitem(String name) {
		super();
		this.name = name;
	}
	private Command command;
	
	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void onclick(){
		command.excute();
	}
	public String toString(){
		return name;
	}
	
}
