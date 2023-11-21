package org.HW_161123.task_3.employee;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void checkIfSalaryNotSerialized() {
        Employee employee1 = new Employee("John",
                "Wick",
                "Football player",
                LocalDate.of(1980, 8, 6),
                100.5);
        employee1.serialize("test1.dat");
        Employee testEmployee = Employee.deserialize("test1.dat");
        assertNull(testEmployee.getSalary());
    }
}