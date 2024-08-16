package java8.functionalInterface;


@FunctionalInterface 
interface Shapes {
	
   int calculateArea(int length , int width);  // SAM ( 
}


public class TestFunctionalInterface {
    public static void main(String args[])
    {
    	Shapes shapes = ( length,  width) -> length * width;
    	
    	int area = shapes.calculateArea(10, 5);
    	System.out.println("Area = "+area);
    }
}