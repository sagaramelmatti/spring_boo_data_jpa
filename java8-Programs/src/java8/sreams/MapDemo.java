package java8.sreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {

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
		List<Integer> newList = list.stream()
			.map(i -> i * 10)
			.collect(Collectors.toList());
		System.out.println(newList);
		
		
	}
}
