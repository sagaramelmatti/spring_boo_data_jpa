package staticInnerClassPackage;

class OuterClass {

	int x = 10;
	
	static class InnerClass {
		int y = 5;

		public void showInner() {
			//System.out.println("x= " + x);
			System.out.println("y= " + y);
		}
	}

}

public class InnerOutDemoStatic {

	public static void main(String[] args) {
		
		OuterClass.InnerClass obj = new OuterClass.InnerClass();
		
		obj.showInner();
	}
}
