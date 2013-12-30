package basecamp.datafixtures;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static basecamp.datafixtures.PrimitiveDataFixtures.someString;
import static basecamp.datafixtures.PrimitiveDataFixtures.someStringOfLength;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class PrimitiveDataFixturesTest {

    @Test
    public void someStringReturnsAStringWithLengthBetween8And12() throws Exception {
        assertThat(someString().length(),is(greaterThanOrEqualTo(8)));
        assertThat(someString().length(),is(lessThanOrEqualTo(12)));
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
            assertThat(second,is(not(first)));
            first = second;
        }
    }
	
	@Test
	public void someStringOfLengthShouldAlwaysReturnTheRequestedSizeString() throws Exception{
		int length = 15;
		assertThat(someStringOfLength(length).length(),is(length));
	}
}
