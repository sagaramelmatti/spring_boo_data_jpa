package java8.sreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		
		Department d1 = new Department(1, "Sales");
		Employee e1 = new Employee(1001, "Rahul", d1);
		
		Department d2 = new Department(2, "Finance");
		Employee e3 = new Employee(1003, "Sacin", null);
		
		Department d3 = new Department(3, "R & D");
		Employee e2 = new Employee(1002, "Saurav", d3);

		list.add(e1);
		list.add(e2);
		list.add(e3);
		
	
		// Java 7
		for(Employee employee : list) {
			
			Optional<Employee> employeeObj = Optional.of(employee);
			
			if(employeeObj.isPresent()) {
				System.out.println("Emplname = "+employee.getEmpName());
				System.out.println("Emp Id = "+employee.getEmpId());
				
				Optional<Department> departmentObj = Optional.of(employee.getDepartment());
				if(departmentObj.isPresent()) {
					System.out.println("Department Name = "+employee.getDepartment().getDeptName());
				}
			}
		}
		
		//With Java 8
		//list.stream().forEach(employee -> System.out.print(employee +", "));
		
	}
}
