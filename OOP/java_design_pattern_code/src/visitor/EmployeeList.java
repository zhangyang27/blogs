package visitor;

import java.util.*;
public class EmployeeList {
	private ArrayList<Employee> list = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee){
		list.add(employee);
	}
	
	public void accept(AwardCheck ad){
		for(Object obj:list){
			((Employee)obj).accept(ad);
		}
	}
	
	
	
}
