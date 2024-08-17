package java8.sreams;

import java.util.ArrayList;
import java.util.List;

public class CustomObjectStreamMapDemo {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		Employee e1 = new Employee(1001, "Rahul");
		Employee e3 = new Employee(1003, "Virat");
		Employee e2 = new Employee(1002, "Saurav");
		Employee e5 = new Employee(1005, "Rohit");
		Employee e4 = new Employee(1004, "Sachin");
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		
		System.out.println(list);
		
		//With Java 8
		list.stream().sorted().forEach(employee -> System.out.print(employee +", "));
		
	}
}
