package command;

public class OpenCommand implements Command {
	BoardScreen boardscreen;
	

	public OpenCommand(BoardScreen boardscreen) {
		super();
		this.boardscreen = boardscreen;
	}


	@Override
	public void excute() {
		// TODO Auto-generated method stub
		boardscreen.open();
		
	}

}
