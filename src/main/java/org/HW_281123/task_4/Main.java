package org.HW_281123.task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    /*
     * Создайте предикат для удаления из списка тех строк,
     * что начинаются с определённой буквы. Создайте список строк и
     * удалите элементы с помощью метода removeIf, передав в него предикат.*/
    public static void main(String[] args) {
        List<String> toBeCleaned = List.of("aaafvgbgf", "bvdfgbhn", "fsa", "a", "agbfdgbgfd");
        String target = "a";

        System.out.println(removeIf(toBeCleaned, s -> s.startsWith(target)));
    }

    private static List<String> removeIf(List<String> input, Predicate<String> predicate) {
        List<String> cleanedList = new ArrayList<>();
        input.forEach(s -> {
            if (!predicate.test(s)) cleanedList.add(s);
        });
        return cleanedList;
    }
}