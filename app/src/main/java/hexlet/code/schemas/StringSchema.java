package hexlet.code.schemas;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Schema for validating String values.
 */
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder(setterPrefix = "with")

public final class StringSchema extends BaseSchema<String> {
    private String containString = "";
    private int minLength = 0;
    private boolean required = false;

    /**
     * Sets the minimum length for the string.
     *
     * @param newMinLength the minimum length for the string
     * @return the StringSchema object
     */
    public StringSchema minLength(final int newMinLength) {
        setMinLength(newMinLength);
        return this;
    }

    /**
     * Sets the string that the input string must contain.
     *
     * @param line the string that the input string must contain
     * @return the StringSchema object
     */
    public StringSchema contains(final String line) {
        setContainString(line);
        return this;
    }

    /**
     * Sets the input string as required.
     *
     * @return the StringSchema object
     */
    public StringSchema required() {
        setRequired(true);
        return this;
    }

    /**
     * Validates the input string based on the schema.
     *
     * @param line the input string to be validated
     * @return true if the input string is valid according to the schema,
     * false otherwise
     */
    @Override
    public boolean isValid(final String line) {
        //var result = true;
        if (required) {
            if (!(line == null)) {
                if (line.isEmpty()) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (minLength > 0 && line.length() < minLength) {
            return false;
        }

        if (line != null && !line.contains(containString)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "StringSchema{"
                + "line='" + containString + '\''
                + ", minLength=" + minLength + '}';
    }


}
