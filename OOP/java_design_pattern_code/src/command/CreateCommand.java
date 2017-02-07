package command;

public class CreateCommand implements Command {
	BoardScreen boardscreen;
	

	public CreateCommand(BoardScreen boardscreen) {
		super();
		this.boardscreen = boardscreen;
	}


	@Override
	public void excute() {
		// TODO Auto-generated method stub
		boardscreen.create();
		
	}

}
