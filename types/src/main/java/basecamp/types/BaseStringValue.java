package basecamp.types;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public abstract class BaseStringValue implements StringValue {
    private final String value;

    protected BaseStringValue(String value) {
        this.value = value;
    }

    public boolean isNull() {
        return isBlank(value);
    }

    public String asString() {
        return value;
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
