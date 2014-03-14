package basecamp.datafixtures;

import java.util.Collection;
import java.util.Random;

public class PrimitiveDataFixtures {

	private static Random random = new Random();

	public static String someString() {
		return someStringOfLength(random.nextInt(4) + 8);
	}

	public static String someStringOfLength(int length) {
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < length; i++) {
			sb.append(String.valueOf((char) (random.nextInt(26) + 'A')));
		}
		return sb.toString();
	}

	public static Long someNumberOfLength(int length) {
		if (length == 0) return 0L;
		if (length > 1) {
			double lowestValue = Math.pow(10, length - 1);
			double adder = Math.pow(10, length) - 1 - lowestValue;
			return (long) (lowestValue + random.nextInt((int) adder));
		}
		else {
			return (long) random.nextInt(9);
		}
	}

	public static Long someNumber() {
		return someNumberOfLength(5);
	}

	public static Integer someInteger(){
		return someNumberOfLength(5).intValue();
	}

	public static Integer someIntegerOfLength(int length){
		return someNumberOfLength(length).intValue();
	}

	public static <T> T pickOneOf(T... options){
		return options[random.nextInt(options.length)];
	}

	@SuppressWarnings("unchecked")
	public static <T> T pickOneOf(Collection<T> choices) {
		return (T) pickOneOf(choices.toArray());
	}

	public static <E extends Enum> E pickOneOf(Class<E> choices) {
		return pickOneOf(choices.getEnumConstants());
	}
}
