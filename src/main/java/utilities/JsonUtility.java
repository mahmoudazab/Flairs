package utilities;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonUtility {
    private static final String DATA_PATH = System.getProperty("user.dir") + "/src/main/java/data/";

    /**
     * 1- key that will retrieve the value of it
     * 2- second variable for the file name
     */
    public static String jsonReader(String obj, String fileName) {
        File srcFile = new File(DATA_PATH + fileName);
        JSONParser parser = new JSONParser();
        String value = null;

        try (FileInputStream fileInputStream = new FileInputStream(srcFile);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }

            JSONArray jArray = (JSONArray) parser.parse(jsonStringBuilder.toString());
            for (Object jsonObj : jArray) {
                JSONObject person = (JSONObject) jsonObj;
                value = (String) person.get(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void updateJsonField(String fieldName, String newValue, String fileName) {
        File inputFile = new File(DATA_PATH + fileName);

        try (FileReader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            // Parse the JSON content using JSONParser
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(bufferedReader);

            // Update the specified field
            for (Object obj : jsonArray) {
                if (obj instanceof JSONObject) {
                    JSONObject jsonObject = (JSONObject) obj;
                    if (jsonObject.containsKey(fieldName)) {
                        jsonObject.put(fieldName, newValue);
                    }
                }
            }

            // Convert the updated JSONArray to JSON String
            String updatedJsonString = jsonArray.toJSONString();

            // Write the updated JSON String back to the same file
            try (FileWriter fileWriter = new FileWriter(inputFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(updatedJsonString);
            }

            System.err.println("Field updated successfully.");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}