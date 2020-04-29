package chaptor06_thread.chap01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//继承Thread类的方式，模拟卖票。同步锁，解决线程安全问题
public class Code_04_ThreadWindow03 {
    public static void main(String[] args) {
        TicketWindow03 w1 = new TicketWindow03();
        TicketWindow03 w2 = new TicketWindow03();
        TicketWindow03 w3 = new TicketWindow03();

        w1.start();
        w2.start();
        w3.start();
    }
}

class TicketWindow03 extends Thread {

    //创建三个线程类对象,要实现多个对象共享ticket资源,必须将ticket声明为静态的
    private static int ticket = 100;

    //保证继承Thread类的所有对象共享一把锁，
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try {
                lock.lock();
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "正在卖出" + ticket + "号票");
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}