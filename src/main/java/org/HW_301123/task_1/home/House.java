package org.HW_301123.task_1.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.HW_301123.task_1.appartment.Apartment;
import org.HW_301123.task_1.room.Room;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {
    List<Apartment> apartments;
    public House(int apartmentQuantity, int roomQuantity, double roomArea) {
        this.apartments = new ArrayList<>();
        for (int i = 0; i < apartmentQuantity; i++) {
            List<Room> rooms = new ArrayList<>();
            for (int j = 0; j < roomQuantity; j++) {
                rooms.add(new Room(roomArea));
            }
            apartments.add(new Apartment(rooms));
        }
    }
}
