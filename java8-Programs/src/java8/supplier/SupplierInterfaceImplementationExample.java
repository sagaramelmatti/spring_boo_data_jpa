package java8.supplier;

import java.time.LocalDateTime;
import java.util.function.Supplier;

class CustomSupplerInterface implements Supplier<LocalDateTime> {

	@Override
	public LocalDateTime get() {
		return LocalDateTime.now();
	}
}

public class SupplierInterfaceImplementationExample {
	
	public static void main(String[] args) {
		
		CustomSupplerInterface customSupplerInterface = new CustomSupplerInterface();
		System.out.println(customSupplerInterface.get());
	}
}