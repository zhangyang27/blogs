package visitor;

public class ScienceAward implements AwardCheck{

	@Override
	public void visit(Student st) {
		// TODO Auto-generated method stub
		if(st.getPapersNum() >  2){
			System.out.println(st.getName()+"学生获得了科研奖");
		}
		
	}

	@Override
	public void visit(Teacher te) {
		// TODO Auto-generated method stub
		if(te.getPapersNum() >  10){
			System.out.println(te.getName()+"教师获得了科研奖");
		}
		
	}

}
