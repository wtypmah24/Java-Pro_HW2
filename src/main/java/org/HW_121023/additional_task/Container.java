package org.HW_121023.additional_task;




import java.util.LinkedList;
import java.util.List;

public class Container {
    /* 1 Создайте класс Контейнер, который имеет внутренние габариты и максимальную
массу хранимого груза, а также хранит набор грузов (HeavyBox). Пусть все грузы имеют
одинаковый размер и массу. Создайте метод в классе Контейнер, который будет
принимать груз до тех пор, пока внутренне пространство контейнера не будет заполнено
или не будет достигнута максимальная масса груза, допустимого для контейнера.
2 В main создайте несколько контейнеров разного размера. Затем создавайте грузы и
заполняйте контейнеры, пока все контейнеры не будут максимально загружены.
3 Выведите в консоль, сколько грузов с какими идентификаторами были загружены в
какой каждый контейнер*/

    private final double containerVolume;
    private final double maxLoad;
    private double remainedVolume;
    private double remainedLoad;
    private final List<HeavyBox> boxes;

    public Container(double containerVolume, double maxLoad) {
        this.containerVolume = containerVolume;
        this.maxLoad = maxLoad;
        boxes = new LinkedList<>();
        remainedLoad = maxLoad;
        remainedVolume = containerVolume;
    }

    public void addCargo (HeavyBox box){
        if(canAdd(box)){
            boxes.add(box);
            System.out.println("Box with id " + box.getId() + " and weight " + box.getWeight() + " loaded");
        }
        else {
            System.out.println("You have reached max capacity");
        }

    }
    private boolean canAdd(HeavyBox box) {
        double boxVolume = box.getBoxVolume();
        double boxWeight = box.getWeight();

        if (remainedVolume >= boxVolume || remainedLoad >= boxWeight) {
            remainedVolume -= boxVolume;
            remainedLoad -= boxWeight;
            return true;
        }

        return false;
    }

    public void printInfo (){
        System.out.println("Container info: Volume is " + containerVolume +
                "max load is " + maxLoad +
                "it was loaded " + boxes.size() + " boxes with id: ");

        for(HeavyBox box : boxes){
            System.out.print(box.getId() + ", ");
        }

        System.out.println("with total weight: " + (getTotalWeight()));
    }


    private  double getTotalWeight(){
        double totalWeight = 0;
        for(HeavyBox box : boxes){
            totalWeight += box.getWeight();
        }
        return totalWeight;
    }
}
