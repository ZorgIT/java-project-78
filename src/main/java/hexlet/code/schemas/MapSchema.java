package hexlet.code.schemas;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class MapSchema extends BaseSchema<Map<String, String>, MapSchema> {
    private int sizeof = -1;

    public MapSchema sizeof(int sizeConstrain) {
        setSizeof(sizeConstrain);
        return this;
    }

    @Override
    public boolean isValid(Map<String, String> stringStringMap) {
        if (isRequired() && stringStringMap == null) {
            return false;
        }

        if (sizeof > 0 && stringStringMap.size() != sizeof) {
            return false;
        }

        return true;
    }

    private void setSizeof(int sizeof) {
        this.sizeof = sizeof;
    }
}
