package iterator2;

import java.util.*;

/**
 * ̹��˵���Ҳ�֪���ǲ���û����ȷ��ᵽ�����˼����ô���ġ�
 * @author zhangyang27
 *
 */
public class reverseAge implements Iterator<Student> {
	private List<Student> sts;
	int cursor = 0 ;
 	public reverseAge(ArrayList<Student> students) {
		// TODO Auto-generated constructor stub
 		Collections.sort(students,c); //��������Ѵ�������students�ڲ���˳��Ҳ�ı��ˡ���������������Ȳ�����
 		this.sts = students;

	}

	@Override
	public boolean hasNext() {
		if(cursor >= this.sts.size()){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public Student next() {
		return this.sts.get(cursor++);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	static Comparator<Student> c = new Comparator<Student>(){  
        public int compare(Student a0, Student a1) {  
        	Student s1 = (Student) a0;  
        	Student s2 = (Student) a1;  
            if(s1.getAge() > s2.getAge()){  
                return -1;
            }else{  
                return 1; 
            }  
        }  
    };  

}
