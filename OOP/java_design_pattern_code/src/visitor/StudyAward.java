package visitor;

public class StudyAward implements AwardCheck{

	@Override
	public void visit(Student st) {
		// TODO Auto-generated method stub
		if(st.getScore() >  90){
			System.out.println(st.getName()+"学生获得了学习奖");
		}
	}

	@Override
	public void visit(Teacher te) {
		// TODO Auto-generated method stub
		if(te.getScore() >  90){
			System.out.println(te.getName()+"教师获得了学习奖");
		}
	}

}
