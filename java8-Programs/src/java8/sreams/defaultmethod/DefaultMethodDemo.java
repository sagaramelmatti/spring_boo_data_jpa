package java8.sreams.defaultmethod;

interface TestInterface {

	void square(int a);

	default void show() {
		System.out.println("Default Method Executed of TestInterface");
	}
}

class TestClass implements TestInterface {

	public void square(int a) {
		System.out.println(a * a);
	}
	
	@Override
	public void show() {
		TestInterface.super.show();
		System.out.println("Default Method Executed TestClass");
	}
	
}

public class DefaultMethodDemo {

	public static void main(String[] args) {
		
		TestClass  testClass = new TestClass();

		testClass.square(4);

		// default method executed
		testClass.show();

	}

}
