package builder;

abstract class InterfaceBuilder {
	protected static Interface interf = new Interface();
	public abstract void buildMenu();
	public abstract void buildController();
	public abstract void buildMainWindows();
	public abstract void buildList();
	public boolean isController(){
		return true;
	}
	public boolean isMenu(){
		return true;
	}
	public boolean isList(){
		return true;
	}
	public boolean isMainWindows(){
		return true;
	}
	public Interface construct(){
		if(this.isMenu()){
			this.buildMenu();
		}
		if(this.isController()){
			this.buildController();
		}
		if(this.isMainWindows()){
			this.buildMainWindows();
		}
		if(this.isList()){
			this.buildList();
		}
		return interf;
	}
}
