package org.HW_301123.task_1.appartment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.HW_301123.task_1.room.Room;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class Apartment {
    List<Room> rooms;
}
