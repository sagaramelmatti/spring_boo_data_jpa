package java8.sreams;

import java.util.ArrayList;
import java.util.List;

public class CustomObjectStreamFilterDemo {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		Employee e1 = new Employee(1001, "Rahul");
		Employee e2 = new Employee(1002, "Saurav");
		Employee e3 = new Employee(1003, "Virat");
		Employee e4 = new Employee(1004, "Sachin");
		Employee e5 = new Employee(1005, "Rohit");
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		
		System.out.println(list);
		
		// With Java 7
		List<Employee> filteredEmployeelist = new ArrayList<Employee>();
		for(Employee employee : list) {
			if(employee.getEmpId() <= 1003) {
				filteredEmployeelist.add(employee);
			}
		}
		System.out.println(filteredEmployeelist);
		
		// With Java 8
		list.stream().filter(employee -> employee.getEmpId() <= 1003).forEach(employee -> System.out.print(employee));
		
	}
}
