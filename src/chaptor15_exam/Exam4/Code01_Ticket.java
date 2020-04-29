package chaptor15_exam.Exam4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用Lock实现，三个窗口卖出100张车票
public class Code01_Ticket {
    public static void main(String[] args) {
        final Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++)
                    ticket.sale();
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++)
                    ticket.sale();
            }
        }, "B").start();
    }
}

class Ticket {
    private int num = 30;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "卖出第" + (num--) + "张票,剩余" + num + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}