package org.HW_161123.task_1.reader;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private Reader() {
    }

    public static void writeOutputFile(String inputPath, String outputPath) {
        File[] files = getFiles(inputPath);
        List<String> subtitlesText = readFiles(files);
        List<String> cleanedText = removeTimingAndHeader(subtitlesText);
        writeFile(cleanedText, outputPath);
    }

    private static File[] getFiles(String path) {
        File dir = new File(path);
        return dir.listFiles();
    }

    private static List<String> readFiles(File[] files) {
        List<String> subtitlesText = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".vtt")) {
                    subtitlesText.addAll(readLinesInFiles(file));
                }
            }
        }
        return subtitlesText;
    }

    private static List<String> readLinesInFiles(File file) {
        List<String> linesText = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesText.add(line);
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return linesText;
    }

    private static List<String> removeTimingAndHeader(List<String> subtitlesText) {
        List<String> cleanedText = new ArrayList<>();
        for (String line : subtitlesText) {
            if (line.isEmpty() || line.contains("WEBVTT") || line.startsWith("00")) {
                continue;
            }
            cleanedText.add(line);
        }
        return cleanedText;
    }

    private static void writeFile(List<String> input, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (String line : input) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }
}
