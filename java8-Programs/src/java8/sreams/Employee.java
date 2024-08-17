package java8.sreams;

public class Employee implements Comparable<Employee> {
	
	int empId;
	
	String empName;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

	@Override
	public int compareTo(Employee o) {

		return this.getEmpName().compareTo(o.getEmpName());
	}

}
