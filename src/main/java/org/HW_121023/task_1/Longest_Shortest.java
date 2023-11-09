package org.HW_121023.task_1;



import java.util.List;

//С неймингом классов, методов и переменных мне стоит ещё потренироваться.
public class Longest_Shortest {
    public static String getLongestString(List<String> strings) {
        int max = strings.get(0).length();
        String longStr = "";
        for (String s : strings) {
            if (s.length() > max) {
                longStr = s;
            }
        }
        return longStr;
    }

    public static String getShortestString(List<String> strings) {
        int min = strings.get(0).length();
        String shortString = "";
        for (String s : strings) {
            if (s.length() < min) {
                shortString = s;
            }
        }
        return shortString;
    }
}
