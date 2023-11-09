package org.HW_121023.linked_list_self_made;

public class Main {
    public static void main(String[] args) {
        LinkedList newList =  new LinkedList();
        newList.add("one");
        newList.add("two");
        newList.add("three");
        newList.add("four");
        newList.add("five");

        newList.display();
        System.out.println(newList.getSize());
        System.out.println(newList.getNode(2));

        newList.add("six", 3);
        newList.display();
    }
}
