package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

/**
 * Validator class for creating schema objects.
 */
public class Validator {

    /**
     * Creates a new StringSchema object.
     *
     * @return a new StringSchema object
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Creates a new NumberSchema object.
     *
     * @return a new NumberSchema object
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Creates a new MapSchema object.
     *
     * @return a new MapSchema object
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
