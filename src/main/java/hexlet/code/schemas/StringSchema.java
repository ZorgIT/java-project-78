package hexlet.code.schemas;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder(setterPrefix = "with")

public class StringSchema extends BaseSchema<String, StringSchema> {
    private String containString = "";
    private int minLength = 0;
    private boolean required = false;

    public StringSchema minLength(int newMinLength) {
        setMinLength(newMinLength);
        return this;
    }

    public StringSchema contains(String line) {
        setContainString(line);
        return this;
    }

    @Override
    public boolean isValid(String line) {
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
    public boolean isRequired() {
        return this.required;
    }

    @Override
    public String toString() {
        return "StringSchema{"
                + "line='" + containString + '\''
                + ", minLength=" + minLength + '}';
    }

}
