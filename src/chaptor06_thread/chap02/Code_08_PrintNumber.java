package chaptor06_thread.chap02;
//两个线程交替打印1~10间的数字

public class Code_08_PrintNumber {
    public static void main(String[] args) {
        Number num = new Number();

        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);
        t1.setName("a");
        t2.setName("b");

        t1.start();
        t2.start();
    }
}


class Number implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                //唤醒了阻塞的线程，但是由于本线获取了同步锁，被唤醒的线程此时也只能等待
                notify();

                if (num <= 10) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "线程打印 " + num++);

                    try {
                        //wait会释放同步锁，这样才实现了线程的通信
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}