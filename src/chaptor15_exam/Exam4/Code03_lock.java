package chaptor15_exam.Exam4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//lock锁方式实现，解决线程的虚假唤醒问题
public class Code03_lock {
    public static void main(String[] args) {

        final NumberThread3 NumberThread3 = new NumberThread3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(130);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    NumberThread3.add();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    NumberThread3.reduce();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(430);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    NumberThread3.add();
                }
            }
        }, "C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    NumberThread3.reduce();
                }
            }
        }, "D").start();

    }
}

class NumberThread3 {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            while (num != 0) {

                //wait();
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "---->" + num);
            //notifyAll();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void reduce() {
        lock.lock();
        try {
            while (num == 0) {
                //wait();
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "---->" + num);
            //notifyAll();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}