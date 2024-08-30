package java8.sreams.flatMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class  FlatMapDemo {

	public static void main(String[] args) {

		Address a1 = new Address("Walstreet 24","Pune", "411012");
		Address a2 = new Address("Baif Road Wagholi","Mumbai", "412207");
		Address a3 = new Address("Tower 5 Kharadi","Nagpur", "411012");
		
		
		List<Address> addressListS1 = new ArrayList<Address>();
		addressListS1.add(a1);
		addressListS1.add(a2);
		
		List<Student> studentList = new ArrayList<Student>();
		Student s1 = new Student();
		s1.setRollNumber(1001);
		s1.setName("Saurav");
		s1.setAddrress(addressListS1);
		studentList.add(s1);
		
		
		Student s2 = new Student();
		s2.setRollNumber(1002);
		s2.setName("Rahul");
		List<Address> addressListS2 = new ArrayList<Address>();
		addressListS2.add(a2);
		addressListS2.add(a3);
		s2.setAddrress(addressListS2);
		studentList.add(s2);
		
		
		//studentList.stream().forEach(student -> System.out.println(student));
		
		studentList.stream()
		.flatMap(student ->student.getAddrress().stream())
		.filter(address -> address == a2)
		.map(address -> address.getCity())
		.distinct()
		.forEach(city -> System.out.println(city));
		
		
	}

}
