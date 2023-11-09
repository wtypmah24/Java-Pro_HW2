package org.HW_121023.linked_list_self_made;

public class LinkedList {

    //Класс реализующий связанный список содержит в полях только ссылку на первый узел.
    // И два метода: добавление узла и вывод информации,
    LinkedListNode firstNode;
    private int size;

    //При создании объекта ссылке на первый узел присваивается null.
    public LinkedList() {
        this.firstNode = null;
        size = 0;
    }

    public void add(String data) {
        //При вызове создаётся новый узел с переданной информацией.
        LinkedListNode newNode = new LinkedListNode(data);
        //Если это список пустой то в данном связнном листе он будет первым.
        if (firstNode == null) {
            firstNode = newNode;
            size++;
            return;
        }
        //если нет то новый узел уходит в конец
        LinkedListNode current = firstNode;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        current.nextNode = newNode;
        size++;
    }
    //Добавление по индексу.
    public void add(String data, int index) {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid index: " + index);

        LinkedListNode newNode = new LinkedListNode(data);
        // если индекс нового узла 0, то ссылка на следующий узел для нового узла становится предыдущий первый узел.
        // а новый узел становится первым в листе.
        if (index == 0) {
            newNode.nextNode = firstNode;
            firstNode = newNode;
        }

        //Проходимся временной переменной по циклу до элемента, который предшествует необходимой позции.
        else {
            LinkedListNode current = firstNode;
            for (int i = 0; i < index - 1; i++) {
                current = current.nextNode;
            }
            //затем устанавливаем ссылку на следующий элемент нового узла на элемент, который ранее был под искомым индексом.
            newNode.nextNode = current.nextNode;
            // а ссылку на следуюзий узел для узла на позиции индекс -1 на новый узел.
            current.nextNode = newNode;
        }
       size++;
    }
    public void display() {
        LinkedListNode current = firstNode;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.nextNode;
        }
        System.out.println("null");
    }
    public int getSize(){
        return size;
    }
    public String getNode (int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        LinkedListNode current = firstNode;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        return current.data;
    }
}
