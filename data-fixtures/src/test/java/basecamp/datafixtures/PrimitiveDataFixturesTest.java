package basecamp.datafixtures;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static basecamp.datafixtures.PrimitiveDataFixtures.someString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class PrimitiveDataFixturesTest {

    @Test
    public void someStringReturnsAStringOfLength8() throws Exception {
        assertThat(someString().length(),is(8));
    }

    @Test
    public void someStringShouldReturnJustUpperCaseLetters() throws Exception {
        assertThat(StringUtils.isAlpha(someString()),is(true));
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
}
