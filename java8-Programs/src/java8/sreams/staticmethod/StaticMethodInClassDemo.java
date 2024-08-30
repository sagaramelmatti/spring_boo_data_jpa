package java8.sreams.staticmethod;
class A {
	void print() {
		System.out.println("print Method Executed A");
	}
	static void show() {
		System.out.println("show Method Executed A");
	}
}
class B extends A {
	
	void print() {
		System.out.println("print Method Executed B");
	}
	public static void show() {
		System.out.println("show Method Executed B");
	}
}
public class StaticMethodInClassDemo {
	public static void main(String[] args) {
		B b = new B();
		b.print();
		b.show();
		
		A a = new B();
		a.print(); // print Method Executed B
		a.show(); // show Method Executed B , show Method Executed A
		
		A a1 = new A();
		a1.print(); // print Method Executed A
		a1.show(); // show Method Executed A


		// default method executed
		//TestInterface.show();

	}

}
