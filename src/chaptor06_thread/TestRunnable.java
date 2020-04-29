package chaptor06_thread;

//店员
class Clerk {
    int product;

    public synchronized void addProduct() {
        if (product >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product++;
            System.out.println(Thread.currentThread().getName() + "生产第" + product + "个产品");
            notify();
        }
    }

    public synchronized void consumeProduct() {
        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "消费第" + product + "个产品");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product--;
            notify();
        }
    }

}

//生产者
class Producer implements Runnable {
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            clerk.addProduct();
        }
    }
}

//消费者
class Customer implements Runnable {
    Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费产品");
        while (true) {
            clerk.consumeProduct();
        }
    }
}

public class TestRunnable {
    public static void main(String[] agrs) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Customer c = new Customer(clerk);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(p1);

        t1.setName("生产者线程1: ");
        t2.setName("消费者线程:");
        t3.setName("生产者线程2: ");

        t1.start();
        t2.start();
        t3.start();
    }
}
