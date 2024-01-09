package org.HW_090124.task_2.custom.serializer;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CustomSerializer {
    public static void writeObjectToJsonFile(Object object, String path){
        try (FileWriter writer = new FileWriter(path)) {
            String json = convertObjectToJson(object);
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException("Error writing object to JSON file", e);
        }
    }

    private static Map<String, String> getAllFieldNamesAndValues(Object object){

        Map<String, String> fieldToValue = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);
            try {
                fieldToValue.put(field.getName(), field.get(object).toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return fieldToValue;
    }

    //TODO: Implement the case where there are arrays or list.
    private static String convertObjectToJson(Object object) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        Map<String, String> fieldToValue = CustomSerializer.getAllFieldNamesAndValues(object);

        for (Map.Entry<String, String> entry : fieldToValue.entrySet()) {
            jsonBuilder.append("  \"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\",\n");
        }

        // Удаляем последнюю запятую и добавляем закрывающую фигурную скобку
        if (!fieldToValue.isEmpty()) {
            jsonBuilder.delete(jsonBuilder.length() - 2, jsonBuilder.length());
        }

        jsonBuilder.append("\n}");

        return jsonBuilder.toString();
    }
}
