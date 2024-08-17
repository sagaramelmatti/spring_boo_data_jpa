package java8.function;

import java.util.function.Function;

public class FunctionInterfaceAnonymousClassImplementationExample {

	public static void main(String[] args) {

		Function<String, Integer> function = ( t) ->  t.length();

		int stringLength = function.apply("Hello World");
		System.out.println("stringLength= "+ stringLength);
	}
}