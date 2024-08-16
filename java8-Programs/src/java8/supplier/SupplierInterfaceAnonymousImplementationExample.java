package java8.supplier;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierInterfaceAnonymousImplementationExample {

	public static void main(String[] args) {
		Supplier<LocalDateTime> supplier = new Supplier<LocalDateTime>() {
			@Override
			public LocalDateTime get() {
				return LocalDateTime.now();
			}
		};
		System.out.println(supplier.get());
	}
}