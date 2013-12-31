package basecamp.datafixtures;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

import static basecamp.datafixtures.PrimitiveDataFixtures.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class PrimitiveDataFixturesTest {

    @Test
    public void someStringReturnsAStringWithLengthBetween8And12() throws Exception {
		assertThatLengthIsBetween8And12(someString());
    }

	@Test
    public void someStringShouldReturnJustUpperCaseLetters() throws Exception {
		String someString = someString();
		assertThat(StringUtils.isAlpha(someString),is(true));
        assertThat(StringUtils.isAllUpperCase(someString),is(true));
    }

    @Test
    public void someStringShouldNotRepeatAString() throws Exception {
        String first = someString();
        for (int i = 0; i < 5; i++) {
            String second = someString();
			assertThatLengthIsBetween8And12(second);
            assertThat(second,is(not(first)));
            first = second;
        }
    }

	@Test
	public void someStringOfLengthShouldAlwaysReturnTheRequestedSizeString() throws Exception{
		int length = 15;
		assertThat(someStringOfLength(length).length(),is(length));
	}

	@Ignore
	@Test
	public void someNumberOfLengthShouldReturnANumberWithTheCorrectSize() throws Exception{
		int length = 8;
		Long someNumber = someNumberOfLength(length);
		assertThat(String.valueOf(someNumber).length(),is(length));
	}

	private void assertThatLengthIsBetween8And12(String someString) {
		assertThat(someString.length(),is(greaterThanOrEqualTo(8)));
		assertThat(someString.length(),is(lessThanOrEqualTo(12)));
	}
}
