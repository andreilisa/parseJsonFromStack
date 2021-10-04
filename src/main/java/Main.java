import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Main {
     final static String NAME = "name";
    public static void main(String[] args) throws IOException {

        String jsonStr = "C:\\Users\\andrei.lisa\\IdeaProjects\\JsonParser\\src\\main\\resources\\json\\file2.json";
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(new FileReader(jsonStr));
            parseJsonElement(jsonElement);

    }

    public static void parseJsonElement(JsonElement jsonElement) {
        if (jsonElement.isJsonArray()) {
            parseJsonArray(jsonElement.getAsJsonArray());
        } else if (jsonElement.isJsonObject()) {
            parseJsonObject(jsonElement.getAsJsonObject());
        }
    }

    public static void parseJsonArray(JsonArray array) {
        for (JsonElement value : array) {
            parseJsonElement(value);
        }
    }

    public static void parseJsonObject(JsonObject object) {
        Set<Map.Entry<String, JsonElement>> members = object.entrySet();
        for (Map.Entry<String, JsonElement> value : members) {
            if (value.getKey().equals(NAME))
            System.out.println(value.getKey() + ": " + value.getValue());
            parseJsonElement(value.getValue());
        }
    }
}







