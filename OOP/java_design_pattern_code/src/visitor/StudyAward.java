package visitor;

public class StudyAward implements AwardCheck{

	@Override
	public void visit(Student st) {
		// TODO Auto-generated method stub
		if(st.getScore() >  90){
			System.out.println(st.getName()+"ѧ�������ѧϰ��");
		}
	}

	@Override
	public void visit(Teacher te) {
		// TODO Auto-generated method stub
		if(te.getScore() >  90){
			System.out.println(te.getName()+"��ʦ�����ѧϰ��");
		}
	}

}
