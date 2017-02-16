package iterator2;

import java.util.*;


public class Class {
	private List<Student> students = new ArrayList<Student>();
	
	public void add(Student e){
		this.students.add(e);
	}
	
	public ArrayList getContainer(){
		return (ArrayList) this.students;
	}
	
	public Iterator<Student> createIterator(){
		return new reverseAge((ArrayList<Student>) this.students);
	}
}
