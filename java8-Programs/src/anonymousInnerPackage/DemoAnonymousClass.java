package anonymousInnerPackage;

abstract class Person {

	abstract void eat();
	
	abstract void sleep();
	
	abstract void walk();

}

abstract class Developer extends Person {

	@Override
	void eat() {
		// TODO Auto-generated method stub
	}
}

abstract class Manager extends Developer {

	@Override
	void sleep() {
		// TODO Auto-generated method stub
		
	}

}

class HR extends Manager{

	@Override
	void walk() {
		// TODO Auto-generated method stub
		
	}
	
}

public class DemoAnonymousClass {

	public static void main(String[] args) {

		
	}

}
