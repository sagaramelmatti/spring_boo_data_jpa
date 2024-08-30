package java8.sreams.staticmethod;

interface TestInterface {

	void square(int a);

	static void show() {
		System.out.println("Default Method Executed TestInterface");
	}
}

class TestClass implements TestInterface {

	public void square(int a) {
		System.out.println(a * a);
	}
	
	public static void show() {
		System.out.println("Default Method Executed TestClass");
	}
}

public class StaticMethodDemo {

	public static void main(String[] args) {
		
		TestClass testClass = new TestClass();
		testClass.square(4);
		testClass.show();

		// default method executed
		TestInterface.show();

	}

}
