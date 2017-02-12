package visitor;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P379
 * 为高校开发一套奖励审批系统，该系统可以实现教师奖励和学生奖励的审批
 * 教师论文数超过10篇或者学生论文发表超过2篇即可获得科研奖
 * 教师的教学反馈分大于90或者学生的平均成绩大于90可获得成绩优秀奖
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		EmployeeList emlist = new EmployeeList();
		Student s1 = new Student("学生1", 2, 88);
		Student s2 = new Student("学生2", 3, 88);
		Student s3 = new Student("学生3", 1, 39);
		Student s4 = new Student("学生4", 3, 90);
		Student s5 = new Student("学生5", 2, 99);
		Student s6 = new Student("学生6", 0, 29);
		Student s7 = new Student("学生7", 1, 81);
		
		Teacher t1 = new Teacher("老师a", 0, 88);
		Teacher t2 = new Teacher("老师b", 1, 78);
		Teacher t3 = new Teacher("老师c", 31, 93);
		Teacher t4 = new Teacher("老师d", 22, 90);
		Teacher t5 = new Teacher("老师e", 1, 89);
		Teacher t6 = new Teacher("老师f", 1, 99);
		Teacher t7 = new Teacher("老师g", 13, 71);
		
		emlist.addEmployee(s1);
		emlist.addEmployee(s2);
		emlist.addEmployee(s3);
		emlist.addEmployee(s4);
		emlist.addEmployee(s5);
		emlist.addEmployee(s6);
		emlist.addEmployee(s7);
		
		emlist.addEmployee(t1);
		emlist.addEmployee(t2);
		emlist.addEmployee(t3);
		emlist.addEmployee(t4);
		emlist.addEmployee(t5);
		emlist.addEmployee(t6);
		emlist.addEmployee(t7);
		
		AwardCheck scienceAward = new ScienceAward();
		AwardCheck studyCheck = new StudyAward();
		
		emlist.accept(scienceAward);
		emlist.accept(studyCheck);
		
	}
}
