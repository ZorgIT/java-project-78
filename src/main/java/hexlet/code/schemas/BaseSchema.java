package hexlet.code.schemas;

public abstract class BaseSchema<T, V> {

    public BaseSchema<T, V> required() {
        setRequired(true);
        return this;
    }

    abstract boolean isValid(T t);

    abstract void setRequired(boolean b);

    abstract boolean isRequired();
}
