package visitor;

public class Student implements Employee {
	public Student(String name, int papersNum, int score) {
		super();
		this.name = name;
		this.papersNum = papersNum;
		this.score = score;
	}

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPapersNum() {
		return papersNum;
	}

	public void setPapersNum(int papersNum) {
		this.papersNum = papersNum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private int papersNum;
	private	int score;

	
	@Override
	public void accept(AwardCheck handler) {
		// TODO Auto-generated method stub
		handler.visit(this);
	}

}
