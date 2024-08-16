package java8.consumer;

import java.util.function.Consumer;

public class DemoCustomConsumer {

	public static void main(String[] args) {

		Consumer<String> consumer = (t) ->System.out.println("print" + t);

		consumer.accept("Hello World");

	}
}
