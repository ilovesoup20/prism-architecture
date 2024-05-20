package _2024_05_19_05_input_output;

import java.util.HashMap;
import java.util.Map;

public class GenericContext implements BaseContext {
    private final Map<String, Object> data = new HashMap<>();

    public <T> T getData(String key) {
        return (T) data.get(key);
    }

    public <T> void setData(String key, T value) {
        data.put(key, value);
    }
}
