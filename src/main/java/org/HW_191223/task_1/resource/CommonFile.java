package org.HW_191223.task_1.resource;

import java.io.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CommonFile {
    private final File file;
    private final ReentrantReadWriteLock lock;

    public CommonFile(String path) {
        this.file = new File(path);
        this.lock = new ReentrantReadWriteLock();
    }

    public void readLine() {
        lock.readLock().lock();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            Thread.sleep(500);
            if (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeLine(String input){
        lock.writeLock().lock();
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {
            Thread.sleep(100);
            fileWriter.write(input);
            System.out.println("Wrote line: \n" + input);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
        }
    }
}