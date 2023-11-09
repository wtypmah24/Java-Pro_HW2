package org.company;

public class Company {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Engineer engineer = new Engineer();
        Cleaner cleaner = new Cleaner();
        Employee [] employees = {manager, engineer, cleaner};
        int total = 0;
        for(Employee worker : employees){
            total += worker.calulateSalary();
        }
        System.out.println(total);
    }
}