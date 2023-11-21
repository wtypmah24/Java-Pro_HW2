package org.HW_161123.task_3.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Employee implements Serializable {
    private String firstName;
    private String lastName;
    private String position;
    private LocalDate dateOfBirth;
    private transient Double salary;
    @Serial
    private static final long serialVersionUID = 123L;

    public void serialize(String outPath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outPath))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Для удобства тестирования создал статический метод десериализации.
    public static Employee deserialize(String path){
        Employee employee = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            Object o = ois.readObject();
            if (o instanceof Employee) employee = (Employee) o;
        } catch (ClassNotFoundException | IOException e){
            throw new RuntimeException(e);
        }
        return employee;
    }
}

