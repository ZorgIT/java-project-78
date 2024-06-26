package hexlet.code.schemas;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Schema for validating maps.
 *
 * @param <T> the type of values in the map
 */
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unchecked")
public final class MapSchema<T> extends BaseSchema<Map<String, String>> {
    /**
     * Limit size of maps schema.
     * <p>
     * default value less 1 is for no limit;
     */
    private int sizeof = -1;

    /**
     * Map that defines the schema for each key in the map.
     */
    private Map<String, ? extends BaseSchema<T>> schemaMap;

    /**
     * Sets the size limit for the map.
     *
     * @param sizeConstrain the size limit to set
     * @return the current MapSchema instance
     */
    public MapSchema<T> sizeof(final int sizeConstrain) {
        setSizeof(sizeConstrain);
        return this;
    }

    /**
     * Sets the schema as required.
     *
     * @return the current MapSchema instance
     */
    public MapSchema<T> required() {
        setRequired(true);
        return this;
    }

    /**
     * Checks if the provided map is valid based on the defined schema.
     *
     * @param checkedMap the map to validate
     * @return true if the map is valid, false otherwise
     */
    @Override
    public boolean isValid(final Map<String, String> checkedMap) {
        if (isRequired() && checkedMap == null) {
            return false;
        }

        if (sizeof > 0 && checkedMap.size() != sizeof) {
            return false;
        }

        AtomicBoolean result = new AtomicBoolean(true);
        if ((schemaMap != null)) {
            checkedMap.forEach((key, value) -> {
                if (!schemaMap.get(key).isValid((T) value)) {
                    result.set(false);
                }
            });
        }

        return result.get();
    }

    /**
     * Sets the schema shape.
     *
     * @param schemas the schema map representing the shape
     */
    public void shape(final Map<String, ? extends BaseSchema<T>> schemas) {
        this.schemaMap = schemas;
    }

    private void setSizeof(final int sizeLimit) {
        this.sizeof = sizeLimit;
    }
}
