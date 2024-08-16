package java8.predicates;

import java.util.function.Predicate;

public class DemoCustomPredicate {
	
	public static void main(String[] args) {
		Predicate<Integer> predicate = t -> t >= 10;
		System.out.println(predicate.test(9));
	}
}
