package java8.sreams.comparator;

import java.util.ArrayList;
import java.util.List;

public class ComparatorAsAnonymousClassForSortingJava8Demo {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<Employee>();
		Employee e1 = new Employee(1001, "Sagar");
		Employee e2 = new Employee(1002, "Rahul");
		Employee e3 = new Employee(1003, "Sachin");

		list.add(e1);
		list.add(e2);
		list.add(e3);

		list.stream().sorted((o1, o2) -> o1.getEmpName().compareTo(o2.getEmpName())).forEach(employee -> System.out.println(employee));
	}
}