package java8.function;

import java.util.function.Function;

public class FunctionInterfaceAnonymousClassImplementationExample {

	public static void main(String[] args) {

		Function<String, Integer> function = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};

		int stringLength = function.apply("Hello World");
		System.out.println("stringLength= "+ stringLength);
	}
}