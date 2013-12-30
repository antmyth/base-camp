package basecamp.datafixtures;

import java.util.Random;

public class PrimitiveDataFixtures {

	private static Random random = new Random();

	public static String someString(){
        StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			sb.append(String.valueOf((char)(random.nextInt(26)+'A')));
		}
		return sb.toString();
	}

	public static String someStringOfLength(int length){
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
