package designMode.atguigu.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

//�ͻ���
public class Demeter1 {

	public static void main(String[] args) {
		System.out.println("使用迪米特法则的改进");
		//创建一个 SchoolManager 对象
		SchoolManager schoolManager = new SchoolManager();
		//输出学院员工id 和学校总部员工信息
		schoolManager.printAllEmployee(new CollegeManager());

	}

}


//ѧУ�ܲ�Ա����
class Employee {
	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}


//ѧԺ��Ա����
class CollegeEmployee {
	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}


//学院员工管理类
class CollegeManager {
	//����ѧԺ������Ա��
	public List<CollegeEmployee> getAllEmployee() {
		List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
		for (int i = 0; i < 10; i++) { //��������������10��Ա���� list
			CollegeEmployee emp = new CollegeEmployee();
			emp.setId("ѧԺԱ��id= " + i);
			list.add(emp);
		}
		return list;
	}
	
	//该方法完成输出学院总部和学院信息id
	public void printEmployee() {
		//获取到学院员工
		List<CollegeEmployee> list1 = getAllEmployee();
		System.out.println("------------学院员工------------");
		for (CollegeEmployee e : list1) {
			System.out.println(e.getId());
		}
	}
}

//学校管理类

//分析SchoolManager 类的直接朋友类有哪些  Employee  CollegeManager
//CollegeEmployee 不是直接朋友  而是一个陌生类，这样违背了迪米特法则
class SchoolManager {
	//返回学校总部的员工
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		
		for (int i = 0; i < 5; i++) { //��������������5��Ա���� list
			Employee emp = new Employee();
			emp.setId("ѧУ�ܲ�Ա��id= " + i);
			list.add(emp);
		}
		return list;
	}

	//该方法远程输出学校总部和员工信息id
	void printAllEmployee(CollegeManager sub) {
		
		//分析问题
		//1.将输出学院的员工方法 封装到CollegeManager
		sub.printEmployee();
	
		//获取到学校员工信息
		List<Employee> list2 = this.getAllEmployee();
		System.out.println("------------ѧУ�ܲ�Ա��------------");
		for (Employee e : list2) {
			System.out.println(e.getId());
		}
	}
}
