package org.HW_191223.task_1;

import org.HW_191223.task_1.resource.CommonFile;
import org.HW_191223.task_1.user.User;

public class Main {
    /*
    * Разработайте программу, эмулирующую работу нескольких пользователей
    * (потоков) с единым электронным документом. Все пользователи могут
    * добавлять, редактировать и удалять записи (одна запись – одна строка).
    * Каждый новый пользователь получает актуальную копию документа и работает
    * с ней. После внесения изменений пользователь сохраняет изменения.
    * Для оптимизации доступа к документу используйте ReentrantReadWriteLock.
    *
    *
    * Основное различие между ReentrantReadWriteLock и ReentrantLock заключается в том,
    *  что ReentrantReadWriteLock позволяет одновременно нескольким потокам выполнять
    * операции чтения ресурса, в то время как ReentrantLock позволяет одновременно
    * выполнять операции чтения и записи ресурса только одному потоку.*/
    public static void main(String[] args) {
        CommonFile commonFile = new CommonFile("hw191223.txt");
        // Create and start multiple user threads
        Thread user1 = new Thread(new User("User 1", commonFile));
        Thread user2 = new Thread(new User("User 2", commonFile));

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}