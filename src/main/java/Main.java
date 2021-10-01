




import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.util.*;

public class Main {
    public static void findAllKeys(Object object, Set<String> finalKeys) {
          
        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;

            jsonObject.keySet().forEach(chillKey -> {
                System.out.println( chillKey + ":" + jsonObject.get(chillKey));
                finalKeys.add(chillKey);
                findAllKeys(jsonObject.get(chillKey), finalKeys);

            });
        } else if (object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;

            for (int i = 0; i < jsonArray.length(); i++) {
                Object o = jsonArray.get(i);
                findAllKeys(o, finalKeys);
            }
        }


    }
    public List<Object> readJsonStream(InputStream in) throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        List<Object> messages = new ArrayList<Object>();
        reader.beginArray();
        while (reader.hasNext()) {
            Object message = gson.fromJson(reader, Object.class);
            messages.add(message);
        }
        reader.endArray();
        reader.close();
        return messages;
    }

    public static void main(String[] args) throws JSONException, IOException {

        String inputJson = "{\n" +
                "  \"company\": {\n" +
                "    \"employee\": {\n" +
                "      \"person\": [\n" +
                "        {\n" +
                "          \"name\": \"Jack\",\n" +
                "          \"secondName\": \"ADA\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Max\",\n" +
                "          \"secondName\": \"ADA\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"address\": \"address\",\n" +
                "    \"phone\": \"number\"\n" +
                "  }\n" +
                "}\n" +
                "  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";

        JSONObject jsonObject = new JSONObject(inputJson);
        Set<String> finalKeys = new HashSet<>();
        findAllKeys(jsonObject, finalKeys);
        for (int i = 0; i < jsonObject.length(); i++){

        }
        Main main = new Main();
        List<Object> list =  main.readJsonStream(new FileInputStream("C:\\Users\\andrei.lisa\\IdeaProjects\\JsonParser\\src\\main\\resources\\json\\file.json"));
         for (int i =0; i < list.size(); i ++){

         }


    }



}