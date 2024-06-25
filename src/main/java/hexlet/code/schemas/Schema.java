package hexlet.code.schemas;

public interface Schema<T, V> {

    default Schema<T, V> required() {
        setRequired(true);
        return this;
    }

    boolean isValid(T t);

    void setRequired(boolean b);
    boolean isRequired();
}
