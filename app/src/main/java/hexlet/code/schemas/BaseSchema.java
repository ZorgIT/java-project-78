package hexlet.code.schemas;

/**
 * Base class for schemas.
 *
 * @param <T> the type parameter
 */
public abstract class BaseSchema<T> {
    /**
     * required status definition.
     */
    private boolean required = false;

    /**
     * Checks if the provided value is valid.
     *
     * @param t the value to validate
     * @return true if the value is valid, false otherwise
     */

    public abstract boolean isValid(T t);

    /**
     * Gets a value indicating whether this schema is required.
     *
     * @return true if this schema is required, false otherwise
     */
    public boolean isRequired() {
        return this.required;
    }

    /**
     * Sets whether this schema is required.
     *
     * @param newRequired true if this schema should be required,
     *                    false otherwise
     */
    public void setRequired(final boolean newRequired) {
        this.required = newRequired;
    }
}
