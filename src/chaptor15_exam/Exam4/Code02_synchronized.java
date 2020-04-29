package chaptor15_exam.Exam4;

//同步方法实现，初始值为0，两个线程一个加，一个减，交替打印，来5轮

//四个线程时，会产生虚假唤醒
//条件判断不能使用if，必须使用while循环不断进行条件判断
public class Code02_synchronized{
    public static void main(String[] args) {

        final NumberThread numberThread = new NumberThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(130);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    numberThread.add();
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
                    numberThread.reduce();
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
                    numberThread.add();
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
                    numberThread.reduce();
                }
            }
        }, "D").start();

    }
}

class NumberThread {
    private int num = 0;

    public synchronized void add() {

        while (num != 0) {
            try {
                wait();  //num = 1时, A释放锁wait,又有C获取锁，C也是释放锁wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "---->" + num);
        notifyAll();
    }

    public synchronized void reduce() {

        while (num == 0) {
            try {
                wait();           //num=0时，B释放锁wait,D获得锁，D又释放锁wait。当生产者生产完毕num为1，一下唤醒两个线程，减少两次产生-1，
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "---->" + num);
        notifyAll();   //num=0时,一下唤醒A和C两个线程导致num变成2
    }
}