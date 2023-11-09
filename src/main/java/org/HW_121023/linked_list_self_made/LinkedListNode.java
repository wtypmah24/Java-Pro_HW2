package org.HW_121023.linked_list_self_made;

public class LinkedListNode {

    //Узел содержит ссылку на следующий узел и саму ифнормацию для хранения.
    String data;
    LinkedListNode nextNode;

    //Конструктор получает информацию, а ссылку на следующий узел инициализирует null
    public LinkedListNode(String data) {
        this.data = data;
        this.nextNode = null;
    }
}
