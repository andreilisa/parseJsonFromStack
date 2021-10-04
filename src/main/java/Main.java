import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String jsonStr = "C:\\Users\\andrei.lisa\\IdeaProjects\\JsonParser\\src\\main\\resources\\json\\file.json";
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(new FileReader(jsonStr));
        processJsonElement(jsonElement);
    }


    public static void processJsonElement(JsonElement e) {
        if (e.isJsonArray()) {
            processJsonArray(e.getAsJsonArray());
        } else if (e.isJsonObject()) {
            processJsonObject(e.getAsJsonObject());
        }
    }

    public static void processJsonArray(JsonArray array) {
        for (JsonElement value : array) {
            processJsonElement(value);
        }
    }


    public static void processJsonObject(JsonObject object) {
        Set<Map.Entry<String, JsonElement>> members = object.entrySet();
        for (Map.Entry<String, JsonElement> value : members) {
            System.out.println(value.getKey() + ": " + value.getValue());

            processJsonElement(value.getValue());
        }
    }
}




