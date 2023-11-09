package org.HW_241023.task_2;

public class Main {
    /*
     * Напишите программу Завтрак у бабушки. Бабушка жарит блинчик и кладёт
     * его сверху на стопку. Внук может скушать только верхний блинчик.
     * В цикле смоделируйте, что за одну итерацию бабушка жарит 2 блинчика,
     * а внук съедает только один. Когда внук наелся. Цикл заканчивается.
     * Количество блинов, которые может съесть внук равно его возрасту.
     * */
    public static void main(String[] args) {
        Grandson ivan = new Grandson(12);
        Granny oma = new Granny();

        do {
            oma.cookPancake();
            ivan.eatPancake(oma.getPancakes());
            if (ivan.getPancakeAmount() >= ivan.getAge()){
                System.out.println("Grandson is full! He ate " + ivan.getPancakeAmount() + " pancakes.");
                System.out.println("It remains " + oma.getPancakes().size() + " pancakes.");
                break;
            }

        } while (!oma.getPancakes().isEmpty());
    }
}
