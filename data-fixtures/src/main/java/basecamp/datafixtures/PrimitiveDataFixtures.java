package basecamp.datafixtures;

import java.util.Random;

public class PrimitiveDataFixtures {

	private static Random random = new Random();

	public static String someString(){
      return someStringOfLength(8);
	}

	public static String someStringOfLength(int length){
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < length; i++) {
			sb.append(String.valueOf((char)(random.nextInt(26)+'A')));
		}
		return sb.toString();
	}
}
