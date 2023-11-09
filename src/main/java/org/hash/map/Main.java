package org.hash.map;


import org.hash.map.hashmap.HashMapSelfMade;

public class Main {
    public static void main(String[] args) {
        HashMapSelfMade<Integer, String> map1 = new HashMapSelfMade<>();
        map1.put(2, "Hello");
        map1.put(4, "Moin");
        map1.put(1, "Servus");
        map1.put(7, "Grus Gott");
        map1.put(5, "Tschuss");
        map1.put(111188, "Nihau");
        map1.put(36, "Was?!");

        //System.out.println(map1);

        System.out.println(map1.get(4));
    }
}
