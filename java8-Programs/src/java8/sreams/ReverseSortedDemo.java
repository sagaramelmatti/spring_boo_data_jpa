package java8.sreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseSortedDemo {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		/* With Java 8 */
		System.out.println("Even numbers With Java 8");
		list.stream()
			.sorted(Collections.reverseOrder())
			.forEach(n -> System.out.print(n +", "));
	}
}
