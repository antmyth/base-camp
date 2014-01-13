package basecamp.types;

import org.junit.Before;
import org.junit.Test;

import static basecamp.datafixtures.PrimitiveDataFixtures.someString;
import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.assertThat;

public class BaseStringValueTest {

    private String value;

    @Before
    public void setUp() throws Exception {
        value = someString();
    }

    @Test
    public void stringValuesAreEqualIfInternalValueIsEqual() throws Exception {
        assertThat(new TestBaseStringValue(value), is(new TestBaseStringValue(value)));
    }

    @Test
    public void hashIsTheSameIfInternalValueIsEqual() throws Exception {
        assertThat((new TestBaseStringValue(value)).hashCode(), is((new TestBaseStringValue(value)).hashCode()));
    }

    @Test
    public void stringValueIsNotNullWhenCreatedWithNullValue() throws Exception {
        assertThat(new TestBaseStringValue(null), is(notNullValue()));
    }

    @Test
    public void isNullReturnsTrueIfStringValueCreatedWithNullOrBlank() throws Exception {
        TestBaseStringValue stringValue = new TestBaseStringValue(null);
        assertThat(stringValue.isNull(), is(true));
        stringValue = new TestBaseStringValue("");
        assertThat(stringValue.isNull(), is(true));
    }

    @Test
    public void isNullReturnsFalseIfStringValueCreatedWithNonBlankString() throws Exception {
        TestBaseStringValue stringValue = new TestBaseStringValue(someString());
        assertThat(stringValue.isNull(), is(false));
    }

    @Test
    public void asStringReturnsTheValue() throws Exception {
        String value = someString();
        assertThat((new TestBaseStringValue(value)).asString(), is(value));
    }

    @Test
    public void toStringFormatsTheValueAndClassName() throws Exception {
        String value = someString();
        String expected = format("BaseStringValueTest.TestBaseStringValue[value=%s]", value);
        assertThat((new TestBaseStringValue(value)).toString(),
                endsWith(expected));
    }

    private class TestBaseStringValue extends BaseStringValue {

        protected TestBaseStringValue(String value) {
            super(value);
        }
    }
}
