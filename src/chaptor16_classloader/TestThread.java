package chaptor16_classloader;

public class TestThread {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product product = new Product(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(product, "生产者-->A ").start();
        new Thread(consumer, "消费者-->B ").start();
    }
}

class Clerk {
    private int num;

    public synchronized void product() throws Exception {
        notify();
        if (num < 10) {
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName() + "在生产" + (++num) + "号，剩余数目" + num);
        } else {
            wait();
        }
    }

    public synchronized void consumer() throws Exception {
        notify();
        if (num > 0) {
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName() + "在消费" + (num--) + "号，剩余数目" + num);
        } else {
            wait();
        }
    }
}

class Product implements Runnable {
    Clerk clerk;

    public Product(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            //for (int i = 0; i < 3; i++) {
            try {
                clerk.product();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable {
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            //for (int i = 0; i < 3; i++) {
            try {
                clerk.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}