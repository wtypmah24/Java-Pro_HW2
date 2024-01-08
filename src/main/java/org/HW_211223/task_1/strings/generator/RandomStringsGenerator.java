package org.HW_211223.task_1.strings.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class RandomStringsGenerator {

    public static String[] generateRandomStrings(int arraySize, int maxLength) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            final int length = new Random().nextInt(maxLength) + 1;
            tasks.add(() -> generateRamdomString(length));
        }

        List<Future<String>> futures = executorService.invokeAll(tasks);
        executorService.shutdown();

        String[] resultArray = new String[arraySize];

        for (int i = 0; i < arraySize; i++) {
            try {
                resultArray[i] = futures.get(i).get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return resultArray;
    }
    private static String generateRamdomString(int length){
        StringBuilder stringBuilder = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }


}
