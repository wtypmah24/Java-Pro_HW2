package org.HW_161123.task_1;

import org.HW_161123.task_1.reader.Reader;

public class Main {
    /*
    * Есть архив VttFiles.zip (см. в группе дискорд) с набором vtt-файлов
    * (субтитры к аудиодорожкам). Из субтитров нужно собрать единый файл txt
    * для последующего создания документа со скриптами аудиодорожек.
    * В txt поместите только тексты из субтитров. Все лишние записи (время, WEBVTT) должны быть удалены.*/
    public static void main(String[] args) {
        String inputPath = "/Users/taras/Documents/Java theory/VttFiles";
        String outPath = "/Users/taras/Documents/Java theory/output.txt";
        Reader.writeOutputFile(inputPath, outPath);
    }
}
