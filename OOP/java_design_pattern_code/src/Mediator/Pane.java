package Mediator;

abstract class Pane {
	Windows windows;
	public void setWindows(Windows w){
		this.windows = w;
	}
	
	public void onclick(){
		this.windows.componentChanged(this);
	};
	
	public abstract void update(String message);
}
