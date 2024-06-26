package hexlet.code.schemas;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Schema for validating integer values.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
public final class NumberSchema extends BaseSchema<Integer> {

    /**
     * Status of positive numbers constrain.
     */
    private boolean positiveConstrain = false;

    /**
     * Status of range constrain.
     */
    private boolean rangeConstrain = false;

    /**
     * Start range for range constrain.
     */
    private int start;
    /**
     * End range for range constrain.
     */
    private int end;

    /**
     * Marks the number as required.
     *
     * @return the modified NumberSchema
     */
    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    /**
     * Specifies that the number must be positive.
     *
     * @return the modified NumberSchema
     */
    public NumberSchema positive() {
        setPositiveConstrain(true);
        return this;
    }

    /**
     * Specifies a range for the number.
     *
     * @param startRange the start of the range
     * @param endRange   the end of the range
     * @return the modified NumberSchema
     */
    public NumberSchema range(final int startRange, final int endRange) {
        setRangeConstrain(true);
        setStart(startRange);
        setEnd(endRange);
        return this;
    }

    /**
     * Checks if a given number is within the specified range.
     *
     * @param number the number to check
     * @return true if the number is within the range, false otherwise
     */
    public boolean isInRange(final int number) {
        return number >= start && number <= end;
    }

    /**
     * Checks if a given number meets the positive constraints.
     *
     * @param num the number to check
     * @return true if the number meets the positive constraints,
     * false otherwise
     */
    public boolean isPositiveConstrains(final Integer num) {
        if (positiveConstrain) {
            if (num == null) {
                return !rangeConstrain;
            } else {
                return num > 0;
            }
        }
        return true;
    }

    /**
     * Validates a given integer value based on the defined constraints.
     *
     * @param num the integer value to validate
     * @return true if the value is valid, false otherwise
     */
    @Override
    public boolean isValid(final Integer num) {
        if (isRequired() && num == null) {
            return false;
        }
        if (rangeConstrain && !isInRange(num)) {
            return false;
        }
        return isPositiveConstrains(num);
    }


}
