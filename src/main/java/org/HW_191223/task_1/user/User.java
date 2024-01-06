package org.HW_191223.task_1.user;

import org.HW_191223.task_1.resource.CommonFile;

import java.time.LocalDateTime;
import java.util.Random;

public class User implements Runnable{
    private final String name;
    private final CommonFile commonFile;

    public User(String name, CommonFile commonFile) {
        this.name = name;
        this.commonFile = commonFile;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Perform random action: 0 - read, 1 - write
            int action = random.nextInt(2);
            if (action == 0) {
                System.out.println(name + " is reading:");
                commonFile.readLine();
            } else {
                String line = name + " wrote something at time " + LocalDateTime.now();
                System.out.println(name + " is writing:");
                commonFile.writeLine(line);
            }
        }
    }
}
