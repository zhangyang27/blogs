package Mediator;

public class ConcreteWindow implements Windows {
	public TextPane tp;
	public ListPane lp;
	public GraphicPane gp;
	
	@Override
	public void componentChanged(Pane e) {
		// TODO Auto-generated method stub
		if(e == tp){
			lp.update("TextPane被点");
		}else if(e == lp){
			gp.update("ListPane被点");
		}

	}

}
