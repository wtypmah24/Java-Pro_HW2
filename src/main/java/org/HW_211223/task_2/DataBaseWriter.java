package org.HW_211223.task_2;

import org.HW_211223.task_2.database.RestrictedDataBase;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class DataBaseWriter {
    /*
     * В компании есть база данных, и несколько потоков пытаются
     * одновременно записать данные в эту базу. Чтобы избежать
     * коллизий при одновременной записи, используйте Semaphore,
     * чтобы ограничить доступ к базе одновременно только нескольким потокам.*/
    private static final Semaphore SEMAPHORE = new Semaphore(1);

    public static void main(String[] args) {
        RestrictedDataBase dataBase = new RestrictedDataBase();

        List<Thread> threads = Arrays.stream(new int[5])
                .mapToObj(e -> new Thread(() -> {
                    try {
                        SEMAPHORE.acquire();
                        System.out.println(Thread.currentThread().getId() + " received access to file");
                        dataBase.writeToDataBase(Thread.currentThread().getId(), LocalDateTime.now().toString());
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        SEMAPHORE.release();
                        System.out.println(Thread.currentThread().getId() + " finish work");
                    }
                }))
                .peek(Thread::start).toList();

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        dataBase.printAllData();
    }
}
