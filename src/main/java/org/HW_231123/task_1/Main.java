package org.HW_231123.task_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.HW_231123.task_1.service.message.ServiceMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    /*
    *№ 1 Конвертировать данные из Example2.json в объект. */
    public static void main(String[] args) {
        try {
            String example2Path = Files.readString(Path.of("Example2.json"));
            ObjectMapper om = new ObjectMapper();
            ServiceMessage serviceMessage = om.readValue(example2Path, ServiceMessage.class);
            System.out.println(serviceMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}