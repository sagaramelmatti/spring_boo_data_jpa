package java8.sreams.flatMap;

import java.util.List;

public class Student {
	
	int rollNumber;
	
	String name;
	
	List<Address> addrress;

	public Student() {
		super();
	}
	public Student(int rollNumber, String name, Address address) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.addrress = addrress;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getAddrress() {
		return addrress;
	}
	public void setAddrress(List<Address> addrress) {
		this.addrress = addrress;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", addrress=" + addrress + "]";
	}
	
	

}
