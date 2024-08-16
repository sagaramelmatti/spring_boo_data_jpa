package innerClassPackage;

class Outer {

	int x = 10;

	class InnerClass {
		
		int y = 5;

		public void showInner() {
			System.out.println("x= " + x);
			System.out.println("y= " + y);
		}
	}

}

public class InnerOutDemo {

	public static void main(String[] args) {
		
		Outer outer = new Outer();

		Outer.InnerClass obj = outer.new InnerClass();
		obj.showInner();
	}
}
