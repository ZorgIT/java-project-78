package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    private boolean required = false;

    public abstract boolean isValid(T t);

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
