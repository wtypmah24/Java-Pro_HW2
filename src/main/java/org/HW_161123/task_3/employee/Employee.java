package org.HW_161123.task_3.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Employee implements Serializable {
    private String firstName;
    private String lastName;
    private String position;
    private LocalDate dateOfBirth;
    private transient double salary;
    @Serial
    private static final long serialVersionUID = 123L;
}

