package visitor;

public class ScienceAward implements AwardCheck{

	@Override
	public void visit(Student st) {
		// TODO Auto-generated method stub
		if(st.getPapersNum() >  2){
			System.out.println(st.getName()+"ѧ������˿��н�");
		}
		
	}

	@Override
	public void visit(Teacher te) {
		// TODO Auto-generated method stub
		if(te.getPapersNum() >  10){
			System.out.println(te.getName()+"��ʦ����˿��н�");
		}
		
	}

}
