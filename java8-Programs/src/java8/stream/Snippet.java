package java8.stream;

import java.util.Arrays;
import java.util.List;

public class Snippet {
	
	public static void main(String args[]) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		numbers.stream().filter(number -> number < 3).forEach(number -> System.out.print(number + ","));
		
	}
}
