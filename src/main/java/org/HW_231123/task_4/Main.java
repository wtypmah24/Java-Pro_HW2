package org.HW_231123.task_4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "https://ru.wikipedia.org/wiki/Бремен";

            Document doc = Jsoup.connect(url).get();

            int count = 0;
            for (Element element : doc.select("img")) {
                String imageUrl = element.absUrl("src");

                if (!imageUrl.isEmpty()) {
                    downloadImage(imageUrl, "image" + (++count) + ".jpg");

                    if (count == 5) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadImage(String imageUrl, String fileName) {
        try {
            URL url = new URL(imageUrl);

            try (InputStream in = url.openStream()) {
                Path savePath = Path.of("/Users/taras/Desktop", fileName);

                Files.copy(in, savePath);
                System.out.println("Изображение " + fileName + " успешно скачано.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}