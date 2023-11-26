package org.HW_231123.task_3;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    /*
    * Прочитать значение поля age из файла Example1.json с помощью
    *  JsonPath https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path*/
    public static void main(String[] args) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("Example1.json")));

            List<Integer> ages = JsonPath.read(jsonContent, "$..age");
            System.out.println(ages);

            String city = JsonPath.read(jsonContent, "$.address.city");
            System.out.println(city);

            List<Object> friends = JsonPath.read(jsonContent, "$..friends");
            System.out.println(friends);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
