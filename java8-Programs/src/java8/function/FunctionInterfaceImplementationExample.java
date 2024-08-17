package java8.function;

import java.util.function.Function;

class CustomFunctionInterface implements Function<String, Integer> {

	
	@Override
	public Integer apply(String t) {
		return t.length();
	}
}

public class FunctionInterfaceImplementationExample {
	
	public static void main(String[] args) {
		
		CustomFunctionInterface customFunctionInterface = new CustomFunctionInterface();
		
		System.out.println(customFunctionInterface.apply("Hello World"));
	}
}