package hexlet.code.schemas;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class NumberSchema extends BaseSchema<Integer, NumberSchema> {
    private boolean required = false;
    private boolean positiveConstrain = false;
    private boolean rangeConstrain = false;
    private int start;
    private int end;

    public NumberSchema positive() {
        setPositiveConstrain(true);
        return this;
    }

    public NumberSchema range(int startRange, int endRage) {
        setRangeConstrain(true);
        setStart(startRange);
        setEnd(endRage);
        return this;
    }

    public boolean isInRange(int number) {
        return number >= start && number <= end;
    }

    public boolean isPositiveConstrains(Integer num) {
        if (positiveConstrain) {
            if (num == null) {
                return !rangeConstrain;
            } else {
                return num > 0;
            }
        }
        return true;
    }
    @Override
    public boolean isValid(Integer num) {
        var result = true;
        if (isRequired() && num == null) {
            return false;
        }
        if (rangeConstrain && !isInRange(num)) {
            return false;
        }
        if (!isPositiveConstrains(num)) {
            return false;
        }
        return result;
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public void setRequired(boolean required) {
        this.required = required;
    }

}
