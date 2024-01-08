package org.HW_211223.task_2.database;

import java.util.Map;
import java.util.TreeMap;

public class RestrictedDataBase {
    Map<Long, String> companyDataBase;

    public RestrictedDataBase() {
        this.companyDataBase = new TreeMap<>();
    }

    public void writeToDataBase(long key, String value){
        companyDataBase.put(key, value);
    }

    public void printAllData(){
        System.out.println(companyDataBase.entrySet());
    }
}
