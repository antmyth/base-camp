package basecamp.datafixtures;

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
			return Long.valueOf(random.nextInt(9));
		}
	}

	public static Long someNumber() {
		return someNumberOfLength(5);
	}
}
