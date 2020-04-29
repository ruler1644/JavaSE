package chaptor15_exam.Exam4;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//1个线程写，100个线程读取
public class Code05_readwritelock {
    public static void main(String[] args) {

        final MyQueue myQueue = new MyQueue();

        //写线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                myQueue.set(new Random().nextInt(30));
            }
        }, "A").start();

        //读线程
        for (int i = 1; i <= 100; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    myQueue.get();
                }
            }, String.valueOf(i)).start();
        }
    }


}

class MyQueue {
    private Object obj;
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    //写线程调用的方法
    public void set(Object obj) {

        reentrantReadWriteLock.writeLock().lock();

        try {
            this.obj = obj;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "线程写" + obj);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    //读线程调用的方法
    public void get() {

        reentrantReadWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "线程读" + obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}