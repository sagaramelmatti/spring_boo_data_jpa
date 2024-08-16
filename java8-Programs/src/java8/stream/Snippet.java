package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Snippet {
	public static void main(String args[]) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> lessThanThreeLambda = numbers.stream().filter(number -> number < 3).collect(Collectors.toList());
		
		System.out.println(lessThanThreeLambda);
	}
}
