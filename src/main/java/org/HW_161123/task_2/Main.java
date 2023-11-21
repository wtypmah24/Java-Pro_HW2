package org.HW_161123.task_2;

import org.HW_161123.task_2.visitor.CustomFileVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    /*
    * Files обладает способом обхода дерева каталогов.
    * Более подробно можно об этом почитать в статье https://habr.com/ru/articles/437694/
    Создайте программу, которая будет принимать путь к существующей
    * папке на Вашем компьютере. После этого программа должна вывести
    * имена файлов и папок на каждом уровне, начиная с текущей папки
    * до корня дерева (диска C или другого диска).*/

    public static void getAllContainRecursion(String path){
        File folder = new File(path);
        File[] contains = folder.listFiles();
        if (contains != null){
            System.out.println(Arrays.toString(contains));
            for (File file : contains){
                if (file.isDirectory()){
                    getAllContainRecursion(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        String path = "/Users/taras/Documents";
        getAllContainRecursion(path);

        Path startPath = Path.of(path);
        try {
            Files.walkFileTree(startPath, new CustomFileVisitor());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
