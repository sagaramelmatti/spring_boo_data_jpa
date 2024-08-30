package java8.sreams.arrays;

import java.util.Arrays;

public class ArrayStreamDemo {

	public static void main(String[] args) {
		
		String[] array = { "java", "cpp", "c", "python" }; 
		
		Arrays.stream(array).forEach(arr -> System.out.println(arr));
		
		
		

	}

}
