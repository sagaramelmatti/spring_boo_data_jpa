package java8.predicates;

import java.util.function.Predicate;

public class DemoCustomPredicate {
	
	public static void main(String[] args) {
		
		Predicate<Integer> predicate = t -> t >= 10;
		
		System.out.println(predicate.test(9));


		// another way to use predicates is by lambda expressions
		
		/*
		
		
		System.out.println(predicate.test(19)); // false
		*/
		
		
		
		
		//Predicate<Integer> greaterThan45 = x -> x > 45;
		//System.out.println(greaterThan45.test(90)); // true
		//System.out.println(greaterThan45.test(30)); // false
	}
}
