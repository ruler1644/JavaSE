package chaptor06_thread.chap02;

//生产者消费者问题
public class Code_09_ProductAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("Producer1:");
        p1.start();

        Consumer c1 = new Consumer(clerk);
        c1.setName("Consumer1:");
        c1.start();
    }
}

//共享资源
class Clerk {
    private int productCount = 0;

    //生产产品
    public synchronized void produce() {
        notify();
        if (productCount < 20) {
            System.out.println(Thread.currentThread().getName() + " 生产, 第 " + ++productCount + " 个产品");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumer() {
        notify();
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + " 消费, 第 " + productCount-- + " 个产品");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//生产者线程
class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产产品");
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}

//消费者线程
class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品");
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumer();
        }
    }
}