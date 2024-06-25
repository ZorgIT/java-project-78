package hexlet.code.schemas;

public abstract class BaseSchema<T, V> {
    private boolean required = false;

    public BaseSchema<T, V> required() {
        setRequired(true);
        return this;
    }

    public abstract boolean isValid(T t);

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
