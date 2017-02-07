package command;

public class EditCommand implements Command {
	BoardScreen boardscreen;
	

	public EditCommand(BoardScreen boardscreen) {
		super();
		this.boardscreen = boardscreen;
	}


	@Override
	public void excute() {
		// TODO Auto-generated method stub
		boardscreen.edit();
		
	}

}
