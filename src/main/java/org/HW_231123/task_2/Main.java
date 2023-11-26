package org.HW_231123.task_2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.HW_231123.task_2.bike.Bike;

import java.io.File;
import java.io.IOException;

public class Main {
    /*
    * Создать объект с 3-4 полями разных типов (в т.ч. ссылочных) и записать объект в файл в виде Json.*/
    public static void main(String[] args) {
        Bike bike = new Bike(Bike.Handlebar.HandlebarType.RISER,
                Bike.Saddle.SaddleType.RACE,
                Bike.Wheel.WheelType.MOUNTAIN,
                Bike.Gears.GearsType.MULTI,
                Bike.Frame.FrameType.MALE);
        ObjectMapper om = new ObjectMapper();

        try {
            om.writeValue(new File("bike.json"), bike);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
