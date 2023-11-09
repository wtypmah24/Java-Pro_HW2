package org.HW_241023.task_1;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Club {

    //LinkedList работает по принципе FIFO.
    private final LinkedList<Visitor> visitorQueue;

    //В клубе не имеет значения порядок, это просто множество уникальных людей.
    private final Set<Visitor> partyingVisitors;

    public Club() {
        this.visitorQueue = new LinkedList<>();
        this.partyingVisitors = new HashSet<>();
    }
    //Организовывем очередь. Встать в очередь может и несовершеннолетний.
    public void addToQueue(Visitor visitor){
        visitorQueue.offer(visitor);
        System.out.println(visitor.getName() + " stays in queue");
    }

    //Работает "Вышибала" пропускает в клуб только совершеннолетних.
    public void allowToComeIn(){
        while (!visitorQueue.isEmpty()){
            Visitor visitor = visitorQueue.poll();
            if (visitor.getAge() >= 21){
                System.out.println(visitor.getName() + " is allowed to come in!");
                partyingVisitors.add(visitor);
            }
            else{
                System.out.println(visitor.getName() + " is not allowed to come in his age is " + visitor.getAge());
            }
        }
    }
}