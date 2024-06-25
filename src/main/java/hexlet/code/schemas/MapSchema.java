package hexlet.code.schemas;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
@NoArgsConstructor
public class MapSchema<T> extends BaseSchema<Map<String, String>> {
    private int sizeof = -1;
    private Map<String, ? extends BaseSchema<T>> schemaMap;

    public MapSchema sizeof(int sizeConstrain) {
        setSizeof(sizeConstrain);
        return this;
    }

    public MapSchema required() {
        setRequired(true);
        return this;
    }


    @Override
    public boolean isValid(Map<String, String> checkedMap) {
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

    public void shape(Map<String, ? extends BaseSchema<T>> schemas) {
        this.schemaMap = schemas;
    }

    private void setSizeof(int sizeof) {
        this.sizeof = sizeof;
    }
}
